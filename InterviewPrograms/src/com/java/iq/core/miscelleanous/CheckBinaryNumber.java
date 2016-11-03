package com.java.iq.core.miscelleanous;

/**
 * Check if a number is binary or not
 * 
 * @author SrikarRao
 *
 */
public class CheckBinaryNumber {

	public static void main(String[] args) {
		System.out.println(isBinary(101));
		System.out.println(isBinary(111));
		System.out.println(isBinary(1));
		System.out.println(isBinary(10101));
		System.out.println(isBinary(0000));
		System.out.println(isBinary(999));
		System.out.println(isBinary(2));
	}

	private static boolean isBinary(int num) {

		if (num == 0) {
			return true;
		}

		if (num % 10 != 0 && num % 10 != 1) {
			return false;
		}
		num /= 10;

		return isBinary(num);
	}
}