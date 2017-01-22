package com.java.iq.core.arrays_strings;

/**
 * JAVA Program to find if the string is funny. Suppose you have a String S,of
 * length N that is indexed from 0 to N-1. You also have some String R, that is
 * the reverse of String S.S is funny if the condition S(i)-S(i-1) ==
 * R(i)-R(i-1) is true for every character from to N-1.
 * 
 * @author SrikarRao
 *
 */
public class FunnyStrings {

	public static void main(String[] args) {
		System.out.println(findIfFunnyString("acxz"));
		System.out.println(findIfFunnyString("adxz"));
	}

	/**
	 * method to find if the string is funny
	 * 
	 * @param S
	 * @return
	 */
	private static String findIfFunnyString(String S) {

		int i = 1;
		int j = S.length() - 2;
		while (i < S.length() && j >= 0) {
			if (Math.abs(S.charAt(i) - S.charAt(i - 1)) != Math.abs(S.charAt(j)
					- S.charAt(j + 1))) {
				return "Not Funny";
			}
			i++;
			j--;
		}
		return "Funny";
	}
}