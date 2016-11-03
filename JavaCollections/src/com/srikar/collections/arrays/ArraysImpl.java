package com.srikar.collections.arrays;

public class ArraysImpl {

	/**
	 * @author SrikarRao Java program for arrays
	 */

	public static void main(String args[]) {

		implementArray1();
		implementArray2();
	}

	public static void implementArray2() {
		String[][] arrayString = new String[3][4];

		/**
		 * looping to assign and display "*" to the arrayString[][]
		 */
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < i + 1; j++) {
				arrayString[i][j] = "*";
				System.out.print(arrayString[i][j] + "  ");
			}
			System.out.println();
		}
	}

	public static void implementArray1() {

		String[] array = new String[4];

		/**
		 * looping to assign and display "*" to the array[]
		 */
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < i + 1; k++) {
				array[k] = "*";
				System.out.print(array[k] + "  ");
			}
			System.out.println();
		}
	}
}