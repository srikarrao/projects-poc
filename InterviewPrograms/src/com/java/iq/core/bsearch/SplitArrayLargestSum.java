package com.java.iq.core.bsearch;

public class SplitArrayLargestSum {

	/**
	 * https://leetcode.com/problems/split-array-largest-sum/
	 */
	public static void main(String[] args) {
		System.out.println(new SplitArrayLargestSum().splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
	}

	public int splitArray(int[] nums, int m) {
		int low = Integer.MIN_VALUE;
		int high = 0;

		for (int i = 0; i < nums.length; i++) {
			low = Math.max(low, nums[i]);
			high += nums[i];
		}

		if (m == 1) {
			return high;
		}

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (isArraySplitPossible(nums, mid, m)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return low;
	}

	private boolean isArraySplitPossible(int[] nums, int target, int m) {
		int sum = 0;
		int splitCount = 1;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > target) {
				splitCount++;
				sum = nums[i];
				if (splitCount > m) {
					return false;
				}
			}
		}
		return true;
	}
}
