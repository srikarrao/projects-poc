package com.java.iq.core.arrays;

import java.util.*;

/**
 * Given an array of integers where 1 to n (n = size of array), some elements
 * appear twice and others appear once.
 * 
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * 
 * @author SrikarRao.Gandla
 *
 */
public class DisappearedNumbers {

	public static void main(String[] args) {

		int[] A = { 4, 3, 2, 8, 7, 2, 3, 1 };
		List<Integer> res = findDisappearedNumbers(A);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
		System.out.println();
		printRepeating();
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> ret = new ArrayList<Integer>();

		for (int i = 0; i < nums.length; i++) {
			int val = Math.abs(nums[i]) - 1;
			if (nums[val] > 0) {
				nums[val] = -nums[val];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				ret.add(i + 1);
			}
		}
		return ret;
	}

	private static void printRepeating() {
		int arr[] = { 4, 2, 4, 5, 2, 3, 1 };
		int i = 0;
		int size = arr.length;
		System.out.println("The repeating elements are : ");

		for (i = 0; i < size; i++) {
			if (arr[Math.abs(arr[i])] > 0)
				arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
			else
				System.out.print(Math.abs(arr[i]) + " ");
		}
	}
}
