package com.java.iq.core.miscelleanous;

/**
 * JAVA program to add digits in a number recursively
 * 
 * @author SrikarRao
 *
 */
public class SumOfDigits_Recursion {

	public static void main(String[] args) {
		System.out.println(addDigitsRecursively(123456789, 0));
		System.out.println(addDigitsRecursively(0, 0));
		System.out.println(addDigitsRecursively(120, 0));
		System.out.println(addDigitsRecursively(1, 0));
	}

	private static int addDigitsRecursively(int num, int sum) {
		if (num == 0) {
			return sum;
		}
		sum += num % 10;
		return addDigitsRecursively(num / 10, sum);
	}

}
