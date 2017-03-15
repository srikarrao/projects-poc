package com.java.iq.core.dp;

public class MaxSubArray {

	public static Range findMaxSubArray(int[] arr) {
		Range range = null;

		if (arr == null || arr.length == 0) {
			return range;
		}

		int maxSum = 0;
		int minSum = 0;
		int sum = 0;
		int minIndx = -1;
		int negMax = Integer.MIN_VALUE;
		boolean hasPositive = false;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (!hasPositive) {
				negMax = Math.max(negMax, arr[i]);
				if (negMax == arr[i]) {
					range = new Range(i, i + 1);
				}
			} else {
				hasPositive = true;
			}
			if (sum < minSum) {
				minSum = sum;
				minIndx = i;
			}
			if (sum - minSum > maxSum) {
				maxSum = sum - minSum;
				range = new Range(minIndx + 1, i + 1);
			}
		}
		if (range == null) {
			range = new Range(minIndx + 1, 0);
		}
		System.out.println(range);
		return range;
	}
}
