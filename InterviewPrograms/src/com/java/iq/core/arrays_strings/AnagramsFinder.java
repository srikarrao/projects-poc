package com.java.iq.core.arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * JAVA program to find if the given strings are anagrams
 * 
 * @author SrikarRao
 *
 */
public class AnagramsFinder {

	/**
	 * method to find if the two string are anagrams (using arrays sortings)
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean areAnagrams_sorting(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}
		char[] array1 = str1.toCharArray();
		Arrays.sort(array1);
		char[] array2 = str2.toCharArray();
		Arrays.sort(array2);
		if (String.valueOf(array1).equals(String.valueOf(array2))) {
			return true;
		}
		return false;
	}

	public static boolean areAnagrams_hashMap(String str1, String str2) {

		Map<Character, Integer> charactersMap = new HashMap<Character, Integer>();

		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		int i = 0;
		while (i < str1.length()) {
			char val = str1.charAt(i++);
			if (charactersMap.containsKey(val)) {
				charactersMap.put(val, charactersMap.get(val) + 1);
			} else {
				charactersMap.put(val, 1);
			}
		}

		int j = 0;
		while (j < str2.length()) {
			char val = str2.charAt(j++);
			if (!charactersMap.containsKey(val)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * method to find if the two string are anagrams (using conventional way)
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean areAnagrams_conventional(String str1, String str2) {

		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		int[] letters = new int[256];
		char[] str1Array = str1.toCharArray();
		char[] str2Array = str2.toCharArray();
		int uniqueCount = 0;
		for (int i = 0; i < str1Array.length; i++) {

			int x = str1Array[i] - 'a';
			if (letters[x] == 0) {
				uniqueCount++;
				letters[x]++;
			}
		}
		int numOfCharsCount = 0;
		for (int j = 0; j < str2Array.length; j++) {
			int x = str2Array[j] - 'a';
			if (letters[x] == 0) {
				return false;
			}
			letters[x]--;
			if (letters[x] == 0) {
				numOfCharsCount++;
				if (numOfCharsCount == uniqueCount) {
					return j == str2Array.length - 1;
				}
			}
		}
		return true;
	}

}