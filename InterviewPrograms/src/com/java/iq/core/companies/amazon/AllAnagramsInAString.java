package com.java.iq.core.companies.amazon;

import java.util.*;

/**
 * Find All Anagrams in a String
 * 
 * @author SrikarRao
 *
 */
public class AllAnagramsInAString {

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("abab", "ab"));
	}

	/**
	 * Time O(n)
	 * @param s
	 * @param p
	 * @return
	 */
	private static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list = new ArrayList<>();

		if (s == null || s.length() == 0 || p == null || p.length() == 0) {
			return list;
		}
		int[] hash = new int[256];

		for (char c : p.toCharArray()) {
			hash[c]++;
		}

		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {

			if (hash[s.charAt(right++)]-- >= 1)
				count--;

			if (count == 0)
				list.add(left);

			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0)
				count++;
		}
		return list;
	}
}