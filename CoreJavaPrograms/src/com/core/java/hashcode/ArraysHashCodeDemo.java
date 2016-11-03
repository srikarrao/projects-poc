package com.core.java.hashcode;

import java.util.Arrays;

/**
 * JAVA Class to implement hashcode for arrays
 * 
 * @author SrikarRao
 *
 */
public class ArraysHashCodeDemo {

	public static void main(String[] args) {

		int[] array1 = { 22, 7 };
		int[] array2 = { 22, 7 };

		// hashcode for value2
		int hcode1 = array1.hashCode();
		int hcode2 = array2.hashCode();

		// printing hash code value
		System.out
				.println("The hash code of array1 using object.hashcode() is: "
						+ hcode1);
		System.out
				.println("The hash code of array1 using Arrays.hashcode() is: "
						+ Arrays.hashCode(array1));

		System.out
				.println("The hash code of array2 using object.hashcode() is: "
						+ hcode2);
		System.out
				.println("The hash code of array2 using Arrays.hashcode() is: "
						+ Arrays.hashCode(array2));
	}
}