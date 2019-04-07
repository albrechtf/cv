package com.github.albrechtf.cv.generator;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.ErrorListener;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopConfParser;
import org.apache.fop.apps.FopFactoryBuilder;
import org.apache.fop.apps.MimeConstants;
import org.xml.sax.SAXException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.albrechtf.cv.model.Resume;
import com.github.albrechtf.cv.xslt.DateFunctions;

public class CvGenerator {

	private static ErrorListener errorListener = new ErrorListener() {
		@Override
		public void warning(TransformerException exception) throws TransformerException {
			System.err.println(exception.getMessage());
		}

		@Override
		public void fatalError(TransformerException exception) throws TransformerException {
			throw exception;
		}

		@Override
		public void error(TransformerException exception) throws TransformerException {
			throw exception;
		}

	};

	public void generate(File inJson, File outPdf, CvGeneratorOptions options)
			throws IOException, JAXBException, SAXException, TransformerException {
		Resume resume = readJson(inJson);

		ByteArrayOutputStream xmlBuffer = new ByteArrayOutputStream();
		convertToXml(resume, xmlBuffer);


		try (FileOutputStream fos = new FileOutputStream(outPdf);
				FileInputStream fisXsl = new FileInputStream(options.getXsltFile())) {
			StreamSource xslSource = new StreamSource(fisXsl);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(xslSource);
			transformer.setErrorListener(errorListener);

			Source src = new StreamSource(new ByteArrayInputStream(xmlBuffer.toByteArray()));
			Fop fop = createFop(fos);

			LocalizationHelper.setLocalizedTexts(transformer, options.getLocale());
			if (options.getPhotoUrl() != null) {
				transformer.setParameter("photo.url", options.getPhotoUrl().toString());
			}

			// custom XSLT functions must also use configured locale!
			DateFunctions.setLocale(options.getLocale());

			transformer.transform(src, new SAXResult(fop.getDefaultHandler()));
		}
	}

	private Resume readJson(File jsonFile) throws IOException {
		return new ObjectMapper().readValue(jsonFile, Resume.class);
	}

	private void convertToXml(Resume resume, OutputStream outXml) throws IOException, JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(Resume.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.FALSE);
		jaxbMarshaller.marshal(resume, outXml);
	}

	private static Fop createFop(OutputStream out) throws SAXException, IOException {
		URI baseUri = new File(System.getProperty("user.dir")).getAbsoluteFile().toURI();

		try (InputStream in = CvGenerator.class.getClassLoader().getResourceAsStream("fop-config.xml")) {
			FopConfParser fopConfParser = new FopConfParser(in, baseUri);
			FopFactoryBuilder fopFactoryBuilder = fopConfParser.getFopFactoryBuilder();
			return fopFactoryBuilder.build().newFop(MimeConstants.MIME_PDF, out);
		}
	}


}
