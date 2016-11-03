package com.java.iq.core.arrays_strings;

import java.util.Arrays;

/**
 * JAVA Class to replace duplicate characters in a String
 * 
 * @author SrikarRao
 *
 */
public class ReplaceDuplicates {

	/**
	 * @param charArray
	 * @return
	 */
	public static String replaceDuplicates(char[] charArray) {
		if (charArray == null || charArray.length == 0) {
			return "";
		}
		int checker = 0;
		int x = 0;
		for (int i = 0; i < charArray.length; i++) {
			int val = charArray[i] - 'a';
			if (!((checker & (1 << val)) > 0)) {
				charArray[x] = charArray[i];
				x++;
			}
			checker = checker | (1 << val);
		}
		return Arrays.toString(Arrays.copyOf(charArray, x));
	}
}