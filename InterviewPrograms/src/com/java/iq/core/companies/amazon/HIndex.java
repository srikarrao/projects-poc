package com.java.iq.core.companies.amazon;

import java.util.Arrays;

/**
 * Program to find the H-Index
 * 
 * @author SrikarRao
 *
 */
public class HIndex {

	public static void main(String[] args) {

		int[] arr2 = { 3, 0, 6, 1, 5 };
		int[] arr1 = { 4, 6, 9, 2, 1, 2 };

		System.out.println(hIndexOptimized(arr2));
		System.out.println(hIndexOptimized(arr1));

		System.out.println(hIndex(arr2));
		System.out.println(hIndex(arr1));
	}

	public static int hIndex(int[] citations) {
		Arrays.sort(citations);

		int result = 0;
		for (int i = 0; i < citations.length; i++) {
			int smaller = Math.min(citations[i], citations.length - i);
			result = Math.max(result, smaller);
		}

		return result;
	}

	public static int hIndexOptimized(int[] citations) {
		int l = citations.length;
		int[] bucket = new int[l + 1];
		for (int i : citations) {
			if (i > l)
				bucket[l]++;
			else
				bucket[i]++;
		}
		int sum = 0;
		for (int i = l; i >= 0; i--) {
			sum += bucket[i];
			if (sum >= i)
				return i;
		}
		return 0;
	}

}