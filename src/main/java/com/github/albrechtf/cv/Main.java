package com.github.albrechtf.cv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.lang3.StringUtils;
import org.xml.sax.SAXException;

import com.github.albrechtf.cv.generator.CvGenerator;
import com.github.albrechtf.cv.generator.CvGeneratorOptions;

public class Main {

	public static void main(String[] args) throws IOException, JAXBException, SAXException, TransformerException {
		CommandLineParser parser = new DefaultParser();
		CommandLine cl;
		try {
			cl = parser.parse(buildOptions(), args);
		} catch (ParseException e) {
			printOptions();
			System.exit(3);
			return;
		}

		if (cl.getArgList().size() != 2) {
			System.err.println("Wrong number of arguments");
			printOptions();
			System.exit(3);
		}

		File inJson = new File(cl.getArgs()[0]);
		File outPdf = new File(cl.getArgs()[1]);
		CvGeneratorOptions options = new CvGeneratorOptions();

		if (!inJson.isFile()) {
			System.err.println("Input JSON " + cl.getArgs()[0] + " does not exist!");
			printOptions();
			System.exit(3);
		}

		// test other options before creating and testing output file
		String sValue = cl.getOptionValue('s');
		if (StringUtils.isEmpty(sValue)) {
			options.setXsltFile(new File("resume.xsl"));
		}
		else {
			File inStylesheet = new File(sValue);
			if (!inStylesheet.isFile()) {
				System.err.println("Specified stylesheet " + sValue + " does not exist");
				printOptions();
				System.exit(3);
			}
			options.setXsltFile(inStylesheet);
		}

		sValue = cl.getOptionValue('p');
		URL photoUrl = null;
		if (!StringUtils.isEmpty(sValue)) {
			if (sValue.contains("://")) {
				try {
					photoUrl = new URL(sValue);
				} catch (MalformedURLException e) {
					System.err.println("Invalid photo URL specified");
					printOptions();
					System.exit(3);
				}
			}
			else {
				File f = new File(sValue);
				if (!f.isFile()) {
					System.err.println("Specified photo file " + sValue + " does not exist");
					printOptions();
					System.exit(3);
				}
				try {
					photoUrl = f.toURI().toURL();
				} catch (MalformedURLException e) {
					// should not occur for local files
					throw new RuntimeException(e);
				}
			}
		}
		options.setPhotoUrl(photoUrl);

		Locale locale = Locale.getDefault();
		if (cl.hasOption('l')) {
			locale = Locale.forLanguageTag(cl.getOptionValue('l'));
			if (locale == null) {
				locale = Locale.getDefault();
			}
		}
		options.setLocale(locale);

		// now, test creation of output file
		try {
			new FileOutputStream(outPdf).close();
		} catch (IOException e) {
			System.err.println("Cannot create output PDF file " + outPdf.getPath());
			System.exit(3);
		}
		
		new CvGenerator().generate(inJson, outPdf, options);
	}

	private static Options buildOptions() {
		Options options = new Options();
		options.addOption(Option.builder("s").longOpt("stylesheet")
				.desc("XSLT Stylesheet to use. Defaults to resume.xsl.").hasArg(true).argName("file").build());
		options.addOption(Option.builder("l").longOpt("locale")
				.desc("Locale to use, e.g. 'en' or 'de'. System default is used if not specified.").hasArg(true)
				.argName("locale").build());
		options.addOption(
				Option.builder("p").longOpt("photo")
						.desc("Photo file or URL to use. No photo is included if not specified.").hasArg(true)
						.argName("file or url").build());

		return options;
	}

	private static void printOptions() {
		HelpFormatter formatter = new HelpFormatter();
		formatter.setWidth(120);
		formatter.printHelp("java -jar cv.jar <OPTIONS> INFILE OUTFILE",
				"\nINFILE must be a JSON file in (customized) jsonresume format.\nOUTFILE is the name of a PDF file which will be created.\n ",
				buildOptions(), "");
		;
	}
}
