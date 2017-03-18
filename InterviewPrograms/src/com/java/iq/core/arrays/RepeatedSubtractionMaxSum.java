package com.java.iq.core.arrays;

/**
 * Source:
 * http://www.geeksforgeeks.org/find-maximum-sum-making-elements-repeated
 * -subtraction/<br>
 * Space Complexity: O(log n) // recursion stack<br>
 * Time Complexity: O (n log n)
 * 
 * @author SrikarRao
 *
 */
public class RepeatedSubtractionMaxSum {

	private static int GCD(int a, int b) {
		if (b == 0)
			return a;
		return GCD(b, a % b);
	}

	private static int findMaxSumUtil(int arr[], int n) {
		int finalGCD = arr[0];
		for (int i = 1; i < n; i++)
			finalGCD = GCD(arr[i], finalGCD);

		return finalGCD;
	}

	private static int findMaxSum(int arr[], int n) {
		int maxElement = findMaxSumUtil(arr, n);
		return (maxElement * n);
	}

	public static void main(String[] args) {
		int arr[] = { 8, 20, 12, 36 };
		int n = arr.length;
		System.out.println(findMaxSum(arr, n));
	}
}