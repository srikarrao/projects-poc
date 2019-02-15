package com.java.iq.core.bsearch;

import java.util.Arrays;

import org.junit.Assert;

public class AscendDescendMax {

	public static void main(String[] args) {
		Assert.assertEquals("Array is null", -1, findMaximum(null));
		Assert.assertEquals("Array with max at i=0", 0, findMaximum(new int[] { 100, 18, 15, 12, 3 }));
		Assert.assertEquals("Array with max at i=arr.length-2", 6,
				findMaximum(new int[] { 80, 99, 99, 100, 180, 1500, 3120, 3 }));
		Assert.assertEquals("Array with max at some random index", 2,
				findMaximum(new int[] { 80, 99, 199, 10, 8, 5, -1, -3 }));
		Assert.assertEquals("Array with max at middle of the array", 3,
				findMaximum(new int[] { 80, 99, 199, 200, 8, 5, -1, -3 }));
	}

	private static int findMaximum(int[] array) {
		int result = findMaximumInAscendDescend(array);
		System.out.println("Max is : " + result + " in array: " + Arrays.toString(array));
		return result;
	}

	private static int findMaximumInAscendDescend(int[] array) {
		if (array == null) {
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (mid == 0 || array[mid - 1] < array[mid] && array[mid + 1] < array[mid]) {
				return mid;
			} else if (array[mid - 1] > array[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}