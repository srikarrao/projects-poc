package com.java.iq.core.companies.amazon;

/**
 * Given an array A of N elements, find maximum possible sum of Contiguous
 * Sub-Array/Non Contiguous Sub-Array
 * 
 * Kadane’s Algorithm
 * 
 * @author SrikarRao
 *
 */
public class MaximumSubArray {

	/**
	 * method to find the maximum contiguous Sub-Array
	 * 
	 * @return
	 */
	public static int maxSubArraySum(int[] a, int size) {

		int maxSoFar = 0;
		int maxEndingHere = 0;

		for (int i = 0; i < size; i++) {
			maxEndingHere = maxEndingHere + a[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			} else if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}
}