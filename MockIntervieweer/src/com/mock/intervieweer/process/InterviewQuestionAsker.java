package com.mock.intervieweer.process;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class InterviewQuestionAsker {
	private static Map<Double, Double> questionsCount = new HashMap<Double, Double>();

	@SuppressWarnings("resource")
	public static Map<Double, Double> askQuestions(
			Map<Integer, String> interviewer) {
		boolean stopAsking = false;
		Scanner scn = new Scanner(System.in);
		double totalAsked = 0;
		double totalAnswered = 0;
		Set<Integer> numSet = new HashSet<Integer>();
		try {
			System.out.println("Interview begins!! All the best :-)");
			while (!stopAsking) {
				int qNum = new Random().nextInt(interviewer.size());
				if (numSet.add(qNum) && interviewer.get(qNum) != null) {
					System.out.println((QuestionsSaver.counter + 1) + ") "
							+ interviewer.get(qNum));
					Thread.sleep(1000 * 5);
					totalAsked++;
					System.out
							.println("Did the person answer?? Press 'Y' if answered else press any key!!");
					String hasAnswered = scn.nextLine();
					if (hasAnswered.equalsIgnoreCase("Y")) {
						totalAnswered++;
					} else {
						QuestionsSaver.saveQuestions(interviewer.get(qNum));
					}
					String decision = null;

					if (QuestionsSaver.counter == 25) {
						decision = "Y";
					} else {
						System.out.println("Wanna stop interviewing?? ");
						decision = scn.nextLine();
					}
					if (decision.equalsIgnoreCase("Y")) {
						stopAsking = true;
					}
				}
			}
			System.out.println("Interview completed!! Wait for the result!!");
			Thread.sleep(1000 * 25);
			questionsCount.put(totalAsked, totalAnswered);
		} catch (Exception e) {
			System.out.println("Exception in ask questions method!!");
		}
		return questionsCount;
	}
}
