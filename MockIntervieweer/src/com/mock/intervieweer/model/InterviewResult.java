package com.mock.intervieweer.model;

public class InterviewResult {
	private double asked;
	private double answered;
	private double marks;
	private double percentile;
	private String result;

	public InterviewResult(double asked, double answered, double marks,
			double percentile, String InterviewResult) {

		this.asked = asked;
		this.answered = answered;
		this.marks = marks;
		this.percentile = percentile;
		this.result = InterviewResult;
	}

	@Override
	public String toString() {
		return result + "--> questions_asked :: " + asked
				+ " questions_answered :: " + answered + " marks :: " + marks
				+ " :: percentile " + percentile;
	}
}