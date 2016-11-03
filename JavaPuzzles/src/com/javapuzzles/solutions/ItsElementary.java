package com.javapuzzles.solutions;

/**
 * Program to illustrate the use of "L" over "l" as long leteral
 * @author SrikarRao
 *
 */
public class ItsElementary {
	public static void main(String[] args) {
		System.out.println(12345 + 5432l); // Prints 17777 as 5432 is suffexed as "l" which specifies Long
		System.out.println(12345 + 54321); // Prints 66666
	}

}
