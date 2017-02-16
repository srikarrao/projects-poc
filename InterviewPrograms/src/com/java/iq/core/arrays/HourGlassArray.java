package com.java.iq.core.arrays;

/**
 * JAVA program to find the max value of a hour glass array in a 2D Array
 * 
 * @author SrikarRao
 *
 */
public class HourGlassArray {

	public static void main(String[] args) {
		int[][] HG = new int[6][6];

		HG[0][0] = 0;
		HG[0][1] = -4;
		HG[0][2] = -6;
		HG[0][3] = 0;
		HG[0][4] = -7;
		HG[0][5] = -6;

		HG[1][0] = -1;
		HG[1][1] = -2;
		HG[1][2] = -6;
		HG[1][3] = -8;
		HG[1][4] = -3;
		HG[1][5] = -1;

		HG[2][0] = -8;
		HG[2][1] = -4;
		HG[2][2] = -2;
		HG[2][3] = -8;
		HG[2][4] = -8;
		HG[2][5] = -6;

		HG[3][0] = -3;
		HG[3][1] = -1;
		HG[3][2] = -2;
		HG[3][3] = -5;
		HG[3][4] = -7;
		HG[3][5] = -4;

		HG[4][0] = -3;
		HG[4][1] = -5;
		HG[4][2] = -3;
		HG[4][3] = -6;
		HG[4][4] = -6;
		HG[4][5] = -6;

		HG[5][0] = -3;
		HG[5][1] = -6;
		HG[5][2] = 0;
		HG[5][3] = -8;
		HG[5][4] = -6;
		HG[5][5] = -7;
		maxSumOfHourGlass(HG);
	}

	/**
	 * method to find the maximum value for a hour glass
	 * 
	 * @param hourGlass
	 */
	public static void maxSumOfHourGlass(int[][] hourGlass) {
		// Always set the maximumValue to minimum value of Integer
		int maximumValue = Integer.MIN_VALUE;
		// iterate the array to access all the elements
		for (int i = 0; i < hourGlass.length - 2; i++) {
			for (int j = 0; j < hourGlass[i].length - 2; j++) {
				int result = hourGlass[i][j] + hourGlass[i][j + 1]
						+ hourGlass[i][j + 2] + hourGlass[i + 1][j + 1]
						+ hourGlass[i + 2][j] + hourGlass[i + 2][j + 1]
						+ hourGlass[i + 2][j + 2];

				// check if result is greater than maximumValue
				if (result > maximumValue) {
					maximumValue = result;
				}
			}
		}
		// print the output
		System.out.println(maximumValue);
	}
}