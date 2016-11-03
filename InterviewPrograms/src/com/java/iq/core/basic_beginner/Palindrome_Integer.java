package com.java.iq.core.basic_beginner;

import java.util.Scanner;

public class Palindrome_Integer {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter the number: ");
		int originalNum = input.nextInt();
		int number = originalNum;
		int revereseNum = 0;
		while (number != 0) {
			int remainder = number % 10;
			revereseNum = revereseNum * 10 + remainder;
			number = number / 10;
		}
		if (originalNum == revereseNum) {
			System.out
					.println("The number " + originalNum + " is a palindrome");
		} else {
			System.out.println("The number is " + originalNum
					+ "  NOT a palindrome");
		}
	}

}
