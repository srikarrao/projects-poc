package com.java.iq.core.miscelleanous;

import java.util.Arrays;

/**
 * Java program to find which number is not present in the given two arrays
 * 
 * @author SrikarRao
 *
 */
public class ArrayValuesNotInHashTable {
	public static void main(String[] args) {
		int[] arrayA = { 13, 25, 13, 90, 12 };
		int[] arrayB = { 1, 88, 90, 24, 11 };
		int[] resultArray = { 0, 0, 0, 0, 0, 0, 0 };

		System.out.println(Arrays.toString(intersectForEqualSizeArrays(arrayA,
				arrayB, resultArray)));
	}

	public static int[] intersectForEqualSizeArrays(int[] arrayA, int[] arrayB,
			int[] resultArray) {
		
		int displayNum = 0;
		int i = 0;
		int j = 0;

		Arrays.sort(arrayA);
		Arrays.sort(arrayB);

		while (i < arrayA.length && j < arrayB.length) {
			if (arrayA[i] != arrayB[j]) {
				resultArray[displayNum] = arrayB[j];
				displayNum++;
			}
			i++;
			j++;
		}
		resultArray = Arrays.copyOf(resultArray, displayNum);
		return resultArray;
	}
}
