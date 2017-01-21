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

		int[] arr = { 4, 6, 9, 2, 1, 2};

		System.out.println(hIndex(arr));
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
}
