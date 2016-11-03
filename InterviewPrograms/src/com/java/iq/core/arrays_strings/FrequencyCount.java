package com.java.iq.core.arrays_strings;

/**
 * Java program to implement the frequency count of characters in a string
 * 
 * @author SrikarRao
 *
 */
public class FrequencyCount {

	/**
	 * method to process the frequency count
	 * 
	 * @param arg
	 * @return
	 */
	public static String implementFrequencyCount(String arg) {
		return getFrequencyCount(arg);
	}

	/**
	 * method to get frequency count
	 * 
	 * @param input
	 * @return
	 */
	private static String getFrequencyCount(String input) {
		int[] counter = new int[128];
		for (int i = 0; i < input.length(); i++) {
			int x = (char) input.charAt(i);
			counter[x]++;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < counter.length; i++) {
			if (counter[i] != 0 && Character.isLetterOrDigit((char) i)) {
				char x = (char) i;
				sb.append("(" + x + " : " + counter[i] + ")");
			}
		}
		return sb.toString();
	}
}