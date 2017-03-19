package com.java.iq.core.companies.amazon;

/**
 * Given an array, find the maximum difference between two array elements given
 * the second element comes after the first
 *
 * Source: http://www.geeksforgeeks.org/maximum-difference-between-two-elements/ <br>
 * Space Complexity: O (1) <br>
 * Time Complexity: O (N)
 * 
 * @author SrikarRao.Gandla
 *
 */
public class MaxDifference {

	public static int maxDiff(int arr[], int arr_size) {
		int max_diff = arr[1] - arr[0];
		int min_element = arr[0];
		int i;
		for (i = 1; i < arr_size; i++) {
			if (arr[i] - min_element > max_diff)
				max_diff = arr[i] - min_element;
			if (arr[i] < min_element)
				min_element = arr[i];
		}
		return max_diff;
	}
}
