package com.java.iq.core.arrays_strings;

/**
 * JAVA program check if one string permutation of another
 * 
 * @author SrikarRao
 *
 */
public class StringPermutation {

	public static void main(String[] args) {

		System.out.println(isStringPermutation("srikar", "siarkr"));
		System.out.println(isStringPermutation("srikar", "sjarkr"));
		System.out.println(isStringPermutation("srikar", "siarkfr"));
		System.out.println(isStringPermutation("srikar", null));
	}

	private static boolean isStringPermutation(String str1, String str2) {

		if (str1 == null && str2 == null) {
			return true;
		}
		if (str1 == null || str2 == null) {
			return false;
		}

		if (str1.length() != str2.length()) {
			return false;
		}

		int[] numArr = new int[128];
		char[] charArr = str1.toCharArray();

		for (char c : charArr) {
			numArr[c]++;
		}

		for (int i = 0; i < str2.length(); i++) {
			int c = (int) str2.charAt(i);
			numArr[c]--;
			if (numArr[c] < 0) {
				return false;
			}
		}
		return true;
	}
}