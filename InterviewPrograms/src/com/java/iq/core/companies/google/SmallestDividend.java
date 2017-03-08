package com.java.iq.core.companies.google;

/**
 * Given a number A, find the smallest number which has only 1s and 0s as its
 * digits which divisible by the number A.
 * 
 * @author SrikarRao.Gandla
 *
 */
public class SmallestDividend {

	public static void main(String[] args) {
		System.out.println(smallestOneZeroMultiple(3));
	}

	public static int smallestOneZeroMultiple(int divisible) {
		int mul = 2;
		int re = mul * divisible;
		while (re < 1111111111) {
			if (checkOnlyOneZero(re))
				return re;
			mul++;
			re = mul * divisible;
		}
		return -1;
	}

	public static boolean checkOnlyOneZero(int num) {
		int i = 0;
		while (num >= 10) {
			i = num % 10;
			num = num / 10;
			if (i == 1 || i == 0)
				continue;
			else
				return false;
		}
		if (num == 1 || num == 0)
			return true;
		else
			return false;
	}
}
