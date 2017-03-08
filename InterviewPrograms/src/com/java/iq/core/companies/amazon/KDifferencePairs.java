package com.java.iq.core.companies.amazon;

import java.util.*;

public class KDifferencePairs {

	public static void main(String[] args) {
		int[] A = { 3, 1, 4, 1, 5 };
		System.out.println(findPairs(A, 2));
	}

	public static int findPairs(int[] nums, int k) {
		if (nums == null || nums.length == 0 || k < 0)
			return 0;

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (k == 0) {
				if (entry.getValue() >= 2) {
					count++;
				}
			} else {
				if (map.containsKey(entry.getKey() + k)) {
					count++;
				}
			}
		}

		return count;
	}
}
