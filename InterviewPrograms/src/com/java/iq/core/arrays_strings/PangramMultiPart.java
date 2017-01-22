package com.java.iq.core.arrays_strings;

/**
 * JAVA program to find if the given string is a pangram
 * 
 * @author SrikarRao
 *
 */
public class PangramMultiPart {

	public static void main(String[] args) {

		String[] arr = new String[4];
		arr[0] = "we promplty judged antique ivory buckles for the next prize";
		arr[1] = "we promplty judged antique ivory buckles for the prizes";
		arr[2] = "the quick brown fox jumps over the lazy dog";
		arr[3] = "the quick brown fox jump over the lazy dog";

		for (String s : arr) {
			System.out.println("method-1: " + isPanagram(s));
			System.out.println("method-2: " + isPanagramMultipart(s));
		}

	}

	/**
	 * method to return if the given string is "pangram" or "non-pangram"
	 * 
	 * @param s
	 * @return
	 */
	private static String isPanagram(String str) {

		boolean[] isCharArray = new boolean[26];
		int count = 0;

		for (int i = 0; i < str.length(); i++) {

			if (count == 26) {
				return "pangram";
			}
			char character = str.charAt(i);
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

		if (count == 26) {
			return "pangram";
		}
		return "not pangram";
	}

	private static String isPanagramMultipart(String s) {

		int[] isCharArray = new int[26];
		for (int i = 0; i < isCharArray.length; i++) {
			isCharArray[i] = -1;
		}
		int count = 0;
		for (int i = 0; i < s.length(); i++) {

			char character = s.charAt(i);
			int val = (character >= 'a' && character <= 'z' ? character - 'a'
					: (character >= 'A' && character <= 'Z' ? character - 'A'
							: -1));
			if (val >= 0) {
				if (isCharArray[val] == -1) {
					count++;
				}
				isCharArray[val]++;
			}
		}

		String res = "not pangram";
		if (count == 26) {
			int x = isMultiPangram(isCharArray);
			if (x != -1) {
				res = "multiple panagram " + (x + 1);
			} else {
				res = "pangram";
			}
		}
		return res;
	}

	public static int isMultiPangram(int[] arr) {
		int val = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != val) {
				return -1;
			}
		}
		return val;
	}
}