package com.java.iq.core.companies.amazon;

public class ArrangeCoins {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 8, 3 };

		for (int x = 0; x < arr.length; x++) {
			long n = arr[x];
			System.out.println(arrangeCoins(n));
		}
	}

	static long arrangeCoins(long n) {
		long i = 0;
		long j = n;
		long m = 0;
		while (i <= j) {
			m = (i + j) >>> 1;
			if ((0.5 * m * m + 0.5 * m) <= n) {
				i = m + 1;
			} else {
				j = m - 1;
			}
		}
		return i - 1;
	}
}
