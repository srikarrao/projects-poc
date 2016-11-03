package com.core.java.programs;

import java.util.Scanner;

public class JerkFactor {

	public static void main(String[] args) {
		try {
			System.out
					.println("Check your chances of being a jerk when proposed a girl!! :D :D :D");
			Scanner scn = new Scanner(System.in);
			System.out
					.println("Enter the number of friends the girl has in Facebook");
			int numOfFBFriends = scn.nextInt();
			if (numOfFBFriends >= 100) {
				System.out.println("Enter the number of people proposed");
				int numOfPeopleProposed = scn.nextInt();
				if (numOfPeopleProposed < numOfFBFriends) {
					findJerkPossibility(numOfFBFriends, numOfPeopleProposed);
				} else {
					System.out
							.println("The number of people proposed is wrong, please don't lie!!");
				}
			} else {
				System.out
						.println("Sorry!! This programs expects a person to atleast 100 friends to estimate the jerk factor ");
			}
		} catch (Exception e) {
			System.out
					.println("Are you crazy!! Provide a number as an input!!!"
							+ e);
		}
	}

	public static void findJerkPossibility(int fb, int proposed)
			throws Exception {
		float numOfKins = (fb / 100) * 5;
		float numOfMaleFriends = (fb / 2) - numOfKins;
		if (proposed > 0) {
			if (numOfMaleFriends != 0) {
				if (proposed < numOfMaleFriends) {
					float jerkfactor = proposed / numOfMaleFriends;
					System.out.println("There are " + (jerkfactor * 100)
							+ "% chances of you being a jerk");
				} else {
					System.out
							.println("The number of people proposed is wrong, please don't lie!!");
				}
			} else {
				System.out.println("Kudos kid!! Got no male friends");
			}
		} else {
			System.out
					.println("You are the first one to propose 'ALL THE BEST' ");
		}
	}
}
