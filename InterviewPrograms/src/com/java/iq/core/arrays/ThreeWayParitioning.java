package com.java.iq.core.arrays;

/**
 * Source:
 * http://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around
 * -a-given-range/ <br>
 * Time Complexity : O(n) <br>
 * Auxiliary Space : O(1)
 * 
 * @author SrikarRao
 *
 */
public class ThreeWayParitioning {

	public static void threeWayPartition(int[] arr, int lowVal, int highVal) {

		int n = arr.length;
		int start = 0, end = n - 1;

		for (int i = 0; i < end;) {
			if (arr[i] < lowVal) {
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
				i++;
			} else if (arr[i] > highVal) {
				int temp = arr[end];
				arr[end] = arr[i];
				arr[i] = temp;
				end--;
			} else {
				i++;
			}
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32 };
		threeWayPartition(arr, 10, 20);

		System.out.println("Modified array ");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}