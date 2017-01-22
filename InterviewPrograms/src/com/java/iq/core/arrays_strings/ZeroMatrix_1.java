package com.java.iq.core.arrays_strings;

/**
 * Zero Matrix i.e if M*M is zero make entire row and column set 0
 * O(MN) Space
 * @author SrikarRao
 *
 */
public class ZeroMatrix_1 {

	private static boolean[] hasZeroInRows;
	private static boolean[] hasZeroInCols;

	public static void main(String[] args) {

		int[][] arr = new int[5][5];
		hasZeroInRows = new boolean[arr.length];
		hasZeroInCols = new boolean[arr[0].length];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = i + j;
			}
		}
		arr[0][0] = 0;
		// arr[2][3] = 0;
		arr[4][1] = 0;

		System.out.println("Before Zero matrix!!");
		displayArray(arr);
		System.out.println("After Zero matrix!!");
		displayArray(processZeroMatrix(arr));
	}

	private static int[][] processZeroMatrix(int[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 0) {
					hasZeroInRows[i] = true;
					hasZeroInCols[j] = true;
				}
			}
		}

		for (int i = 0; i < hasZeroInRows.length; i++) {
			if (hasZeroInRows[i]) {
				nullifyRow(i, arr);
			}
		}

		for (int i = 0; i < hasZeroInCols.length; i++) {
			if (hasZeroInCols[i]) {
				nullifyColumn(arr, i);
			}
		}
		return arr;
	}

	private static void nullifyRow(int row, int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			arr[row][i] = 0;
		}
	}

	private static void nullifyColumn(int[][] arr, int col) {
		for (int i = 0; i < arr.length; i++) {
			arr[i][col] = 0;
		}
	}

	private static void displayArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
