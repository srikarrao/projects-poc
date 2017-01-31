package com.java.iq.core.companies.uber;

public class MaxSumOfAdjacentNumbers {

	public static void main(String[] args) {
		int[] input = { 1, 0, 3, 9, 4 };
		System.out.println(findMaxSum(input));
	}

	/**
	 * maximum sum of non adjacent numbers
	 * @param arr
	 * @return
	 */
	private static int findMaxSum(int[] arr) {
		int prevOne = 0;
		int prevTwo = 0;
		int res = 0;

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				res = arr[0];
			} else if (i == 1) {
				res = Math.max(arr[0], arr[1]);
			} else {
				res = Math.max(prevOne, arr[i] + prevTwo);
			}
			prevTwo = prevOne;
			prevOne = res;
		}
		return res;
	}
}
