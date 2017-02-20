package com.java.iq.core.companies.twilio;

import java.util.*;

/**
 * Java program to find the string abbreviation
 * 
 * @author SrikarRao
 *
 */
public class StringAbbrevation {

	public static void main(String[] args) {
		String[] dictionary = { "plain", "amber", "blade" };
		// System.out.println(minAbbreviation("abc", dictionary));
		System.out.println(isValidAbbrForDictionaryWord("xyz", "x2"));
	}

	public static String minAbbreviation(String target, String[] dictionary) {
		if (target.length() == 0 || dictionary.length == 0) {
			return "";
		}

		PriorityQueue<String> queue = new PriorityQueue<>(
				new Comparator<String>() {
					@Override
					public int compare(String o1, String o2) {
						int ret = o1.length() - o2.length();
						if (ret == 0) {
							return o1.compareTo(o2);
						}
						return ret;
					}
				});

		getAbbreviations(queue, target, new StringBuilder(), 0, 0);

		while (!queue.isEmpty()) {
			String abbr = queue.poll();
			boolean allValid = true;
			for (String word : dictionary) {
				if (isValidAbbrForDictionaryWord(word, abbr)) {
					allValid = false;
					break;
				}
			}
			if (allValid) {
				return abbr;
			}
		}
		return "";
	}

	private static void getAbbreviations(PriorityQueue<String> queue,
			String target, StringBuilder curr, int pos, int count) {
		int len = curr.length();
		if (pos == target.length()) {
			if (count > 0) {
				curr.append(count);
			}
			System.out.println("Curr: " + curr.toString());
			queue.add(curr.toString());
		} else {
			getAbbreviations(queue, target, curr, pos + 1, count + 1);
			if (count > 0) {
				curr.append(count);
			}
			curr.append(target.charAt(pos));
			getAbbreviations(queue, target, curr, pos + 1, 0);
		}
		curr.setLength(len);
	}

	private static boolean isValidAbbrForDictionaryWord(String word, String abbr) {
		if (word.length() == 0) {
			return abbr.length() == 0;
		}
		int pW = 0, pA = 0;
		while (pW < word.length() && pA < abbr.length()) {
			char a = abbr.charAt(pA);
			if (Character.isLetter(a)) {
				if (word.charAt(pW) != abbr.charAt(pA)) {
					return false;
				}
				pW++;
				pA++;
			} else if (Character.isDigit(a)) {
				if (a == '0') {
					return false;
				}
				int org = pA;
				while (pA < abbr.length() && Character.isDigit(abbr.charAt(pA))) {
					pA++;
				}
				int num = Integer.valueOf(abbr.substring(org, pA));
				while (pW < word.length() && num > 0) {
					pW++;
					num--;
				}
				if (num > 0) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
}