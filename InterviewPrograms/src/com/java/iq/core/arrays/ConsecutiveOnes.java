package com.java.iq.core.arrays;

public class ConsecutiveOnes {

	public static int countConsecutiveOnes(int[] arr) {
		int maxCount = 0;

		if (arr == null || arr.length == 0) {
			return maxCount;
		}

		if (arr.length == 1 && arr[0] == 1) {
			return 1;
		}

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				count++;
			} else {
				maxCount = Math.max(count, maxCount);
				count = 0;
			}
		}

		maxCount = Math.max(maxCount, count);

		return maxCount;

	}
}
