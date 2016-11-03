package com.java.iq.core.miscelleanous;

import java.util.Scanner;

public class CoinMaker {
	private static final int quarter = 25;
	private static final int dime = 10;
	private static final int nickel = 5;
	private static final int penny = 1;

	public static void main(String[] args) {

		try {
			Scanner scn = new Scanner(System.in);
			System.out.println("Enter the value to get minimum coins count");
			double value = scn.nextDouble();
			int realValue = (int) (value * 100);
			if (realValue > 0) {
				calculateCoins(realValue);
			} else {
				System.out.println("Currency cannot be less than a cent");
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void calculateCoins(int coinvalue) {
		int totalCoins = 0;
		int quarterCount = 0;
		int dimeCount = 0;
		int nickelCount = 0;
		int pennyCount = 0;

		if (coinvalue >= quarter) {
			quarterCount = coinvalue / quarter;
			coinvalue %= quarter;
			totalCoins += quarterCount;
		}
		if (coinvalue >= dime) {
			dimeCount = coinvalue / dime;
			coinvalue %= dime;
			totalCoins += dimeCount;
		}
		if (coinvalue >= nickel) {
			nickelCount = coinvalue / nickel;
			coinvalue %= nickel;
			totalCoins += nickelCount;
		}
		if (coinvalue >= penny) {
			pennyCount = coinvalue / penny;
			totalCoins += pennyCount;
		}
		System.out.println("Number of coins: " + totalCoins + " | "
				+ quarterCount + " quarterCount | " + dimeCount
				+ " dimeCount | " + nickelCount + " nickelCount | "
				+ pennyCount + " Cents");
	}
}