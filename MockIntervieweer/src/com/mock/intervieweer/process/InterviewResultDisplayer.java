package com.mock.intervieweer.process;

import java.util.Map;
import java.util.Map.Entry;

import com.mock.intervieweer.model.InterviewResult;

public class InterviewResultDisplayer {
	private static double asked = 0;
	private static double answered = 0;

	public static void displayResults(Map<Double, Double> result) {
		try {
			for (Entry<Double, Double> entry : result.entrySet()) {
				asked = entry.getKey();
				answered = entry.getValue();
			}
			System.out.println(calculateResult());
		} catch (Exception e) {
			System.out.println("Exception occurred displaying result!! " + e);
		}

	}

	private static InterviewResult calculateResult() {
		double marks = 0;
		double percentile = 0;
		String result = "";
		try {
			marks = answered * 10;
			percentile = (answered / asked) * 100;
			result = (percentile >= 90.0 ? "Pass"
					: ((percentile <= 90.0 && percentile >= 85.0) ? "Just passed"
							: "Failed"));
		} catch (Exception e) {
			System.out.println("Unable to calculate the result!! " + e);
		}
		return new InterviewResult(asked, answered, marks, percentile, result);
	}
}
