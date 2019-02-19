package com.java.iq.core.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NgramGenerator {

	public static void main(String[] args) {
		System.out.println(generateNgrams("ABC", 3));
		System.out.println(generateNgrams("McDonalds world", 3));
		System.out.println(generateNgrams("Mc Donalds world", 3));
		System.out.println(generateNgrams("McDonalds ", 1));
		System.out.println(generateNgrams("M  ", 1));
		System.out.println(generateNgrams("M ", 1));
		System.out.println(generateNgrams(" ", 1));
		System.out.println(generateNgrams("", 1));
		System.out.println(generateNgrams(null, 1));
	}

	private static List<String> generateNgrams(String word, int ngram) {

		if (ngram == 0 || word == null) {
			return Collections.emptyList();
		}

		word = word.replace(" ", "");

		if (word.isEmpty()) {
			return Collections.emptyList();
		}

		if (ngram > word.length()) {
			throw new IllegalArgumentException("Invalid word or n-gram");
		}

		List<String> ngrams = new ArrayList<>();
		for (int i = 0; i <= word.length() - ngram; i++) {
			ngrams.add(word.substring(i, i + ngram).trim());
		}
		return ngrams;
	}
}