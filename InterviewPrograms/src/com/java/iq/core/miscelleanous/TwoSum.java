package com.java.iq.core.miscelleanous;

import java.util.Collections;
import java.util.List;

/**
 * JAVA program to find if the given number is the two sum of numbers in a given
 * array
 * 
 * @author SrikarRao
 *
 */
public class TwoSum {

	public static boolean hasTwoSum(List<Integer> array, int num) {

		if (array == null || array.size() < 2) {
			return false;
		}

		Collections.sort(array);
		int i = 0;
		int j = array.size() - 1;

		while (i <= j) {
			if (array.get(i) + array.get(j) == num) {
				return true;
			} else if (array.get(i) + array.get(j) < num) {
				i++;
			} else {
				j--;
			}
		}
		return false;
	}
}