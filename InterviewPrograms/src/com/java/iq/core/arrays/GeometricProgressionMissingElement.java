package com.java.iq.core.arrays;

/**
 * Find the missing number in Geometric Progression
 * 
 * @author srikarrao.gandla
 * 
 *         Source: http://www.geeksforgeeks.org/find-missing-number-geometric-
 *         progression/
 *
 */
public class GeometricProgressionMissingElement {

	public static void main(String[] args) {
		int arr[] = { 2, 4, 8, 32 };
		int n = arr.length;
		System.out.println(findMissing(arr, n));
	}

	private static int findMissingRec(int arr[], int low, int high, int ratio) {

		if (low >= high) {
			return Integer.MAX_VALUE;
		}
		
		int mid = low + (high - low) / 2;

		if (arr[mid + 1] / arr[mid] != ratio)
			return (arr[mid] * ratio);

		if ((mid > 0) && (arr[mid] / arr[mid - 1]) != ratio)
			return (arr[mid - 1] * ratio);

		if (arr[mid] == arr[0] * (Math.pow(ratio, mid)))
			return findMissingRec(arr, mid + 1, high, ratio);

		return findMissingRec(arr, low, mid - 1, ratio);
	}

	private static int findMissing(int arr[], int n) {
		int ratio = (int) Math.pow(arr[n - 1] / arr[0], 1.0 / n);

		return findMissingRec(arr, 0, n - 1, ratio);
	}

}
