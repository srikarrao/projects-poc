package com.java.iq.core.basic_beginner;

public class GCD {
	private static int i = 1;
	private static int result = 0;
	private static int low;
	private static int high;

	public static void main(String[] args) {
		int x = 120;
		int y = 1200;

		if (x < y) {
			low = x;
			high = y;
		} else {
			high = x;
			low = y;
		}
		getGCD();
	}

	public static void getGCD() {
		if (i <= low) {
			if ((low % i == 0) && (high % i == 0)) {
				result = i;
			}
			i++;
			getGCD();
		} else {
			System.out.println("GCD is: " + result);
		}
	}
}
