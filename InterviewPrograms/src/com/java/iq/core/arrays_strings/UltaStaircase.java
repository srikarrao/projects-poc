package com.java.iq.core.arrays_strings;

/**
 * JAVA program to print staircase in reverse
 * 
 * @author SrikarRao
 *
 */
public class UltaStaircase {

	/**
	 * method to print staircase in reverse
	 * 
	 * @param n
	 */
	public static void printStairCase(int n) {
		for (int i = 1; i < n + 1; i++) {
			int j = 0;
			while (j < n - i) {
				System.out.print(" ");
				j++;
			}
			while (j < n) {
				System.out.print("#");
				j++;
			}
			System.out.println();
		}
	}
}
