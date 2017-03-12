package com.java.iq.core.companies.google;

public class LeftRightSum {

	/**
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param arr
	 * @return
	 */
	public static int findIndex(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		}

		int leftSum = 0;
		int rightSum = 0;

		for (int i = 0; i < arr.length; i++) {
			rightSum += arr[i];

		}

		for (int j = 0; j < arr.length; j++) {
			rightSum -= arr[j];
			if (leftSum == rightSum) {
				System.out.println(j);
				return j;
			}
			leftSum += arr[j];
		}
		return -1;
	}
}
