package com.java.iq.core.basic_beginner;

import java.util.Scanner;

public class PrimeNumbers {

	public static void main(String args[]) {
		System.out
				.println("Enter the number till which prime number to be printed: ");
		int limit = new Scanner(System.in).nextInt();
		int array[] = new int[limit / 2];
		System.out.println("Printing prime number from 1 to " + limit);
		int count = 0;
		for (int number = 2; number <= limit; number++) {
			if (isPrime(number)) {
				array[count] = number;
				count++;
			}
		}
		for (int i = 1; i < array.length; i++) {
			if (array[i] - array[i - 1] == 2) {
				System.out.println("Twin Primes are: " + array[i - 1] + " && "
						+ array[i]);
			}
		}

	}

	public static boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false; // number is divisible so its not prime
			}
		}
		return true; // number is prime now
	}
}
