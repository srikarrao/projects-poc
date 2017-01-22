package com.java.iq.core.arrays_strings;

/**
 * JAVA Program to find the index of character in string such that on removing
 * the character then forms a palindrome
 * 
 * @author SrikarRao
 *
 */
public class PalindromeIndex {

	/**
	 * method to find the index of removal character
	 * 
	 * @param S
	 * @return
	 */
	public static int findPalindromeIndex(String S) {

		int start = 0;
		int end = S.length() - 1;

		while (start < end) {
			if (S.charAt(start) != S.charAt(end)) {
				if (isPalindrome(S.substring(start, end))) {
					return end;
				} else if (isPalindrome(S.substring(start + 1, end + 1))) {
					return start;
				}
			}
			start++;
			end--;
		}
		return -1; // cannot be formidable palindrome word
	}

	/**
	 * method to check if it is a palindrome
	 * 
	 * @param P
	 * @return
	 */
	public static boolean isPalindrome(String P) {
		int i = 0;
		int j = P.length() - 1;
		while (i < j) {

			if (P.charAt(i) != P.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
