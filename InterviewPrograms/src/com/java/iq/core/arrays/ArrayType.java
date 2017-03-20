package com.java.iq.core.arrays;

/**
 * Java program to find type of array, ascending, descending, clockwise rotated
 * or anti-clockwise rotated
 *
 * @author srikarrao.gandla
 *
 */

public class ArrayType {

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	private static void findArrayType(int arr[]) {
		int n = arr.length;
		int i = 0;

		while (i < n - 1 && arr[i] < arr[i + 1])
			i++;

		if (i == n - 1) {
			System.out
					.println("Ascending with maximum element = " + arr[n - 1]);
			return;
		}

		// If first element is greater than next one
		if (i == 0) {
			while (i < n - 1 && arr[i] > arr[i + 1])
				i++;

			// If i reaches to last index
			if (i == n - 1) {
				System.out.println("Descending with maximum element = "
						+ arr[0]);
				return;
			}

			// If the whole array is not in decreasing order
			// that means it is first decreasing then
			// increasing, i.e., descending rotated, so
			// its maximum element will be the point breaking
			// the order i.e. i so, max will be i+1
			System.out.println("Descending rotated with maximum element = "
					+ max(arr[0], arr[i + 1]));
			return;
		}

		// If whole array is not increasing that means at some
		// point it is decreasing, which makes it ascending rotated
		// with max element as the decreasing point
		else {
			System.out.println("Ascending rotated with maximum element = "
					+ max(arr[0], arr[i]));
			return;
		}
	}

	public static void main(String[] args) {

		int arr1[] = { 4, 5, 6, 1, 2, 3 }; // Ascending rotated
		findArrayType(arr1);

		int arr2[] = { 2, 1, 7, 5, 4, 3 }; // Descending rotated
		findArrayType(arr2);

		int arr3[] = { 1, 2, 3, 4, 5, 8 }; // Ascending
		findArrayType(arr3);

		int arr4[] = { 9, 5, 4, 3, 2, 1 }; // Descending
		findArrayType(arr4);

	}
}
