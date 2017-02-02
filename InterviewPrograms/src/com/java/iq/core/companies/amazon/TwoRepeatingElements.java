package com.java.iq.core.companies.amazon;

/**
 * Find the two repeating elements in a given array
 * 
 * @author SrikarRao
 *
 */
public class TwoRepeatingElements {

	/**
	 * method with space O(n) and time O(n)
	 * 
	 * @param arr
	 * @param size
	 */
	private static void printRepeating1(int arr[], int size) {
		int count[] = new int[size];
		int i;

		System.out.println("Repeated elements are : ");
		for (i = 0; i < size; i++) {
			if (count[arr[i]] == 1)
				System.out.print(arr[i] + " ");
			else
				count[arr[i]]++;
		}
	}

	private static int fact(int n) {
		return (n == 0) ? 1 : n * fact(n - 1);
	}

	/**
	 * method with space O(1) and time O(n)
	 * 
	 * @param arr
	 * @param size
	 */
	private static void printRepeating2(int arr[], int size) {
		/* S is for sum of elements in arr[] */
		int S = 0;
		/* P is for product of elements in arr[] */
		int P = 1;
		/* x and y are two repeating elements */
		int x, y;
		/* D is for difference of x and y, i.e., x-y */
		int D;
		int n = size - 2, i;

		/* Calculate Sum and Product of all elements in arr[] */
		for (i = 0; i < size; i++) {
			S = S + arr[i];
			P = P * arr[i];
		}

		/* S is x + y now */
		S = S - n * (n + 1) / 2;

		/* P is x*y now */
		P = P / fact(n);

		/* D is x - y now */
		D = (int) Math.sqrt(S * S - 4 * P);

		x = (D + S) / 2;
		y = (S - D) / 2;

		System.out.println("The two repeating elements are :");
		System.out.print(x + " " + y);
	}

	public static void main(String[] args) {
		int arr[] = { 4, 2, 4, 5, 2, 3, 1 };
		int arr_size = arr.length;
		printRepeating1(arr, arr_size);
		printRepeating2(arr, arr_size);
	}
}
