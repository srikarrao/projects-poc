package com.java.iq.core.strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeWords {
	private static String arrange(String sentence) {

		if (sentence == null || sentence.length() == 0) {
			return sentence;
		}

		if (sentence.trim().length() == 0) {
			return "";
		}

		String[] words = sentence.split("\\s+");
		words[words.length - 1] = words[words.length - 1].replace(".", "");

		if (words.length == 1) {
			return words[words.length - 1].length() == 0 ? "."
					: words[words.length - 1].substring(0, 1).toUpperCase() + words[0].substring(1) + ".";
		}

		sortWords(words);
		words[0] = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
		StringBuilder reformedSentence = new StringBuilder();
		for (int i = 0; i < words.length - 1; i++) {
			reformedSentence.append(words[i] + " ");
		}
		reformedSentence.append(words[words.length - 1] + ".");
		return reformedSentence.toString();
	}

	private static void sortWords(String[] words) {
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {

				int s1Length = o1.length();
				int s2Length = o2.length();

				if (s1Length < s2Length) {
					return -1;
				}

				return 1;
			}
		});
	}

	public static void main(String[] args) {
		assertEquals("Is is in Lover India.", arrange("Lover is is India in."));
		assertEquals("Is in is Lover lover India.", arrange("Lover is in lover India is."));
		assertEquals("Is is in love Lover lover India.", arrange("Lover is is lover India in love."));

		assertEquals("Is is in India lover Lover.", arrange("Is is in India lover Lover."));

		assertEquals(null, arrange(null));
		assertEquals("", arrange(""));
		assertEquals("", arrange(" "));

		assertEquals("I.", arrange("i"));
		assertEquals("I.", arrange("i."));
		assertEquals(".", arrange("."));

		assertEquals("Lover.", arrange("Lover."));

		assertEquals("Is in Love India.", arrange("Love is in India."));
		assertEquals("Is in is Lover India.", arrange("Lover is in India is."));
	}
}