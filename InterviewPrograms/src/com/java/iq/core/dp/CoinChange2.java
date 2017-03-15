package com.java.iq.core.dp;

/**
 * You are given coins of different denominations and a total amount of money.
 * Write a function to compute the number of combinations that make up that
 * amount. You may assume that you have infinite number of each kind of coin.
 * 
 * <b> Note: You can assume that <b>
 * 
 * 0 <= amount <= 5000 1 <= coin <= 5000 the number of coins is less than 500
 * the answer is guaranteed to fit into signed 32-bit integer
 * 
 * @author SrikarRao.Gandla
 *
 */
public class CoinChange2 {

	public static void main(String[] args) {
		System.out.println(change(5, new int[] { 1, 2, 5 }));
	}

	public static int change(int amount, int[] coins) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int i = 1; i <= amount; i++) {
				if (i >= coin)
					dp[i] += dp[i - coin];
			}
			printArray(dp);
		}
		return dp[amount];
	}

	public static void printArray(int[] arr) {
		for (int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

}
