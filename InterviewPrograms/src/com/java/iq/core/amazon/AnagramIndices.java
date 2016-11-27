package com.java.iq.core.amazon;

// Java program to print indices of an anagram in a given string
public class AnagramIndices {

	static final int MAX = 128;

	// This function returns true if contents of arr1[] and arr2[]
	// are same, otherwise false.
	static boolean compare(int arr1[], int arr2[]) {
		for (int i = 0; i < MAX; i++)
			if (arr1[i] != arr2[i])
				return false;
		return true;
	}

	// This function search for all permutations of pat[] in txt[]
	static void search(char[] pattern, char[] text) {
		int M = pattern.length;
		int N = text.length;

		// countP[]: Store count of all characters of pattern
		// countTW[]: Store count of current window of text
		int[] countP = new int[MAX];
		int[] countTW = new int[MAX];

		for (int i = 0; i < M; i++) {
			int x = pattern[i];
			int y = text[i];
			countP[x]++;
			countTW[y]++;
		}

		// Traverse through remaining characters of pattern
		for (int i = M; i < N; i++) {
			// Compare counts of current window of text with
			// counts of pattern[]
			if (compare(countP, countTW))
				System.out.println("Found at Index " + (i - M));

			int y = text[i];
			// Add current character to current window
			countTW[y]++;

			int x = text[i - M];
			// Remove the first character of previous window
			countTW[x]--;
		}

		// Check for the last window in text
		if (compare(countP, countTW))
			System.out.println("Found at Index " + (N - M));
	}

	/* Driver program to test above function */
	public static void main(String[] args) {
		char txt1[] = "BACDGABCDA".toCharArray();
		char pat1[] = "ABCD".toCharArray();
		System.out.println("test case-1");
		search(pat1, txt1);
		System.out.println("test case-2");

		char txt2[] = "ABCDBACDAB".toCharArray();
		char pat2[] = "AB".toCharArray();

		search(pat2, txt2);
	}

}