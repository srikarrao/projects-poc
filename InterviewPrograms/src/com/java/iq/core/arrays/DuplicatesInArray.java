package com.java.iq.core.arrays;

import java.util.*;

public class DuplicatesInArray {

	public static void main(String[] args) {

		for (int x : findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 })) {
			System.out.println(x);
		}
	}

	/**
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param nums
	 * @return
	 */
	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < nums.length; ++i) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				res.add(Math.abs(index + 1));
			nums[index] = -nums[index];
		}
		return res;
	}

}
