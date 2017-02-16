package com.java.iq.core.basic_beginner;

import java.util.Scanner;

public class FibannociSeries {

	private static int i = 2;
	private static int[] f = new int[1000];

	public static void main(String[] args) {
		System.out.println("Fib-method-2 " + doFibanonci2(22));
		doFibannoci();
	}

	public static void doFibannoci() {
		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Please enter size for the fibanonci series");
			int fSize = scn.nextInt();
			int[] fNumber = new int[fSize];
			if (fSize > 0) {
				fNumber[0] = 1;
				if (fSize == 1) {
					System.out.println("Fibanoci series of size " + fSize
							+ " is: " + fNumber[0]);
				} else if (fSize > 2) {
					fNumber[1] = fNumber[0];
					System.out.print("Fibanoci series of size " + fSize
							+ " is: " + fNumber[0] + " " + fNumber[1] + " ");
					doFibanonci1(fNumber);
				}

			} else {
				System.out.print("Fibannoci size should be 1 or more than 1");
			}
		} catch (Exception e) {
			System.out.println("Illegal value " + e);
		}
	}

	public static void doFibanonci1(int[] fNumber) {
		if (i < fNumber.length) {
			fNumber[i] = fNumber[i - 1] + fNumber[i - 2];
			System.out.print(fNumber[i] + " ");
			i++;
			doFibanonci1(fNumber);
		}
	}

	/**
	 * method to perform fibonnaci series
	 * 
	 * Space: O(1) Time: O(n)
	 * 
	 * @param n
	 * @return
	 */
	private static int doFibanonci2(int n) {
		int a = 0, b = 1, c, i;
		if (n == 0)
			return a;
		for (i = 2; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return b;
	}
}
