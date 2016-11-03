package com.java.iq.core.basic_beginner;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Java Program to find the divisors of a number
 *
 */
public class Divisors {
	// Scanner object to take input from keyboard
	public static Scanner scn = new Scanner(System.in);
	public static Map<Integer, Integer> divisorsHash = new TreeMap<Integer, Integer>();
	public static int num;

	public static void main(String[] args) {
		// Ask user to give the input
		System.out.println("Enter a number to find it's divisors");
		doProcess();
	}

	/**
	 * Method to validate the input and Invoke the methods
	 */
	public static void doProcess() {
		num = scn.nextInt();
		// Condition to check if the input is >100 and <700
		if (num < 100 || num > 700) {
			// Ask the user to resubmit the input
			System.out
					.println("Enter the correct number, i.e., between 100 and 700");
			doProcess();
		} else {
			findDivisors();
			System.out.println();
			exponentialFindDivisors(num);

		}
	}

	/**
	 * Method 1 to find the divisors
	 */
	public static void findDivisors() {
		System.out.println("Method #1 to find divisors!");
		int i = 2;
		int counter = 0;
		int val1 = num;
		while (i <= val1) {
			if (val1 > 0) {
				if (val1 % i == 0) {
					if (counter > 0) {
						System.out.print("*" + i);
					} else {
						System.out.print(val1 + " = " + i);
					}
					val1 /= i;
					counter++;
				} else {
					i++;
				}
			}
		}
	}

	/**
	 * Method 2 using Map data structure to find the divisors
	 *
	 * @param val2
	 */
	public static void exponentialFindDivisors(int val2) {
		System.out.println("Method #2 to find the divisors!! [Bonus]");
		num = val2;
		int i = 2;
		while (i <= num) {
			if (num > 0) {
				if (num % i == 0) {
					if (divisorsHash.containsKey(i)) {
						// condition to check if the value of i exists
						divisorsHash.put(i, divisorsHash.get(i) + 1);
					} else {
						divisorsHash.put(i, 1);
					}
					num /= i;
				} else {
					i++;
				}
			}
		}
		Set set = divisorsHash.entrySet();
		Iterator iterator = set.iterator();
		int counter = 0;
		while (iterator.hasNext()) { // iterate the treeMap
			Map.Entry mentry = (Map.Entry) iterator.next();
			if (counter == 0) {
				System.out.print(val2 + " = " + mentry.getKey() + "^"
						+ mentry.getValue());
			} else {
				System.out.print(" * " + mentry.getKey() + "^"
						+ mentry.getValue());
			}
			counter++;
		}
	}
}
