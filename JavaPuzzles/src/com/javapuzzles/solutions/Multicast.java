package com.javapuzzles.solutions;

public class Multicast {

	public static void main(String[] args) {

		/**
		 * Solution: -1 is an int attaining a value of 1111 1111 1111 1111 1111
		 * 1111 1111 1111 (-1 value in binary, 32 bits) The attained int value
		 * undergoes narrowing primitive typing such that the value is 1111
		 * 1111(-1 value in binary,8 bits) The byte value cannot be further
		 * undergone widening primitive typing to char as it is unsigned literal
		 * and such that byte is converted to int int value is then converted to
		 * char (initial value is -1 (byte literal type) so extension should be
		 * -1, if char it would have been extension 0 Finally char max value
		 * pow(2,16)-1 (byte extension) = 65536 - 1 = 65,535 (int) 65,535 is
		 * 65,535
		 * 
		 */
		System.out.println((int) (char) (byte) -1);
	}
}
