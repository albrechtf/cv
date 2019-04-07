package com.github.albrechtf.cv.generator;

import java.util.Enumeration;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import javax.xml.transform.Transformer;

public final class LocalizationHelper {

	private LocalizationHelper() {
	}

	public static void setLocalizedTexts(Transformer transformer, Locale locale) {
		try {
			ResourceBundle bundle = ResourceBundle.getBundle("messages", locale);
			Enumeration<String> keys = bundle.getKeys();
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				if (key.startsWith("text.")) {
					transformer.setParameter(key, bundle.getString(key));
				}
			}
		} catch (MissingResourceException e) {
			if (!"en".equals(locale.getLanguage())) {
				System.err.println(
						"Could not find localizations for locale " + locale + ". Using default (english) texts.");
			}
		}
	}

}
