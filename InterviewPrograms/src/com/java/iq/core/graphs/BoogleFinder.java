package com.java.iq.core.graphs;

import java.util.*;

public class BoogleFinder {

	private static final Set<String> dictionary = new HashSet<String>(
			Arrays.asList("GEEKS", "FOR", "QUIZ", "GO"));

	// A recursive function to print all words present on boggle
	private static void findWordsUtil(List<List<Character>> boggle,
			List<List<Boolean>> visited, int i, int j, String str) {

		visited.get(i).set(j, true);
		str = str + boggle.get(i).get(j);

		if (dictionary.contains(str)) {
			System.out.println(str);
		}

		for (int row = i - 1; row <= i + 1 && row < visited.size(); row++) {
			for (int col = j - 1; col <= j + 1 && row >= 0
					&& col < visited.get(row).size(); col++) {
				if (row >= 0 && col >= 0 && !visited.get(row).get(col)) {
					findWordsUtil(boggle, visited, row, col, str);
				}
			}
		}

		StringBuilder sb = new StringBuilder(str);
		sb.deleteCharAt(str.length() - 1);
		str = sb.toString();
		visited.get(i).set(j, false);
	}

	// Prints all words present in dictionary.
	private static void findWords(List<List<Character>> boggle) {
		List<List<Boolean>> visited = new ArrayList<>(boggle.size());
		String str = "";

		for (int i = 0; i < boggle.size(); i++) {
			visited.add(new ArrayList<Boolean>(Collections.nCopies(boggle
					.get(i).size(), false)));
		}
		for (int i = 0; i < visited.size(); i++) {
			for (int j = 0; j < visited.get(i).size(); j++) {
				findWordsUtil(boggle, visited, i, j, str);
			}
		}
	}

	public static void main(String[] args) {
		List<List<Character>> boggle = new ArrayList<List<Character>>();
		boggle.add(Arrays.asList('G', 'I', 'Z'));
		boggle.add(Arrays.asList('U', 'E', 'K'));
		boggle.add(Arrays.asList('Q', 'S', 'E'));
		System.out.println("Following words of dictionary are present");
		findWords(boggle);
	}
}
