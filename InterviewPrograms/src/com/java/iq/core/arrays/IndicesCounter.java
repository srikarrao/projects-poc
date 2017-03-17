package com.java.iq.core.arrays;

/**
 * Count the number of indices in an array
 * 
 * Source: http://www.geeksforgeeks.org/counting-inversions/
 * 
 * @author srikarrao.gandla
 *
 */
public class IndicesCounter {

	public static void main(String[] args) {
		int arr[] = { 1, 20, 6, 4, 5 };
		System.out.println(" Number of inversions are " + mergeSortInit(arr));
	}

	private static int mergeSortInit(int arr[]) {
		int[] temp = new int[arr.length];
		return divide(arr, temp, 0, arr.length - 1);
	}

	private static int divide(int arr[], int temp[], int left, int right) {
		int mid, inv_count = 0;
		if (right > left) {
			mid = (right + left) / 2;
			inv_count = divide(arr, temp, left, mid);
			inv_count += divide(arr, temp, mid + 1, right);
			inv_count += conquer(arr, temp, left, mid + 1, right);
		}
		return inv_count;
	}

	private static int conquer(int arr[], int temp[], int left, int mid,
			int right) {
		int i, j, k;
		int inv_count = 0;

		i = left;
		j = mid;
		k = left;
		while ((i <= mid - 1) && (j <= right)) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inv_count = inv_count + (mid - i);
			}
		}

		while (i <= mid - 1) {
			temp[k++] = arr[i++];
		}

		while (j <= right) {
			temp[k++] = arr[j++];
		}

		for (i = left; i <= right; i++) {
			arr[i] = temp[i];
		}

		return inv_count;
	}
}