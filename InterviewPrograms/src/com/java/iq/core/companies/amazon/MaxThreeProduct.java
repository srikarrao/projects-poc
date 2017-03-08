package com.java.iq.core.companies.amazon;

public class MaxThreeProduct {

	public int max_prod_three(int[] A) {
		int[] maxThree = getMaxThree(A);
		int[] minTwo = getMinTwo(A);

		return Math.max(maxThree[0] * maxThree[1] * maxThree[2], maxThree[0]
				* minTwo[0] * minTwo[1]);
	}

	private int[] getMaxThree(int[] arr) {
		int[] result = { Integer.MIN_VALUE, Integer.MIN_VALUE,
				Integer.MIN_VALUE };
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (arr[i] >= result[0]) {
				result[2] = result[1];
				result[1] = result[0];
				result[0] = arr[i];
			} else if (arr[i] >= result[1]) {
				result[2] = result[1];
				result[1] = arr[i];
			} else if (arr[i] >= result[2]) {
				result[2] = arr[i];
			}
		}

		return result;
	}

	private int[] getMinTwo(int[] arr) {
		int[] result = { Integer.MAX_VALUE, Integer.MAX_VALUE };
		int len = arr.length;

		for (int i = 0; i < len; i++) {
			if (arr[i] <= result[0]) {
				result[1] = result[0];
				result[0] = arr[i];
			} else if (arr[i] <= result[1]) {
				result[1] = arr[i];
			}
		}
		return result;
	}

}
