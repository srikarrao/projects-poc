package com.java.iq.core.arrays_strings;

/**
 * JAVA class to check of two string are one edit away
 * 
 * @author SrikarRao
 *
 */
public class OneEditString {

	/**
	 * method to check if the strings are one edit away
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public static boolean checkIfOneEditAway(String A, String B) {
		// return false if any string is null
		if (A == null || B == null || Math.abs(A.length() - B.length()) > 1) {
			return false;
		}

		// if lengths equal then only replace occurs
		if (A.length() == B.length()) {
			return oneEditReplace(A, B);
		} // if lengths unequal then insert occurs
		else if (A.length() - 1 == B.length()) {
			return oneEditInsert(A, B);
		} else {
			return oneEditInsert(B, A);
		}
	}

	/**
	 * method to check if insert is applicable
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	private static boolean oneEditInsert(String A, String B) {
		int i = 0;
		int j = 0;
		while (i < A.length() && j < B.length()) {
			// if characters of strings are equal
			if (A.charAt(i) == B.charAt(j)) {
				i++;
				j++;
			} else {
				if (i != j) {
					return false;
				}
				i++;
			}
		}
		return true;
	}

	/**
	 * method to check if replace is applicable
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	private static boolean oneEditReplace(String A, String B) {
		boolean isDiff = false;
		if (A.equals(B)) {
			return false;
		}
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i)) {
				if (isDiff) {
					return false;
				}
				isDiff = true;
			}
		}
		return true;
	}
}