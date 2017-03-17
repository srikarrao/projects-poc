package com.java.iq.core.arrays;

public class SubArraysSum {

	public static void main(String[] args) {

		int[] arr1 = { 6, 7, 8 };
		System.out.println((int) findSubArraySum(arr1));

		int[] arr2 = { 6 };
		System.out.println((int) findSubArraySum(arr2));

		int[] arr3 = { 0, 0, 0 };
		System.out.println((int) findSubArraySum(arr3));

		int[] arr4 = { 7, 9, 6, 10, 4 };
		System.out.println((int) findSubArraySum(arr4));

		int[] arr5 = { 1, 2, 3, 4 };
		System.out.println((int) findSubArraySum(arr5));
	}

	private static double findSubArraySum(int[] arr) {
		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		sum = (int) sum * Math.pow(2, arr.length - 1);
		return sum;
	}

}
