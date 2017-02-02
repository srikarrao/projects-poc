package com.java.iq.core.companies.amazon;

/**
 * Java program to print all combination of size r in an array of size n
 * 
 * @author SrikarRao
 *
 */
public class ListCombinations {

	private static void combinationUtil(int IP[], int OP[], int start, int end,
			int index, int printSize) {

		if (index == printSize) {
			for (int j = 0; j < printSize; j++)
				System.out.print(OP[j] + " ");
			System.out.println("");
			return;
		}

		for (int i = start; i < end && end - i + 1 > printSize - index; i++) {
			OP[index] = IP[i];
			combinationUtil(IP, OP, i + 1, end, index + 1, printSize);
		}
	}

	private static void printCombination(int IP[], int end, int printSize) {
		int OP[] = new int[printSize];
		int start = 0;
		int index = 0;
		combinationUtil(IP, OP, start, end, index, printSize);
	}

	public static void main(String[] args) {
		int IP[] = { 1, 2, 3, 4, 5 };
		int printSize = 4;
		int arrSize = IP.length;
		printCombination(IP, arrSize, printSize);
	}
}