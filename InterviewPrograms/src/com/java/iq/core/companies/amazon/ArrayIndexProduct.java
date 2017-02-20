package com.java.iq.core.companies.amazon;

/**
 * Write a function that will produce another array, where the value in each
 * index of the array will be the product of all values in the given array
 * except that index
 * 
 * @author SrikarRao
 *
 */
public class ArrayIndexProduct {

	public static void main(String[] args) {

		int[] input1 = { 1, 2, 3, 4, 5 };
		printArray(productAllOtherValues(input1));
		int[] input2 = { 1, 2, 3, 0, 5 };
		printArray(productAllOtherValues(input2));
		int[] input3 = { 1, 0, 3, 0, 5 };
		printArray(productAllOtherValues(input3));
		int[] input4 = { 1, 2, 3, 0, 5 };
		printArray(productAllOtherValues(input4));
		int[] input5 = { 0, 2, 3, 100, 5 };
		printArray(productAllOtherValues(input5));
		int[] input6 = { 1, 2, 3, 50, 0 };
		printArray(productAllOtherValues(input6));
	}

	public static int[] productAllOtherValues(int[] A) {

		int[] res = new int[A.length];

		int product1 = 1;
		boolean hasZeroValue = false;
		int zerosCounter = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != 0) {
				product1 *= A[i];
			} else {
				hasZeroValue = true;
				product1 *= 1;
				zerosCounter++;
			}
		}

		for (int i = 0; i < res.length; i++) {
			if (A[i] == 0) {
				if (zerosCounter > 1) {
					res[i] = 0;
				} else {
					res[i] = product1;
				}
			} else if (hasZeroValue) {
				res[i] = 0;
			} else {
				res[i] = product1 / A[i];
			}
		}
		return res;
	}

	private static void printArray(int[] res) {
		for (int i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
