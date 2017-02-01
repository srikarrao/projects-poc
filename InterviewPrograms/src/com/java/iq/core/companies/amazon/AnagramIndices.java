package com.java.iq.core.companies.amazon;

// Java program to print indices of an anagram in a given string
public class AnagramIndices {

	static final int MAX = 128;

	static boolean compare(int arr1[], int arr2[]) {
		for (int i = 0; i < MAX; i++)
			if (arr1[i] != arr2[i])
				return false;
		return true;
	}

	static void search(char[] pattern, char[] text) {
		int M = pattern.length;
		int N = text.length;

		int[] countP = new int[MAX];
		int[] countTW = new int[MAX];

		for (int i = 0; i < M; i++) {
			int x = pattern[i];
			int y = text[i];
			countP[x]++;
			countTW[y]++;
		}

		for (int i = M; i < N; i++) {
			if (compare(countP, countTW))
				System.out.println("Found at Index " + (i - M));

			int y = text[i];
			countTW[y]++;

			int x = text[i - M];
			countTW[x]--;
		}

		if (compare(countP, countTW))
			System.out.println("Found at Index " + (N - M));
	}

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