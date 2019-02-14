package com.java.iq.core.bsearch;

import java.util.Arrays;

import org.junit.Assert;

/**
 * https://www.geeksforgeeks.org/find-local-minima-array/
 * 
 * @author srikarrao
 *
 */
class LocalMinima {

	public static int localMin(int[] arr) {

		int low = 0;
		int high = arr.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < arr[mid + 1] && (mid == 0 || arr[mid] < arr[mid - 1])) {
				return mid;
			} else if (mid > 0 && arr[mid - 1] < arr[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low == high ? low : -1;
	}

	private static int findLocalMinima(int[] array) {
		int result = localMin(array);
		System.out.println("Index of a local minima is : " + result + " in array: " + Arrays.toString(array));
		return result;
	}

	public static void main(String[] args) {
		Assert.assertEquals("test case 1", 1, findLocalMinima(new int[] { 100, 8, 15, 2, 3 }));
		Assert.assertEquals("test case 2", 2, findLocalMinima(new int[] { 9, 6, 3, 14, 5, 7, 4 }));
		Assert.assertEquals("test case 3", 1, findLocalMinima(new int[] { 23, 8, 15, 2, 3 }));
		Assert.assertEquals("test case 4", 0, findLocalMinima(new int[] { 1, 2, 3 }));
		Assert.assertEquals("test case 5", 2, findLocalMinima(new int[] { 3, 2, 1 }));
	}
}