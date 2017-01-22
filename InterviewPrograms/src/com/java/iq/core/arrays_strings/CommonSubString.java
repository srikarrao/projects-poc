package com.java.iq.core.arrays_strings;

/**
 * JAVA Program to find the first common substring
 * 
 * @author SrikarRao
 *
 */
public class CommonSubString {

	/**
	 * method to find first common substring
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static String findCommonSubstring(String s1, String s2) {
		boolean[] commonCharsArray = new boolean[26];
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z') {
				commonCharsArray[s1.charAt(i) - 'a'] = true;
			}
		}
		for (int i = 0; i < s2.length(); i++) {
			if ((s2.charAt(i) >= 'a' && s2.charAt(i) <= 'z')
					&& commonCharsArray[s2.charAt(i) - 'a'] == true) {
				return "YES";
			}
		}
		return "NO";
	}
}