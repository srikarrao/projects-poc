package com.java.iq.core.companies.uber;

import java.util.*;

/**
 * Given an input string of numbers like 121, find all permutations of that
 * number in the same order for the corresponding letters for each number so 121
 * => 1 2 1, 12 1, and 1 21 which is ABA, LA, and AT
 * 
 * @author SrikarRao
 *
 */
public class NumberToStringPermutations {

	public static void main(String[] args) {
		System.out.println(countDecodingDP("12", 2));
		System.out.println(countDecodingDP("121", 3));
		System.out.println(decode("", "711"));
	}

	/**
	 * Method to get the number of combinations
	 * 
	 * @param number
	 * @param n
	 * @return
	 */
	public static int countDecodingDP(String number, int n) {
		char[] digits = number.toCharArray();
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			count[i] = 0;
			if (digits[i - 1] > '0')
				count[i] = count[i - 1];

			if (digits[i - 2] < '2'
					|| (digits[i - 2] == '2' && digits[i - 1] < '7'))
				count[i] += count[i - 2];
		}
		return count[n];
	}

	/**
	 * method returning all words
	 * 
	 * @param prefix
	 * @param code
	 * @return
	 */
	public static Set<String> decode(String prefix, String code) {
		Set<String> set = new HashSet<String>();
		if (code.length() == 0) {
			set.add(prefix);
			return set;
		}

		if (code.charAt(0) == '0')
			return set;

		set.addAll(decode(prefix + (char) (code.charAt(0) - '1' + 'a'),
				code.substring(1)));
		if (code.length() >= 2 && code.charAt(0) == '1') {
			set.addAll(decode(
					prefix + (char) (10 + code.charAt(1) - '1' + 'a'),
					code.substring(2)));
		}
		if (code.length() >= 2 && code.charAt(0) == '2'
				&& code.charAt(1) <= '6') {
			set.addAll(decode(
					prefix + (char) (20 + code.charAt(1) - '1' + 'a'),
					code.substring(2)));
		}
		return set;
	}
}
