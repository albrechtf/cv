package com.github.albrechtf.cv.xslt;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class DateFunctions {

	private static Locale locale = Locale.getDefault();

	public static void setLocale(Locale locale) {
		DateFunctions.locale = locale;
	}

	public static String toMonthYear(String isoDate, String monthYearSeparator) {
		return new DateTimeFormatterBuilder().appendText(ChronoField.MONTH_OF_YEAR, TextStyle.FULL)
				.appendLiteral(monthYearSeparator)
				.appendText(ChronoField.YEAR).toFormatter(locale).format(DateTimeFormatter.ISO_DATE.parse(isoDate));

	}

}
