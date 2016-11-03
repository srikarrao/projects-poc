package com.java.iq.core.arrays_strings;

import java.util.Arrays;

/**
 * JAVA program to remove a given character in a String
 * 
 * @author SrikarRao
 *
 */
public class RemoveCharacter {

	public static void main(String[] args) {
		System.out.println(removeChar("srikar", 'r'));
	}

	public static String removeChar(String s, char c) {

		char[] stringArray = s.toCharArray();
		int iter = 0;
		for (int i = 0; i < stringArray.length; i++) {
			if (stringArray[i] != c) {
				stringArray[iter] = stringArray[i];
				iter++;
			}
		}
		return Arrays.toString(Arrays.copyOf(stringArray, iter));
	}
}
