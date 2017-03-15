package com.java.iq.core.arrays;

/**
 * Time complexity: O(n)
 * 
 * Auxiliary space: O(n)
 * 
 * @author srikarrao.gandla
 *
 */
public class KSwapPermutation {

	public static void KswapPermutation(int arr[], int n, int k) {
		// Auxiliary dictionary of storing the position
		// of elements
		int[] pos = new int[n + 1];

		for (int i = 0; i < n; ++i)
			pos[arr[i]] = i;

		for (int i = 0; i < n && k > 0; ++i) {
			// If element is already i'th largest,
			// then no need to swap
			if (arr[i] == n - i)
				continue;

			// Find position of i'th largest value, n-i
			int temp = pos[n - i];

			// Swap the elements position
			pos[arr[i]] = pos[n - i];
			pos[n - i] = i;

			// Swap the ith largest value with the
			// current value at ith place
			swap(arr, temp, i);

			// decrement number of swaps
			--k;
		}
	}

	private static void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}

	// Driver code
	public static void main(String[] args) {
		int arr[] = { 4, 5, 2, 1, 3 };
		int n = arr.length;
		int k = 3;

		KswapPermutation(arr, n, k);
		System.out.println("Largest permutation after " + k + " swaps: ");
		;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
	}
}
