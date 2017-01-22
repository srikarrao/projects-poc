package com.java.iq.core.arrays_strings;

/**
 * Zero Matrix i.e if M*M is zero make entire row and column set 0 O(1) Space
 * 
 * @author SrikarRao
 *
 */
public class ZeroMatrix_2 {

	private static boolean hasZeroInRows;
	private static boolean hasZeroInCols;

	public static void main(String[] args) {

		int[][] arr = new int[5][5];

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = i + j;
			}
		}
		arr[0][0] = 0;
		arr[2][3] = 0;
		arr[4][1] = 0;

		System.out.println("Before Zero matrix!!");
		displayArray(arr);
		System.out.println("After Zero matrix!!");
		displayArray(processZeroMatrix2(arr));
	}

	private static int[][] processZeroMatrix2(int[][] arr) {

		for (int j = 0; j < arr.length; j++) {
			if (arr[0][j] == 0) {
				hasZeroInRows = true;
				break;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == 0) {
				hasZeroInCols = true;
				break;
			}
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					arr[i][0] = 0;
					arr[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < arr.length; i++) {
			if (arr[i][0] == 0) {
				nullifyRow(i, arr);
			}
		}

		for (int j = 1; j < arr.length; j++) {
			if (arr[0][j] == 0) {
				nullifyColumn(arr, j);
			}
		}

		if (hasZeroInRows) {
			nullifyRow(0, arr);
		}

		if (hasZeroInCols) {
			nullifyColumn(arr, 0);
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
