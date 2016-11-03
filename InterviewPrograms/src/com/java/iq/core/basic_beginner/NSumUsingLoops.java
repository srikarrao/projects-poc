package com.java.iq.core.basic_beginner;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to find sum of N numbers using loops
 * 
 * @author SrikarRao
 *
 */
public class NSumUsingLoops {

	/**
	 * nested static class to hold the values of a, b, n
	 * 
	 * @author SrikarRao
	 *
	 */
	public static class Testcase {
		private int a;
		private int b;
		private int n;

		/**
		 * Constructor to assign values for a, b, n
		 * 
		 * @param a
		 * @param b
		 * @param n
		 */
		public Testcase(int a, int b, int n) {
			this.a = a;
			this.b = b;
			this.n = n;
		}
	}

	public static void main(String[] args) {
		// arraylist containing the testcases
		List<Testcase> testcases = new ArrayList<Testcase>();
		testcases.add(new Testcase(10, 2, 10));
		testcases.add(new Testcase(1, 20, 14));
		findSum(testcases); // invocation of find sum method
	}

	/**
	 * method to find the sum of N numbers for all testcases
	 */
	private static void findSum(List<Testcase> testcase) {

		if (null != testcase) { // null check for arraylist
			int t = testcase.size(); // number of test cases
			if (t <= 500) { // check if test cases less than 500
				for (int i = 0; i < t; i++) { // iterate each testcase
					int total = 0;
					int a = testcase.get(i).a; // local variable a
					int b = testcase.get(i).b; // local variable b
					int n = testcase.get(i).n; // local variable n
					int j = 1;
					// check if a,b are >= 0 and <=50 , n <=15
					if ((a >= 0 && a <= 50) && (b >= 0 && b <= 50) && (n <= 15)) {
						// calculate a + (b * 2^0)
						total = (a + (b * findPower(2, 0)));
						// iterate using while to find the total sum
						while (j < n) {
							total = total + (b * findPower(2, j++));
						}
						// display the total for all testcases
						System.out.println("testcase " + (i + 1) + " : "
								+ total);
					}
				}
			}
		}
	}

	/**
	 * method to find the exponential value of an integer
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static int findPower(int a, int b) {
		int res = 1; // local variable res
		/**
		 * loop iterating the power values
		 */
		for (int i = 1; i <= b; i++) {
			res *= a;
		}
		return res;
	}
}
