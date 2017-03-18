package com.java.iq.core.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Source:
 * http://www.geeksforgeeks.org/break-array-maximum-number-sub-arrays-averages/ <br>
 * 
 * Space : O (N) <br>
 * Time: O (N)
 * 
 * @author SrikarRao
 *
 */
public class EqualSubArrayAverage {

	private static void findSubarrays(int arr[], int n) {
		List<Integer> result = new ArrayList<Integer>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}

		int curr_sum = 0;
		int prev_index = -1;

		for (int i = 0; i < n; i++) {
			curr_sum += arr[i];

			if (sum * (i - prev_index) == curr_sum * n) {
				curr_sum = 0;
				prev_index = i;
				result.add(i);
			}
		}

		if (prev_index != n - 1) {
			System.out.println("Not Possible");
			return;
		}

		System.out.println("(0, " + result.get(0) + ")");
		for (int i = 1; i < result.size(); i++)
			System.out.println("(" + (result.get(i - 1) + 1) + ", "
					+ result.get(i) + ")");
	}

	// Main Entry function code
	public static void main(String[] args) {
		int arr[] = { 4, 6, 2, 4, 8, 0, 6, 2 };
		int n = arr.length;
		findSubarrays(arr, n);
	}
}
