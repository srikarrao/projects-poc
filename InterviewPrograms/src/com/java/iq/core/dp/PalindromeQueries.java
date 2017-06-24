package com.java.iq.core.dp;

/**
 * 
 * Source: <br>
 * http://www.geeksforgeeks.org/palindrome-substring-queries/
 */
public class PalindromeQueries {

	public static int queries(String string, int x, int y) {
		int length = string.length();
		int dp[][] = new int[length][length];
		for (int i = 0; i < length; i++) {
			dp[i][i] = 1;
		}
		for (int i = 1; i < length; i++) {
			for (int row = 0; row < length - i; row++) {
				int col = row + i;
				if (string.charAt(row) != string.charAt(col)) {
					dp[row][col] = 0;
				} else {
					if (dp[row + 1][col - 1] == 1) {
						dp[row][col] = 1;
					} else {
						dp[row][col] = 0;
					}
				}
			}
		}
		
		return dp[x][y];
	}

	public static void main(String[] args) {
		System.out.println(queries("abaaabaaaba", 0, 10));
		System.out.println(queries("abaaabaaaba", 5, 8));
		System.out.println(queries("abaaabaaaba", 2, 5));
		System.out.println(queries("abaaabaaaba", 5, 9));

	}
}
