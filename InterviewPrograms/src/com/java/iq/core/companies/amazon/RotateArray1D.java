package com.java.iq.core.companies.amazon;

import java.util.Arrays;

public class RotateArray1D {

	public static void main(String[] args) {
		int[] A = { 0, 1, 2, 4, 6, 7 };
		System.out.println(Arrays.toString(rotateArray_bruteForce(A, 10)));
		int[] B = { 0, 1, 2, 4, 6, 7 };
		System.out.println(Arrays.toString(rotateArray_timeOptimized(B, 10)));
		int[] C = { 0, 1, 2, 4, 6, 7 };
		System.out.println(Arrays.toString(rotateArray_optimized(C, 0)));
	}

	/**
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param arr
	 * @param K
	 * @return
	 */
	private static int[] rotateArray_optimized(int[] arr, int K) {

		int N = arr.length;
		K %= N;

		reverseArray(arr, 0, N - 1);
		reverseArray(arr, N - K, N - 1);
		reverseArray(arr, 0, N - K - 1);
		return arr;
	}

	/**
	 * Reverse an array n/2
	 * 
	 * @param A
	 * @param start
	 * @param end
	 */
	private static void reverseArray(int[] A, int start, int end) {

		if (start >= end) {
			return;
		}

		while (start >= 0 && end < A.length && start < end) {
			int temp = A[start];
			A[start] = A[end];
			A[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 * 
	 * @param arr
	 * @param K
	 * @return
	 */
	private static int[] rotateArray_timeOptimized(int[] arr, int K) {
		int[] res = new int[arr.length];
		int N = arr.length;
		K %= N;
		for (int i = 0; i < N; i++) {
			int X = (N - K + i) % N;
			res[X] = arr[i];
		}
		return res;
	}

	/**
	 * Time Complexity: O(n^2)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param arr
	 * @param K
	 * @return
	 */
	private static int[] rotateArray_bruteForce(int[] arr, int K) {
		int N = arr.length;
		K %= N;
		for (int i = 0; i < K; i++) {
			int temp = arr[0];
			for (int j = 1; j < N; j++) {
				arr[j - 1] = arr[j];
			}
			arr[arr.length - 1] = temp;
		}
		return arr;
	}
}
