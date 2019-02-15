package com.java.iq.core.bsearch;

import org.junit.Assert;

public class CircularArraySearch {

	public static void main(String[] args) {
		Assert.assertEquals("Null array", -1, search(null, 0, 9, 550));
		Assert.assertEquals("Empty array", -1, search(new int[] {}, 0, 9, 550));
		Assert.assertEquals("Random Index", 2,
				search(new int[] { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 }, 0, 9, 550));
		Assert.assertEquals("Middle Index", 4,
				search(new int[] { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 }, 0, 9, 103));
		Assert.assertEquals("Index zero", 0,
				search(new int[] { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 }, 0, 9, 378));
		Assert.assertEquals("Index Array.length - 1", 9,
				search(new int[] { 378, 478, 550, 631, 103, 203, 220, 234, 279, 368 }, 0, 9, 368));
		Assert.assertEquals("Array length 2, Index 0", 0, search(new int[] { 378, 478 }, 0, 1, 378));
		Assert.assertEquals("Array Length 2, Index 1", 1, search(new int[] { 378, 478 }, 0, 1, 478));
		Assert.assertEquals("Array Length 1. Found!", 0, search(new int[] { 478 }, 0, 0, 478));
		Assert.assertEquals("Array Length 1. Not Found!", -1, search(new int[] { 111 }, 0, 0, 478));
	}

	private static int search(int[] array, int low, int high, int searchNumber) {

		if (array == null || array.length == 0) {
			return -1;
		}

		if (low == high && array[low] == searchNumber) {
			return low;
		}

		while (low < high) {
			int mid = low + (high - low) / 2;
			int midValue = array[mid];

			if (midValue == searchNumber) {
				return mid;
			} else {
				int leftValue = search(array, low, mid - 1, searchNumber);
				int rightValue = search(array, mid + 1, high, searchNumber);
				int result = -1;

				if (leftValue != -1 && array[leftValue] == searchNumber) {
					result = leftValue;
				}

				if (rightValue != -1 && array[rightValue] == searchNumber) {
					result = rightValue;
				}

				return result;
			}
		}
		return -1;
	}
}
