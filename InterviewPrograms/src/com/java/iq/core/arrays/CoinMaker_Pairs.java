package com.java.iq.core.arrays;

import java.util.*;

public class CoinMaker_Pairs {

	private static List<List<Integer>> result = new ArrayList<List<Integer>>();

	public static void main(String[] args) {

		int[] D = { 1, 2, 3 };
		makeChange(new ArrayList<Integer>(), 0, 4, D, 0);
		for (List<Integer> x : result) {
			System.out.println(x);
		}
	}

	private static void makeChange(List<Integer> coins, int sum, int target,
			int[] denominations, int iter) {

		for (int i = iter; i < denominations.length; i++) {
			sum += denominations[i];

			if (sum < target) {
				coins.add(denominations[i]);
				makeChange(coins, sum, target, denominations, i);
			} else {
				if (sum == target) {
					coins.add(denominations[i]);
					setResult(coins);
				}
				sum = sum - denominations[i];
				coins.remove(coins.size() - 1);
				break;
			}
			sum = sum - denominations[i];
			coins.remove(coins.size() - 1);
		}

	}

	private static void setResult(List<Integer> coins) {

		result.add(new ArrayList<Integer>(coins));
	}
}
