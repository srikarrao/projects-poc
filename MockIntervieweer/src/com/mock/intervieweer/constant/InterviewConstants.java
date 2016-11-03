package com.mock.intervieweer.constant;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public final class InterviewConstants {
	public static final Calendar CAL;
	public static final String FILE_LOCATION = "questionsFile/";
	public static final String FILE_LOCATION_ALL = "QandA/";
	public static final String SAVE_QUESTIONS_PER_DAY_LOCATION = "DailyAnswers/";
	public static Map<Integer, String> INTERVIEW_DAY_MAP = new HashMap<Integer, String>();
	static {
		CAL = Calendar.getInstance();
		CAL.setTime(new Date());
		INTERVIEW_DAY_MAP.put(1, "Sunday");
		INTERVIEW_DAY_MAP.put(2, "Monday");
		INTERVIEW_DAY_MAP.put(3, "Tuesday");
		INTERVIEW_DAY_MAP.put(4, "Wednesday");
		INTERVIEW_DAY_MAP.put(5, "Thursday");
		INTERVIEW_DAY_MAP.put(6, "Friday");
		INTERVIEW_DAY_MAP.put(7, "Saturday");
	}
}
