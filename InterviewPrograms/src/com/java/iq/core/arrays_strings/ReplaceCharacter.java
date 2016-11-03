package com.java.iq.core.arrays_strings;

import java.util.Arrays;

/**
 * JAVA Program to replace spaces in a string with '%20'
 * 
 * @author SrikarRao
 *
 */
public class ReplaceCharacter {

	public static void main(String[] args) {
		System.out
				.println(replaceCharacter(new String(" ab cd ").toCharArray()));
	}

	/**
	 * method replaces spaces with character
	 * 
	 * @param array
	 * @return
	 */
	private static String replaceCharacter(char[] array) {
		int spaceCount = 0;
		int i = 0;
		int z = 0;

		/**
		 * iterate to count space characters, non-space characters
		 */
		while (i < array.length) {
			if (array[i] == ' ') {
				spaceCount++;
			} else {
				z++;
			}
			i++;
		}

		// add new required spaces using copyOf
		array = Arrays.copyOf(array, z + (spaceCount * 3));
		int j = i - 1;
		i = array.length - 1;
		/**
		 * while loop to place '%20' in empty spaces
		 */
		while (j >= 0) {
			if (array[j] == ' ') {
				array[i--] = '0';
				array[i--] = '2';
				array[i--] = '%';
			} else {
				array[i--] = array[j];
			}
			j--;
		}
		return Arrays.toString(array);
	}
}