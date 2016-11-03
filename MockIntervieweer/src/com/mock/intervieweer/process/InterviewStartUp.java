package com.mock.intervieweer.process;

import java.util.Map;

public class InterviewStartUp {

	public static void main(String[] args) {
		Map<Integer, String> questions = InterviewQuestionsMaker
				.fetchQuestions();
		if (questions != null) {
			Map<Double, Double> res = InterviewQuestionAsker
					.askQuestions(questions);
			if (res != null) {
				InterviewResultDisplayer.displayResults(res);
			}
		}
	}
}
