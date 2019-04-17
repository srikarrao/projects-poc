package com.java.iq.core.companies.bloomberg;

/**
 * https://www.careercup.com/question?id=5800210660327424
 * 
 * @author srikarrao
 *
 */
public class RemoveConsecutiveCharacters {

	public static void main(String[] args) {
		System.out.println("ABCD: " + removeCharacters("ABCD", 1));
		System.out.println("ABCD: " + removeCharacters("ABCD", 2));
		System.out.println("ABDCD: " + removeCharacters("ABDCD", 2));
		System.out.println("AADCCD: " + removeCharacters("AADCCD", 2));
		
		System.out.println("ABCCCBBA: " + removeCharacters("ABCCCBBA", 3));
		System.out.println("ABCCCBBA: " + removeCharacters("ABCCCBBA", 10));
		
		System.out.println("ABCCCCBBA: " + removeCharacters("ABCCCCBBA", 3));
		System.out.println("ABCCCCCCBBA: " + removeCharacters("ABCCCCCCBBA", 3));
		System.out.println("CCCCCCBBA: " + removeCharacters("CCCCCCBBA", 3));
		
		System.out.println("CCCCBBA: " + removeCharacters("CCCCBBA", 3));
		System.out.println("CCCCBBA: " + removeCharacters("CCCCBBA", 2));
		
		System.out.println("BBACCCCCC: " + removeCharacters("BBACCCCCC", 3));
		System.out.println("BBACCCCCC: " + removeCharacters("BBACCCCCC", 2));
		
		System.out.println("BBBCCCCCC: " + removeCharacters("BBBCCCCCC", 3));
		System.out.println("BBBCCCCCC: " + removeCharacters("BBBCCCCCC", 2));

		System.out.println("BBBCCCCCC: " + removeCharacters("BBBCCCCCC", 10));
	}

	private static String removeCharacters(String input, int n) {

		if (n == 0 || input == null || input.length() == 0 || input.trim().isEmpty()) {
			return input;
		}

		if (n == 1) {
			return "";
		}

		int i = 0;
		while (i < input.length()) {
			int j = i;
			boolean hasDuplicates = false;
			while (j < input.length() && input.charAt(j) == input.charAt(i)) {
				if (i != j) {
					hasDuplicates = true;
				}
				j++;
			}
			if (hasDuplicates && i != j && j - i >= n) {
				input = input.substring(0, i) + input.substring(j);
				i = 0;
				hasDuplicates = false;
			} else {
				i++;
			}
		}

		return input;
	}
}