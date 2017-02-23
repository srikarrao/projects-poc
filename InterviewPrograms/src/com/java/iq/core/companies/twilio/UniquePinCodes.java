package com.java.iq.core.companies.twilio;

import java.util.*;

/**
 * Java program to find all the possible unique codes count to unlock a passcode
 * 
 * @author SrikarRao
 *
 *         Time Complexity: O(2^(n-1)- K); K for excluded elements
 */
public class UniquePinCodes {

	public static void main(String[] args) {
		System.out.println(findUniqueCodesCount(new int[7], 0));
	}

	/**
	 * method to find the count for unique codes
	 * 
	 * @param arr
	 * @param index
	 * @return
	 */
	private static int findUniqueCodesCount(int[] arr, int index) {

		if (index == 0) { // a[0] is always 2
			arr[index] = 2;
		}
		int count = 0; // initialize the count variable

		/*
		 * retrieve list of possible moves from key
		 */
		List<Integer> temp = getLValue(arr[index]);

		// iterate for each possible key value
		for (int i = 0; i < temp.size(); i++) {
			arr[index + 1] = temp.get(i);
			if (index + 1 < arr.length - 1) { // check if last element
				// keep iterating the count
				count += findUniqueCodesCount(arr, index + 1);
			} else {
				count++;
				System.err.println(Arrays.toString(arr));
			}
		}
		return count;
	}

	/**
	 * method to return the hard coded key values
	 * 
	 * @param key
	 * @return
	 */
	private static List<Integer> getLValue(int key) {

		Map<Integer, List<Integer>> LValues = new HashMap<Integer, List<Integer>>();
		LValues.put(2, Arrays.asList(7, 9));
		LValues.put(3, Arrays.asList(4, 8));
		LValues.put(4, Arrays.asList(3, 9));
		LValues.put(6, Arrays.asList(7));
		LValues.put(7, Arrays.asList(2, 6));
		LValues.put(8, Arrays.asList(3));
		LValues.put(9, Arrays.asList(2, 4));

		return LValues.get(key);
	}
}