package com.java.iq.core.companies.yapstone;

/**
 * Java program to find the total cost of items after discount of items
 * 
 * @author SrikarRao.Gandla
 *
 */
public class ProductDiscount {

	private static int testcase = 1;

	public static int perform(int[] items) {
		int sum = 0;
		// items are empty
		if (items == null || items.length == 0) {
			printResult(sum);
			return sum;
		}

		// no discount applied
		if (items.length == 1) {
			sum = items[0];
			printResult(sum);
			return sum;
		}

		int res1 = findDiscountSum_bruteForce(items, sum);
		// int res2 = findDiscountSum_optimized(items, sum);

		// return res1 == res2 ? res1 : -1;
		return res1;
	}

	/**
	 * Space Complexity: O(1) Time Complexity: O(n^2)
	 * 
	 * @param items
	 * @param sum
	 * @return
	 */
	private static int findDiscountSum_bruteForce(int[] items, int sum) {

		boolean foundDiscount = false;

		for (int i = 0; i < items.length; i++) {
			foundDiscount = false;
			for (int j = i + 1; j < items.length; j++) {
				if (items[i] >= items[j]) {
					sum += items[i] - items[j];
					foundDiscount = true;
					break;
				}
			}

			if (i == items.length - 1 || !foundDiscount) {
				sum += items[i];
			}
		}

		System.out.println("testcase-" + testcase + " : " + sum);
		testcase++;
		return sum;
	}

	/**
	 * To-Do
	 * 
	 * @param items
	 * @param sum
	 * @return
	 */
	private static int findDiscountSum_optimized(int[] items, int sum) {

		return sum;

	}

	private static void printResult(int res) {
		System.out.println("testcase-" + testcase + " : " + res);
		testcase++;
	}
}