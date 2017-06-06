package com.java.iq.core.hashtable;
import java.util.*;

/**
 * Print all subarrays with 0 sum <br>
 * Space: O (N) <br>
 * Time: O (N) <br>
 * Source: http://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/ <br>
 * 
 * @author srikarrao.gandla
 *
 */
public class SubArraySum {

	/*
	 * Naive process O (N ^ 2)
	 */
	private static void getSubArrays_bruteForce(int[] arr) {

		List<Pair> pairs = new ArrayList<Pair>();
		for (int i = 0; i < arr.length - 1; i++) {
			int sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				if (sum == 0) {
					pairs.add(new Pair(i, j));
				}
			}
		}

		print(pairs);
	}

	private static class Pair {
		int start;
		int end;

		public Pair(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7 };

		List<Pair> out = findSubArrays(arr, arr.length);

		if (out.size() == 0)
			System.out.println("No subarray exists");
		else
			print(out);

		System.out.println("Brute Force:");
		getSubArrays_bruteForce(arr);
	}

	private static void print(List<Pair> out) {
		for (int i = 0; i < out.size(); i++) {
			Pair pair = out.get(i);
			System.out.println("Subarray found from Index " + pair.start
					+ " to " + pair.end);
		}

	}

	private static List<Pair> findSubArrays(int arr[], int n) {

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Pair> out = new ArrayList<Pair>();
		int sum = 0;

		for (int i = 0; i < n; i++) {

			sum += arr[i];
			if (sum == 0) {
				out.add(new Pair(0, i));
			}

			if (map.containsKey(sum)) {
				List<Integer> vc = map.get(sum);
				for (int x = 0; x < vc.size(); x++) {
					out.add(new Pair(vc.get(x) + 1, i));
				}
			} else {
				map.put(sum, new ArrayList<Integer>());
			}
			map.get(sum).add(i);
		}
		return out;
	}
}