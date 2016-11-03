package com.java.iq.core.arrays_strings;

/**
 * JAVA program to check if a string can form a formidable palindrome
 * 
 * @author SrikarRao
 *
 */
public class PalindromePermutation {

	/**
	 * method to implement if palindrome permutations exist
	 * 
	 * @param phrase
	 * @return
	 */
	public static boolean isPermutationPalindrome(String phrase) {
		int[] phraseArray = makeTable(phrase);
		return checkForPalindrome(phraseArray);
	}

	/**
	 * create an integer array [a - z] for the string given
	 * 
	 * @param phrase
	 * @return
	 */
	private static int[] makeTable(String phrase) {
		int[] array = new int[Character.getNumericValue('z')
				- Character.getNumericValue('a') + 1];
		for (int i = 0; i < phrase.length(); i++) {
			int x = getCount(phrase.charAt(i));
			if (x != -1) {
				array[x]++;
			}
		}
		return array;
	}

	/**
	 * get the numerical value for each character
	 * 
	 * @param c
	 * @return
	 */
	private static int getCount(char c) {
		int a = Character.getNumericValue('a');
		int z = Character.getNumericValue('z');
		int val = Character.getNumericValue(c);
		if (val >= a && val <= z) {
			return val - a;
		}
		return -1;
	}

	/**
	 * check if palindrome exist using the integer array
	 * 
	 * @param A
	 * @return
	 */
	private static boolean checkForPalindrome(int[] A) {
		boolean foundOdd = false;
		for (int x : A) {
			if (x % 2 == 1) {
				if (foundOdd) {
					return false;
				}
				foundOdd = true;
			}
		}
		return true;
	}
}