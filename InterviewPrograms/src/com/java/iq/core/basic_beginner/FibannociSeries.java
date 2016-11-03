package com.java.iq.core.basic_beginner;

import java.util.Scanner;

public class FibannociSeries {

	private static int i = 2;

	public static void main(String[] args) {
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
					doFibanonci(fNumber);
				}
			} else {
				System.out.print("Fibannoci size should be 1 or more than 1");
			}
		} catch (Exception e) {
			System.out.println("Illegal value " + e);
		}
	}

	public static void doFibanonci(int[] fNumber) {
		if (i < fNumber.length) {
			fNumber[i] = fNumber[i - 1] + fNumber[i - 2];
			System.out.print(fNumber[i] + " ");
			i++;
			doFibanonci(fNumber);
		}
	}
}
