package com.java.iq.core.companies.amazon;

/**
 * Java program to find the element occurring odd number of times
 * 
 * @author SrikarRao
 *
 */

public class OddOccurance {
	int getOddOccurrence(int ar[], int ar_size) {
		int i;
		int res = 0;
		for (i = 0; i < ar_size; i++) {
			res = res ^ ar[i];
		}
		return res;
	}

	public static void main(String[] args) {
		OddOccurance occur = new OddOccurance();
		int ar[] = new int[] { 2, 2, 3, 8, 4, 8, 2, 4, 3, 8, 4, 4, 2 };
		int n = ar.length;
		System.out.println(occur.getOddOccurrence(ar, n));
	}
}