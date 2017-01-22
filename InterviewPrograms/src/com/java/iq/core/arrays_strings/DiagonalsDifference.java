package com.java.iq.core.arrays_strings;

/**
 * JAVA program to find the difference of sum of two diagonals
 * 
 * @author SrikarRao
 *
 */
public class DiagonalsDifference {

	/**
	 * method to perform sum of elements in a diagonal and their difference
	 * 
	 * @param arr
	 * @return
	 */
	public static int getAbsoluteDiagonalDifference(int[][] arr) {
		int sumD1 = 0;
		int sumD2 = 0;

		for (int i = 0; i < arr.length; i++) {
			sumD1 += arr[i][i];
		}

		int j = 2;
		for (int i = 0; i < arr.length; i++) {
			sumD2 += arr[i][j--];
		}

		return Math.abs(sumD1 - sumD2);
	}
}
