package com.java.iq.core.companies.google;

/**
 * Source: https://www.careercup.com/question?id=5707243546738688
 * 
 * @author SrikarRao
 *
 */
public class XOREvenDuplicates {

	public static void main(String[] args) {
		getEvenDuplicates();
	}

	private static void getEvenDuplicates() {
		int number[] = { 1, 6, 4, 1, 4, 5, 8, 8, 4, 6, 8, 8, 9, 7, 9, 5, 9 };
		int len = number.length;
		int tracker = 0;

		for (int i = 0; i < len; ++i) {
			int shifted = 1 << number[i];
			tracker ^= shifted;
		}

		for (int i = 0; i < len; ++i) {
			int shifted = 1 << number[i];
			if ((shifted & tracker) == 0) {
				tracker ^= shifted;
				System.out.println(number[i]);
			}
		}
	}
}