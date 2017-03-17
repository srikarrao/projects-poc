package com.java.iq.core.arrays;

public class FirstLastOccurrence {

	public static void main(String[] args) {
		findFirstAndLastOccurrence(
				new int[] { 1, 3, 5, 5, 5, 5, 67, 123, 125 }, 5);
		findFirstAndLastOccurrenceOptimized(new int[] { 1, 3, 5, 5, 5, 5, 67,
				123, 125 }, 5);

		findFirstAndLastOccurrence(new int[] { 5, 5, 5, 5, 67, 123, 125 }, 5);
		findFirstAndLastOccurrenceOptimized(new int[] { 5, 5, 5, 5, 67, 123,
				125 }, 5);

		findFirstAndLastOccurrence(new int[] { 1, 3, 5, 5, 5, 5 }, 5);
		findFirstAndLastOccurrenceOptimized(new int[] { 1, 3, 5, 5, 5, 5 }, 5);

		findFirstAndLastOccurrence(new int[] { 1, 3, 12 }, 5);
		findFirstAndLastOccurrenceOptimized(new int[] { 1, 3, 12 }, 5);
	}

	/**
	 * Runtime: O (n)
	 * 
	 * @param arr
	 * @param K
	 */
	private static void findFirstAndLastOccurrence(int[] arr, int K) {

		int first = -1, last = -1;
		int n = arr.length;
		for (int i = 0; i < n; i++) {

			if (K != arr[i]) {
				if (first != -1)
					break;
				continue;
			}
			if (first == -1) {
				first = i;
			}
			last = i;
		}
		if (first != -1) {
			System.out.println("Method-1: First Occurrence = " + first);
			System.out.println("Method-1: Last Occurrence = " + last);
		} else {
			System.out.println("Method-1: Not Found");
		}
	}

	private static void findFirstAndLastOccurrenceOptimized(int[] arr, int K) {
		int first = findFirst(arr, K);
		int last = findLast(arr, K);
		if (first != -1 && last != -1) {
			System.out.println("Method-2: First Occurrence = " + first);
			System.out.println("Method-2: Last Occurrence = " + last);
		} else {
			System.out.println("Method-2: Not Found");
		}
	}

	private static int findFirst(int[] arr, int K) {
		int low = 0;
		int high = arr.length - 1;
		int first = -1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > K) {
				high = mid - 1;
			} else if (arr[mid] < K) {
				low = mid + 1;
			} else {
				if (mid == 0) {
					return mid;
				}
				first = mid;
				high = mid - 1;
			}
		}
		return first;
	}

	private static int findLast(int[] arr, int K) {
		int low = 0;
		int high = arr.length - 1;
		int last = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] > K) {
				high = mid - 1;
			} else if (arr[mid] < K) {
				low = mid + 1;
			} else {
				if (mid == arr.length - 1) {
					return mid;
				}
				last = mid;
				low = mid + 1;
			}
		}
		return last;
	}
}
