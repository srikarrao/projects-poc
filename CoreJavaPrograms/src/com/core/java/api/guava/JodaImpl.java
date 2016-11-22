package com.core.java.api.guava;

import java.util.Calendar;
import java.util.Locale;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.DateTimeFormatterBuilder;

public class JodaImpl {

	public static void main(String[] args) {

		DateTime dt = new DateTime();
		Calendar jdkCal = dt.toCalendar(Locale.CHINESE);

		System.out.println(dt);

		// from JDK to Joda
		dt = new DateTime(jdkCal);
		System.out.println(dt);

		int iDoW = dt.getDayOfWeek();

		DateTime.Property pDoW = dt.dayOfWeek();
		String strST = pDoW.getAsShortText(); // returns "Mon", "Tue", etc.
		String strT = pDoW.getAsText();
		System.out.println(strT);

		System.out.println(dt.getEra());
		System.out.println(dt.getYear());
		System.out.println(dt.getWeekyear());
		System.out.println(dt.getCenturyOfEra());
		System.out.println(dt.getYearOfEra());
		System.out.println(dt.getYearOfCentury());
		System.out.println(dt.getMonthOfYear());
		System.out.println(dt.getWeekOfWeekyear());
		System.out.println(dt.getDayOfYear());
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.getDayOfWeek());

		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMdd");

		DateTimeFormatter fmt1 = new DateTimeFormatterBuilder()
				.appendDayOfMonth(2).appendLiteral('-')
				.appendMonthOfYearShortText().appendLiteral('-')
				.appendTwoDigitYear(1956) // pivot = 1956
				.toFormatter();

		String dateTime = "11/15/2013 08:00:00";
		// Format for input
		DateTimeFormatter dtf = DateTimeFormat
				.forPattern("MM/dd/yyyy HH:mm:ss");
		// Parsing the date
		DateTime jodatime = dtf.parseDateTime(dateTime);
		// Format for output
		DateTimeFormatter dtfOut = DateTimeFormat.forPattern("MM/dd/yyyy");
		// Printing the date
		System.out.println(dtfOut.print(jodatime));
	}

}
