package com.java.iq.core.arrays_strings;

/**
 * JAVA program to get the minimum number of required deletions to make
 * alternative characters
 * 
 * @author SrikarRao
 *
 */
public class AlternativeCharacters {

	/**
	 * method to get the number of deletions
	 * 
	 * @param input
	 * @return
	 */
	public static int getNumberOfDeletions(String input) {

		int numOfDels = 0;
		for (int i = 1; i < input.length(); i++) {
			if (input.charAt(i - 1) == input.charAt(i)) {
				numOfDels++;
			}
		}
		return numOfDels;
	}
}