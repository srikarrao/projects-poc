package com.java.iq.core.arrays_strings;

/**
 * JAVA program to find the minimum operations to convert a string as palindrome
 * 
 * @author SrikarRao
 *
 */
public class PalindromeConverter {

	/**
	 * method to find the minimum palindrome forming operations
	 * @param s
	 * @return
	 */
	public static int getMinNumOfOperations(String s) {
		int i = 0;
		int j = s.length() - 1;
		int numOfOperations = 0;

		while (i < j) {
			char I = s.charAt(i);
			char J = s.charAt(j);
			if ((Character.isLetter(I) && Character.isLetter(I)) && I != J) {
				numOfOperations += (I > J ? I - J : J - I);
			}
			i++;
			j--;
		}
		return numOfOperations;
	}
}
