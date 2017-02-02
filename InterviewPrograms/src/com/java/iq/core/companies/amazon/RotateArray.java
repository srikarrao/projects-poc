package com.java.iq.core.companies.amazon;


/**
 * JAVA program to rotate a NXN matrix by 90 degree
 * 
 * @author SrikarRao
 *
 */
public class RotateArray {

	public static void main(String[] args) {
		int[][] A = new int[4][4];

		A[0][0] = 00;
		A[0][1] = 01;
		A[0][2] = 02;
		A[0][3] = 03;

		A[1][0] = 10;
		A[1][1] = 11;
		A[1][2] = 12;
		A[1][3] = 13;

		A[2][0] = 20;
		A[2][1] = 21;
		A[2][2] = 22;
		A[2][3] = 23;

		A[3][0] = 30;
		A[3][1] = 31;
		A[3][2] = 32;
		A[3][3] = 33;

		System.out.println("Before rotating");
		for (int[] x : A) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}

		System.out.println("After rotating");
		A = rotateArray(A, A.length);
		for (int[] x : A) {
			for (int y : x) {
				System.out.print(y + " ");
			}
			System.out.println();
		}
	}

	/**
	 * method to rotate an array
	 * 
	 * @param inputArray
	 * @param n
	 * @return
	 */
	public static int[][] rotateArray(int[][] inputArray, int n) {

		/**
		 * loop to iterate through the array
		 */
		for (int layer = 0; layer < n / 2; layer++) {

			int last = n - layer - 1;
			int first = layer;

			/**
			 * loop to iterate the edges
			 */
			for (int i = first; i < last; i++) {
				int offset = i - first;
				int top = inputArray[first][i];
				// top left element
				inputArray[first][i] = inputArray[last - offset][first];
				// bottom left element
				inputArray[last - offset][first] = inputArray[last][last
						- offset];
				// right bottom element
				inputArray[last][last - offset] = inputArray[i][last];
				// top right element
				inputArray[i][last] = top;
			}
		}
		return inputArray;
	}
}