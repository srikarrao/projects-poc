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

	static void search(String pattern, String text) {
		int M = pattern.length();
		int N = text.length();

		int[] countP = new int[MAX];
		int[] countTW = new int[MAX];

		for (int i = 0; i < M; i++) {
			int x = pattern.charAt(i);
			int y = text.charAt(i);
			countP[x]++;
			countTW[y]++;
		}

		for (int i = M; i < N; i++) {
			if (compare(countP, countTW))
				System.out.println("Found at Index " + (i - M));

			countTW[text.charAt(i)]++;
			countTW[text.charAt(i - M)]--;
		}

		if (compare(countP, countTW))
			System.out.println("Found at Index " + (N - M));
	}

	public static void main(String[] args) {
		String txt1 = "SR_KAR";
		String pat1 = "_KA";
		System.out.println("test case-1");
		search(pat1, txt1);

		System.out.println("test case-2");
		String txt2 = "ABCDBACDAB";
		String pat2 = "AB";
		search(pat2, txt2);
	}
}