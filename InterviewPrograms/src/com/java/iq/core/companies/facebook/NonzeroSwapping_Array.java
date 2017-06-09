package com.java.iq.core.companies.facebook;

import java.util.Arrays;

/**
 * Java program to shift zeros to left and non-zeros to right <br>
 * Source: http://www.geeksforgeeks.org/move-zeroes-end-array/ <br>
 * 
 * @author SrikarRao.Gandla
 *
 */
public class NonzeroSwapping_Array {

	public static int[] swapArrayElements(int[] numbers) {

		if (numbers == null || numbers.length == 0) {
			return null;
		}

		if (numbers == null || numbers.length == 0) {
			return numbers;
		}

		performNonZeroSwapping(numbers);
		System.out.println(Arrays.toString(numbers));
		return numbers;
	}

	/**
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param arr
	 */
	private static void performNonZeroSwapping(int[] arr) {

		int front = 0;
		int rear = arr.length - 1;

		while (front < rear) {

			while (front < arr.length && arr[front] == 0) {
				front++;
			}

			while (rear > 0 && arr[rear] != 0) {
				rear--;
			}

			if (front < rear && !(arr[front] == 0 && arr[rear] == 0) && !(arr[front] != 0 && arr[rear] != 0))
				swap(arr, front, rear);

		}
		front++;
		rear--;
	}

	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}