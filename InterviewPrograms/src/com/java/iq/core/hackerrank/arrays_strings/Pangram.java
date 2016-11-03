package com.java.iq.core.hackerrank.arrays_strings;

/**
 * JAVA program to find if the given string is a pangram
 * 
 * @author SrikarRao
 *
 */
public class Pangram {

	/**
	 * method to return if the given string is "pangram" or "non-pangram"
	 * 
	 * @param s
	 * @return
	 */
	private static String isPanagram(String s) {

		boolean[] isCharArray = new boolean[26];
		int count = 0;
		for (int i = 0; i < s.length(); i++) {

			if (count == 26) {
				return "pangram";
			}
			char character = s.charAt(i);
			int val = (character >= 'a' && character <= 'z' ? character - 'a'
					: (character >= 'A' && character <= 'Z' ? character - 'A'
							: -1));
			if (val >= 0) {
				if (!isCharArray[val]) {
					isCharArray[val] = true;
					count++;
				}
			}
		}

		return count == 26 ? "pangram" : "non-pangram";
	}
}
