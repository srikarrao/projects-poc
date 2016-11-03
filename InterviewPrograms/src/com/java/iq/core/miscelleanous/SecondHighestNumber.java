package com.java.iq.core.miscelleanous;

import java.util.List;

/**
 * JAVA program to find second highest number in integer array
 * 
 * @author SrikarRao
 *
 */
public class SecondHighestNumber {

	public static int findSecondHighestNum(List<Integer> array) {

		if (array == null) {
			return -1;
		}

		if (array.size() < 2) {
			return -1;
		}

		int first = (array.get(0) > array.get(1) ? array.get(0) : array.get(1));
		int second = (first != array.get(0) ? array.get(0) : array.get(1));
		return findSecondHighestNum(first, second, array);
	}

	public static int findSecondHighestNum(int firstLarge, int secondLarge,
			List<Integer> array) {

		for (int i = 2; i < array.size(); i++) {
			if (array.get(i) > firstLarge) {
				secondLarge = firstLarge;
				firstLarge = array.get(i);
			} else if (array.get(i) < firstLarge && array.get(i) > secondLarge) {
				secondLarge = array.get(i);
			}
		}
		return secondLarge;
	}
}
