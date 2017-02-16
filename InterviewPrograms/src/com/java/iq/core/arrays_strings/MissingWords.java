package com.java.iq.core.arrays_strings;

import java.util.*;

public class MissingWords {

	private static int kBase = 26, kMod = 997;

	public static void main(String[] args) {
		String[] arr = missingWords(
				"I am using HackerRank to improve programming",
				"am HackerRank to improve");
		for (String s : arr) {
			System.out.println(s);
		}
	}

	public static String[] missingWords(String s, String t) {

		String[] sArray = s.split("\\s+");
		List<String> wordsList = new ArrayList<String>();
		for (int i = 0; i < sArray.length; i++) {
			int res = rabinKarp(t, sArray[i]);
			if ( res == -1) {
				wordsList.add(sArray[i]);
			}
		}

		String[] missingWords = new String[wordsList.size()];
		missingWords = wordsList.toArray(missingWords);
		return missingWords;
	}

	public static int rabinKarp(String input, String sub) {

		if (input.length() < sub.length()) {
			return -1;
		}
		int inputHash = 0, subHash = 0;
		int PowerS = 1;
		for (int i = 0; i < sub.length(); i++) {
			PowerS = i > 0 ? PowerS * kBase % kMod : 1;
			inputHash = (inputHash * kBase + input.charAt(i)) % kMod;
			subHash = (subHash * kBase + sub.charAt(i)) % kMod;
		}

		for (int i = sub.length(); i < input.length(); i++) {
			if (inputHash == subHash
					&& input.substring(i - sub.length(), i).equals(sub)) {
				return i - sub.length();
			}
			inputHash -= (input.charAt(i - sub.length()) * PowerS) % kMod;
			if (inputHash < 0) {
				inputHash += kMod;
			}
			inputHash = (inputHash * kBase + input.charAt(i)) % kMod;
		}
		if (inputHash == subHash
				&& input.substring(input.length() - sub.length()).equals(sub)) {
			return input.length() - sub.length();
		}
		return -1;
	}
}