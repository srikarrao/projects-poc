package com.java.iq.core.arrays_strings;

import java.util.Arrays;

/**
 * JAVA Class to replace duplicate characters in a String
 * 
 * @author SrikarRao
 *
 */
public class ReplaceDuplicates_2 {

	/**
	 * @param charArray
	 * @return
	 */
	public static String replaceDuplicates(char[] charArray) {
		if (charArray == null || charArray.length == 0) {
			return "";
		}
		Arrays.sort(charArray);
		int x = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (i == 0 || charArray[i] != charArray[i - 1]) {
				charArray[x++] = charArray[i];
			}
		}
		return Arrays.toString(Arrays.copyOf(charArray, x));
	}
}