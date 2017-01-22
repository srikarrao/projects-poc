package com.java.iq.core.arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JAVA program to find common characters count across various strings (a.k.a
 * Gemstones)
 * 
 * @author SrikarRao
 *
 */
public class CommonCharactersIntersect {

	public static void main(String[] args) {
		List<String> inputList = new ArrayList<String>(Arrays.asList("abcdde",
				"baccd", "eeabg"));
		System.out.println(getCommonElementsCount(inputList));
	}

	/**
	 * method to find the common elements count
	 * 
	 * @param stringsList
	 * @return
	 */
	public static int getCommonElementsCount(List<String> stringsList) {

		String s0 = stringsList.get(0);
		for (int i = 1; i < stringsList.size(); i++) {
			s0 = getIntersectedElements(s0, stringsList.get(i));
		}
		return s0.length();
	}

	/**
	 * method to intersect characters in two strings
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static String getIntersectedElements(String a, String b) {
		int i = 0;
		int j = 0;

		char[] arrayA = a.toCharArray();
		Arrays.sort(arrayA);
		char[] arrayB = b.toCharArray();
		Arrays.sort(arrayB);
		StringBuilder sb = new StringBuilder();
		while (i < arrayA.length && j < arrayB.length) {
			if (arrayA[i] == arrayB[j]
					&& (i == 0 || arrayA[i - 1] != arrayA[i])) {
				sb.append(arrayA[i]);
				i++;
				j++;
			} else if (arrayA[i] < arrayB[j]) {
				i++;
			} else {
				j++;
			}
		}
		return sb.toString();
	}
}