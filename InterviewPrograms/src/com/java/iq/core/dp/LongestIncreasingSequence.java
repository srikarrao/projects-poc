package com.java.iq.core.dp;

/* Dynamic Programming Java implementation of LIS problem 
 * Source: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
 * */

public class LongestIncreasingSequence {
	/*
	 * list() returns the length of the longest increasing subsequence in arr[]
	 * of size n
	 */
	static int lis(int arr[], int n) {
		int lis[] = new int[n];
		int i, j, max = 0;

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++)
			if (max < lis[i])
				max = lis[i];

		return max + 1;
	}

	public static void main(String args[]) {
		int arr1[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int n1 = arr1.length;
		System.out.println("case-2: Length of list is " + lis(arr1, n1) + "\n");

		int arr2[] = { 3, 10, 2, 11 };
		int n2 = arr2.length;
		System.out.println("case-2: Length of list is " + lis(arr2, n2) + "\n");
	}

}
