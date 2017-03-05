package com.java.iq.core.companies.google;

import java.util.Arrays;

/**
 * Java program to find the highest number formed which can divided by 3
 * 
 * @author SrikarRao
 *
 */
public class HighestNumberByThree {

	public static int getHigestNumDivisibleByThree(int[] arr) {

		if (arr == null || arr.length == 0) {
			return -1;
		}
		int sum = 0;
		StringBuilder str = new StringBuilder();
		Arrays.sort(arr);

		for (int i = arr.length; i > 0; i--) {
			sum = sum + arr[i - 1];
			str.append(arr[i - 1]);
		}

		int remainder = sum % 3;
		if (remainder == 0)
			return Integer.parseInt(str.toString());

		str = new StringBuilder();
		int removeNum = 0;
		while (remainder <= 9) {
			if (contains(arr, remainder)) {
				removeNum = remainder;
				break;
			}
			remainder = remainder + 3;
		}
		if (removeNum == 0)
			return 0;

		int removeNumCount = 1;

		for (int i = arr.length; i > 0; i--) {
			if (removeNum == arr[i - 1] && removeNumCount == 1) {
				removeNumCount--;
				continue;
			}
			str.append(arr[i - 1]);
		}
		return Integer.parseInt(str.toString());
	}

	private static boolean contains(int[] arr, int num) {
		for (int i : arr)
			if (i == num)
				return true;
		return false;
	}
}