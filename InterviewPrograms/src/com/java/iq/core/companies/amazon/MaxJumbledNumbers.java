package com.java.iq.core.companies.amazon;

import java.util.*;

/**
 * Java program to find the max length of continuous numbers
 * 
 * @author SrikarRao
 *
 */
public class MaxJumbledNumbers {

	public static void main(String[] args) {
		int[] array = { 1, 94, 93, 1000, 2, 92, 1001 };
		System.out.println("Max continuous length = "
				+ maxContinuousLength_Sorting(array));
		System.out.println("Max continuous length = "
				+ maxContinuousLength_Set(array));
	}

	/**
	 * Time Complexity: O(n logn)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param array
	 * @return
	 */
	public static int maxContinuousLength_Sorting(int[] array) {
		int maxLength = 1, curLength = 1;
		Arrays.sort(array);
		int prev = array[0];
		for (int i = 1; i < array.length; i++) {
			if (prev == array[i] - 1) {
				curLength++;
			} else {
				maxLength = Math.max(maxLength, curLength);
				curLength = 1;
			}
			prev = array[i];
		}
		return maxLength;
	}

	/**
	 * Time Complexity: O(n)
	 * 
	 * Space Complexity: O(n)
	 * 
	 * @param array
	 * @return
	 */
	public static int maxContinuousLength_Set(int[] array) {
		int maxLength = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < array.length; i++) {
			set.add(array[i]);
		}
		for (Integer i : set) {
			if (!set.contains(i - 1)) {
				int curLength = 0;
				while (set.contains(i)) {
					i++;
					curLength++;
				}
				maxLength = Math.max(maxLength, curLength);
			}
		}
		return maxLength;
	}
}