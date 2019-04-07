package com.github.albrechtf.cv.generator;

import java.io.File;
import java.net.URL;
import java.util.Locale;

public final class CvGeneratorOptions {

	private File xsltFile;

	private Locale locale;

	private URL photoUrl;

	public File getXsltFile() {
		return xsltFile;
	}

	public void setXsltFile(File xsltFile) {
		this.xsltFile = xsltFile;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public URL getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(URL photoUrl) {
		this.photoUrl = photoUrl;
	}

}
