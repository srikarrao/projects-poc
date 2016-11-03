package com.javapuzzles.solutions;

/**
 * This program illustrates the silent overflow problem when computing with long
 * data type
 * NOTE: JAVA doesn't have target typing feature 
 * @author SrikarRao
 *
 */
public class LongDivison {

	public static void main(String[] args) {
		// Variable values included Long literal "L" which performs the
		// calculation in Long
		final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
		System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
	}

}
