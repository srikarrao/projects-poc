package com.java.iq.core.arrays_strings;

import java.util.HashMap;
import java.util.Map;

/**
 * JAVA program to find if the given string is a collection all unique
 * characters
 * 
 * @author SrikarRao
 *
 */
public class UniqueCharacters {

	public static void main(String[] args) {
		System.out.println(isUniqueBitwise("ab/f"));
		System.out.println(isUniqueArrays("AZaz"));
		System.out.println(isUniquehashmap("AZaz"));

	}

	/**
	 * Checking uniqueness using bitwise operators
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isUniqueBitwise(String s) {
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker = checker | (1 << val);
		}
		return true;
	}

	/**
	 * Checking uniqueness using boolean array
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isUniqueArrays(String s) {

		boolean[] charChecker = new boolean[128];
		for (int i = 0; i < s.length(); i++) {
			int x = s.charAt(i);

			if (x >= 65 && x <= 90) {
				x += 32;
			}

			if (charChecker[x] == true) {
				return false;
			}
			charChecker[x] = true;
		}
		return true;
	}

	/**
	 * Checking uniqueness using hashmap
	 * 
	 * @param s
	 * @return
	 */
	private static boolean isUniquehashmap(String s) {
		Map<Character, Integer> uniqueMap = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (uniqueMap.containsKey(s.charAt(i))) {
				return false;
			}
			uniqueMap.put(s.charAt(i), i);
		}
		return true;
	}
}