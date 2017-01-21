package com.java.iq.core.companies.amazon;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class ClosestNumberPairs {

	public static void main(String[] args) {
		int arr[] = { -20, -3916237, -357920, -3620601, 7374819, -7330761, 30,
				6246457, -6461594, 266854 };
		Arrays.sort(arr);
		LinkedList<Map.Entry<Integer, Integer>> pairs = new LinkedList<Map.Entry<Integer, Integer>>();

		Integer minDiff = new Double(2 * Math.pow(10, 7)).intValue();
		int left = arr[0];

		for (int i = 1; i < arr.length; i++) {
			int right = arr[i];
			int diff = right - left;

			if (diff < minDiff) {
				pairs.clear();
				pairs.add(new SimpleEntry<Integer, Integer>(left, right));
				minDiff = diff;
			} else if (diff == minDiff) {
				pairs.add(new SimpleEntry<Integer, Integer>(left, right));
			}
			left = right;
		}
		for (Map.Entry<Integer, Integer> s : pairs) {
			System.out.print(s.getKey() + " " + s.getValue() + " ");
		}
	}
}