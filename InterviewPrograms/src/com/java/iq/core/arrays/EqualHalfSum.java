package com.java.iq.core.arrays;

import java.util.*;

/**
 * Source:
 * http://www.geeksforgeeks.org/check-exist-two-elements-array-whose-sum-
 * equal-sum-rest-array/
 * 
 * @author srikarrao.gandla
 *
 */
public class EqualHalfSum {

	public static void main(String[] args) {
		int arr[] = { 2, 11, 5, 1, 4, 7 };
		int n = arr.length;
		if (checkPair(arr, n) == false)
			System.out.println("No pair found");

	}

	private static boolean checkPair(int arr[], int n) {
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		if (sum % 2 != 0)
			return false;

		sum = sum / 2;

		Set<Integer> S = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			int val = sum - arr[i];

			if (S.contains(val)) {
				System.out.println("Pair elements are " + arr[i] + "," + val);
				return true;
			}

			S.add(arr[i]);
		}

		return false;
	}

}