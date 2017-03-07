package com.java.iq.core.companies.microsoft;

/**
 * Java program to check if a given array has loop (advancing forward and
 * backward)
 * 
 * @author SrikarRao.Gandla
 *
 */
public class ArrayLoopValidator {

	public static boolean hasLoop(int[] arr) {

		if (arr == null || arr.length == 0) {
			return false;
		}

		return findLoop(0, arr);
	}

	private static boolean findLoop(int start, int[] arr) {
		int slowIdx = start;
		int fastIdx = start;
		do {
			slowIdx = modIndex(arr, slowIdx);
			fastIdx = modIndex(arr, modIndex(arr, fastIdx));
			if (slowIdx == start || fastIdx == start) {
				return true;
			}
		} while (slowIdx != fastIdx);
		return false;
	}

	private static int modIndex(int[] arr, int idx) {
		idx += arr[idx];
		return Math.abs(idx % arr.length);
	}
}