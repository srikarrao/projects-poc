package com.java.iq.core.companies.uber;

import java.util.*;

/**
 * 
 * @author SrikarRao
 * 
 *         Given a string s and a dictionary of words dict, determine if s can
 *         be segmented into a space-separated sequence of one or more
 *         dictionary words.
 */

public class WordBreak {

	public static void main(String[] args) {
		String s = "leetcode";
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("leet");
		dictionary.add("code");
		System.out.println(wordBreak(s, dictionary));
	}

	public static boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] pos = new boolean[s.length() + 1];

		pos[0] = true;

		for (int i = 0; i < s.length(); i++) {
			if (!pos[i]) {
				for (int j = i + 1; j <= s.length(); j++) {
					String sub = s.substring(i, j);
					if (wordDict.contains(sub)) {
						pos[j] = true;
					}
				}
			}
		}

		return pos[s.length()];
	}

}