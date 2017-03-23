package com.java.iq.core.dp;

import java.util.Arrays;

/**
 * Source: http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/ <br>
 * Time complexity of this function: O(mn) <br>
 * Space Complexity of this function: O(n)
 * 
 * 
 * @author srikarrao.gandla
 *
 */
public class CoinChange_DP {

	private static int countWaysNaive(int S[], int m, int n) {
		// If n is 0 then there is 1 solution (do not include any coin)
		if (n == 0)
			return 1;

		// If n is less than 0 then no solution exists
		if (n < 0)
			return 0;

		// If there are no coins and n is greater than 0, then no solution exist
		if (m <= 0 && n >= 1)
			return 0;

		// count is sum of solutions (i) including S[m-1] (ii) excluding S[m-1]
		return countWaysNaive(S, m - 1, n) + countWaysNaive(S, m, n - S[m - 1]);
	}

	private static long countWays(int S[], int m, int n) {
		long[] table = new long[n + 1];

		Arrays.fill(table, 0);
		table[0] = 1;
		for (int i = 0; i < m; i++)
			for (int j = S[i]; j <= n; j++)
				table[j] += table[j - S[i]];

		return table[n];
	}

	public static void main(String args[]) {
		int arr[] = { 1, 2, 3 };
		int m = arr.length;
		int n = 4;
		System.out.println(countWays(arr, m, n));
	}
}
