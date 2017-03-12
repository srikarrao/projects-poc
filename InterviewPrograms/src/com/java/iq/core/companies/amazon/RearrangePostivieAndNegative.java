package com.java.iq.core.companies.amazon;

/**
 * Source: https://www.careercup.com/question?id=5183920823861248
 * 
 * @author SrikarRao
 *
 */
public class RearrangePostivieAndNegative {

	public static void main(String[] args) {
		int[] arr1 = { -5, -2, -5, -2, 4, 7, 1, 8, 0, -8 };
		int[] arr2 = { 5, -2, -5, -2, 4, 7, 1, -8, 0, -8 };
		int[] arr3 = { -5, -2, -5, -2, -4, -7, -1, -8, 0, -8 };
		int[] arr4 = { 5, 2, 5, 2, 4, 7, 1, 8, 0, 8 };

		reArrange(arr1);
		reArrange(arr2);
		reArrange(arr3);
		reArrange(arr4);

		printArr(arr1);
		printArr(arr2);
		printArr(arr3);
		printArr(arr4);
	}

	private static void printArr(int[] arr) {
		for (int i : arr)
			System.out.print(i + " ");

		System.out.println();
	}

	private static void reArrange(int[] arr) {

		int outOfPlace = -1;
		for (int i = 0; i < arr.length; i++) {
			if (outOfPlace >= 0) {
				if ((arr[i] >= 0 && arr[outOfPlace] < 0)
						|| (arr[i] < 0 && arr[outOfPlace] >= 0)) {
					rightRotate(arr, outOfPlace, i);
					if (i > outOfPlace + 2) {
						outOfPlace += 2;
					} else {
						outOfPlace = -1;
					}
				}
			}

			if (outOfPlace == -1) {
				if ((arr[i] < 0 && (i & 0x01) == 1)
						|| (arr[i] > 0 && (i & 0x01) == 0)) {

					outOfPlace = i;
				}
			}
		}
	}

	private static void rightRotate(int[] arr, int outOfPlace, int curr) {
		int temp = arr[curr];
		for (int i = curr; i > outOfPlace; i--)
			arr[i] = arr[i - 1];
		arr[outOfPlace] = temp;
	}
}