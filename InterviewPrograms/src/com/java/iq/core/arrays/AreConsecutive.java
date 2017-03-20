package com.java.iq.core.arrays;

/**
 * Source: http://www.geeksforgeeks.org/check-if-array-elements-are-consecutive/ <br>
 * Time Complexity: O (n) <br>
 * Space Complexity: O (1)
 * 
 * @author SrikarRao
 *
 */
public class AreConsecutive {

	/*
	 * The function checks if the array elements are consecutive If elements are
	 * consecutive, then returns true, else returns false
	 */
	boolean areConsecutive(int arr[], int n) {
		if (n < 1)
			return false;

		/* 1) Get the minimum element in array */
		int min = getMin(arr, n);

		/* 2) Get the maximum element in array */
		int max = getMax(arr, n);

		/* 3) max-min+1 is equal to n then only check all elements */
		if (max - min + 1 == n) {
			int i;
			for (i = 0; i < n; i++) {
				int j;

				if (arr[i] < 0) {
					j = -arr[i] - min;
				} else {
					j = arr[i] - min;
				}

				if (arr[j] > 0) {
					arr[j] = -arr[j];
				} else {
					return false;
				}
			}

			return true;
		}
		return false;
	}

	int getMin(int arr[], int n) {
		int min = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] < min)
				min = arr[i];
		}
		return min;
	}

	int getMax(int arr[], int n) {
		int max = arr[0];
		for (int i = 1; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

	/* Driver program to test above functions */
	public static void main(String[] args) {
		AreConsecutive consecutive = new AreConsecutive();
		int arr[] = { 5, 4, 2, 3, 1, 6 };
		int n = arr.length;
		if (consecutive.areConsecutive(arr, n) == true)
			System.out.println("Array elements are consecutive");
		else
			System.out.println("Array elements are not consecutive");
	}
}