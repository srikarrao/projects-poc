package com.java.iq.core.arrays_strings;

import java.util.Arrays;

/**
 * JAVA program to reverse a C Style String
 * 
 * @author SrikarRao
 *
 */
public class C_Style_String {

	public static void main(String[] args) {
		System.out.println(reverseCStyleString(new String("srikar ")
				.toCharArray()));
	}

	public static String reverseCStyleString(char[] input) {

		if (input != null && input.length <= 1) {
			return "";
		}

		int frontIter = 0;
		int backIter = input.length - 2;

		while (frontIter <= backIter) {
			char temp = input[frontIter];
			input[frontIter++] = input[backIter];
			input[backIter--] = temp;
		}
		return Arrays.toString(input);
	}
}
