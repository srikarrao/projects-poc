package com.java.iq.core.companies.amazon;

import java.util.*;

/**
 * JAVA program to find the two sum pairs for a given number
 * 
 * method1: Using Set data structure O(N) and O(N) space
 * 
 * method2: Using sorting, pointers from start, end O(N logN)
 * 
 * @author SrikarRao
 *
 */
public class TwoSumPairs {

	public static void main(String[] args) {
		int[] numbersWithoutDuplicates = { 2, 4, 3, 5, 7, 8, 9 };
		int[] numbersWithDuplicates = { 2, 4, 3, 3, 6, -2, 4, 7, 8, 9 };

		System.out.println("Pairs for arrays with duplicates using set");
		printPairsUsingSet(numbersWithoutDuplicates, 11);

		System.out.println("Pairs for arrays with duplicates using set");
		printPairsUsingSet(numbersWithDuplicates, 11);

		System.out
				.println("Pairs for arrays without duplicates using pointers");
		printPairsUsingTwoPointers(numbersWithoutDuplicates, 11);

		System.out.println("Pairs for arrays with duplicates using pointers");
		printPairsUsingTwoPointers(numbersWithDuplicates, 11);

	}

	/**
	 * method1: to find the two sum pairs using set
	 * 
	 * @param numbers
	 * @param n
	 */
	public static void printPairsUsingSet(int[] numbers, int n) {
		if (numbers.length < 2) {
			return;
		}
		Set<Integer> set = new HashSet<Integer>(numbers.length);
		for (int value : numbers) {
			int target = n - value;
			if (!set.contains(target)) {
				set.add(value); //
			} else {
				System.out.printf("(%d, %d) %n", value, target);
			}
		}
	}

	/**
	 * method2: to find the two sum pairs using pointers
	 * 
	 * @param numbers
	 * @param k
	 */
	public static void printPairsUsingTwoPointers(int[] numbers, int k) {
		if (numbers.length < 2) {
			return;
		}
		Arrays.sort(numbers);
		int left = 0;
		int right = numbers.length - 1;
		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == k) {
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
				left = left + 1;
				right = right - 1;
			} else if (sum < k) {
				left = left + 1;
			} else if (sum > k) {
				right = right - 1;
			}
		}
	}
}