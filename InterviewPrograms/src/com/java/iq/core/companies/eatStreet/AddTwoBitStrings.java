package com.java.iq.core.companies.eatStreet;

public class AddTwoBitStrings {

	// The main function that adds two bit sequences and returns the addition
	private static String addBitStrings(String str1, String str2) {
		String result = "";

		int len1 = str1.length();
		int len2 = str2.length();
		int length = 0;

		if (len1 < len2) {
			for (int i = 0; i < len2 - len1; i++)
				str1 = '0' + str1;
			length = len2;
		} else if (len1 > len2) {
			for (int i = 0; i < len1 - len2; i++)
				str2 = '0' + str2;
			length = len1;
		}
		// make the lengths same before adding

		int carry = 0; // Initialize carry

		// Add all bits one by one
		for (int i = length - 1; i >= 0; i--) {
			int firstBit = str1.charAt(i) - '0';
			int secondBit = str2.charAt(i) - '0';

			// boolean expression for sum of 3 bits
			int sum = (firstBit ^ secondBit ^ carry) + '0';

			result = (char) sum + result;

			// boolean expression for 3-bit addition
			carry = (firstBit & secondBit) | (secondBit & carry)
					| (firstBit & carry);
		}

		// if overflow, then add a leading 1
		if (carry == 1)
			result = '1' + result;

		return result;
	}

	public static void main(String[] args) {
		String str1 = "1100011";
		String str2 = "10";
		System.out.println("Sum is " + addBitStrings(str1, str2));
	}
}