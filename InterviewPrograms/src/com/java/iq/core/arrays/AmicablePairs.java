package com.java.iq.core.arrays;

import java.util.*;
import java.util.Set;

/**
 * Source: http://www.geeksforgeeks.org/pairs-amicable-numbers/ <br>
 * Space Complexity: O(n)<br>
 * Time Complexity: O (n ^ 2)
 * 
 * @author SrikarRao
 *
 */
public class AmicablePairs {

	private static int sumOfDiv(int x) {
		int sum = 1;
		for (int i = 2; i <= Math.sqrt(x); i++) {
			if (x % i == 0) {
				sum += i;
				if (x / i != i)
					sum += x / i;
			}
		}
		return sum;
	}

	private static boolean isAmicable(int a, int b) {
		return (sumOfDiv(a) == b && sumOfDiv(b) == a);
	}

	private static int countPairs(int arr[], int n) {
		Set<Integer> set = new HashSet<Integer>();
		int count = 0;
		for (int i = 0; i < n; i++) {
			set.add(arr[i]);
		}

		for (int i = 0; i < n; i++) {
			int sum = sumOfDiv(arr[i]);
			if (set.contains(sum)) {
				if (isAmicable(arr[i], sum))
					count++;
			}
		}

		return count / 2;
	}

	public static void main(String[] args) {
		int arr1[] = { 220, 284, 1184, 1210, 2, 5 };
		int n1 = arr1.length;
		System.out.println(countPairs(arr1, n1));

		int arr2[] = { 2620, 2924, 5020, 5564, 6232, 6368 };
		int n2 = arr1.length;
		System.out.println(countPairs(arr2, n2));
	}
}
