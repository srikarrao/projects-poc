package com.java.iq.core.arrays;

/**
 * Source:
 * http://www.geeksforgeeks.org/given-an-array-arr-find-the-maximum-j-i-such
 * -that-arrj-arri/ <br>
 * 
 * Time Complexity: O (n) <br>
 * Space Complexity: O (n)
 * 
 * @author SrikarRao
 *
 */
public class MaximumIndex {

	public static void main(String[] args) {

		int arr1[] = { 34, 8, 10, 3, 2, 80, 30, 33, 1 };
		int maxDiff = maxIndexDiff2(arr1);
		System.out.println(maxDiff);

		int arr2[] = { 9, 2, 3, 4, 5, 6, 7, 8, 18, 0 };
		maxDiff = maxIndexDiff(arr2);
		System.out.println(maxDiff);

		int arr3[] = { 1, 2, 3, 4, 5, 6 };
		maxDiff = maxIndexDiff(arr3);
		System.out.println(maxDiff);

		int arr4[] = { 6, 5, 4, 3, 2, 1 };
		maxDiff = maxIndexDiff(arr4);
		System.out.println(maxDiff);

	}

	/**
	 * Naive method
	 * @param arr
	 * @return
	 */
	private static int maxIndexDiff(int[] arr) {
		int maxDiff = -1;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] > arr[i]) {
					int curr = j - i;
					maxDiff = Math.max(maxDiff, curr);
				}
			}
		}
		return maxDiff;
	}

	private static int maxIndexDiff2(int arr[]) {
		int maxDiff;
		int i, j;

		int n = arr.length;
		int RMax[] = new int[n];
		int LMin[] = new int[n];

		LMin[0] = arr[0];
		for (i = 1; i < n; ++i) {
			LMin[i] = Math.min(arr[i], LMin[i - 1]);
		}

		RMax[n - 1] = arr[n - 1];
		for (j = n - 2; j >= 0; --j)
			RMax[j] = Math.max(arr[j], RMax[j + 1]);

		i = 0;
		j = 0;
		maxDiff = -1;
		while (j < n && i < n) {
			if (LMin[i] < RMax[j]) {
				maxDiff = Math.max(maxDiff, j - i);
				j = j + 1;
			} else
				i = i + 1;
		}

		return maxDiff;
	}
}