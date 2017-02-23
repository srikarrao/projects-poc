package com.java.iq.core.miscelleanous;

/**
 * Find number of Primes under the given number using Sieve of Eratosthenes
 * 
 * @author SrikarRao
 *
 */
public class PrimeNumbersSieveEratosthenes {

	public static int PrimesCount(int n) {

		if(n<0){
			return -1;
		}
		
		
		// initially assume all integers are prime
		boolean[] isPrime = new boolean[n + 1];
		for (int i = 2; i <= n; i++) {
			isPrime[i] = true;
		}

		// mark non-primes <= n using Sieve of Eratosthenes
		for (int factor = 2; factor * factor <= n; factor++) {

			// if factor is prime, then mark multiples of factor as non-prime
			// suffices to consider multiples factor, factor+1, ..., n/factor
			if (isPrime[factor]) {
				for (int j = factor; factor * j <= n; j++) {
					isPrime[factor * j] = false;
				}
			}
		}

		// count primes
		int primes = 0;
		for (int i = 2; i <= n; i++) {
			if (isPrime[i])
				primes++;
		}

		return primes;
	}
}