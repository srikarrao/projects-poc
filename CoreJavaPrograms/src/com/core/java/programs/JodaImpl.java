package com.core.java.programs;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

public class JodaImpl {

	public static void main(String[] args) {

		// Current timestamp
		DateTime currentTimestamp = new DateTime();
		
		// Yesterday timestamp starting 00:00:00
		DateTime yesterdayTimestamp = currentTimestamp.minusDays(1).withTime(0, 0, 0, 0);
		System.out.println("Yesterday Timestamp: " + yesterdayTimestamp);

		// Yesterday Date
		LocalDate yesterdayDate = new LocalDate().minusDays(1);
		System.out.println("Yesterday Date: " + yesterdayDate);

		// Tomorrow timestamp starting 00:00:00
		DateTime tomorrowTimestamp = currentTimestamp.plusDays(1).withTime(0, 0, 0, 0);
		System.out.println("Tomorrow Timestamp: " + tomorrowTimestamp);
	}

}
