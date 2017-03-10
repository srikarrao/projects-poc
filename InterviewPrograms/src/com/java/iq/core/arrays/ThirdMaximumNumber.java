package com.java.iq.core.arrays;

public class ThirdMaximumNumber {

	public static void main(String[] args) {

		System.out.println(thirdMax(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	/**
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public static int thirdMax(int[] nums) {
		int max, mid, small, count;
		max = mid = small = Integer.MIN_VALUE;
		count = 0; // Count how many top elements have been found.

		for (int x : nums) {
			// Skip loop if max or mid elements are duplicate. The purpose is
			// for avoiding right shift.
			if (x == max || x == mid) {
				continue;
			}

			if (x > max) {
				// right shift
				small = mid;
				mid = max;

				max = x;
				count++;
			} else if (x > mid) {
				// right shift
				small = mid;

				mid = x;
				count++;
			} else if (x >= small) { // if small duplicated, that's find,
										// there's no shift and need to increase
										// count.
				small = x;
				count++;
			}
		}

		// "count" is used for checking whether found top 3 maximum elements.
		if (count >= 3) {
			return small;
		} else {
			return max;
		}
	}

}
