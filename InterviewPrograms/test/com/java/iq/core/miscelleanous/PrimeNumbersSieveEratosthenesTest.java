package com.java.iq.core.miscelleanous;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Java program to test the Prime Numbers count using Sieve Eratosthenes
 * 
 * @author SrikarRao
 *
 */
public class PrimeNumbersSieveEratosthenesTest {

	@Test
	public void Test() {

		// passing valid numbers
		assertEquals(PrimeNumbersSieveEratosthenes.PrimesCount(25), 9);
		assertEquals(PrimeNumbersSieveEratosthenes.PrimesCount(225), 48);

		// passing 0
		assertEquals(PrimeNumbersSieveEratosthenes.PrimesCount(0), 0);

		// passing 1
		assertEquals(PrimeNumbersSieveEratosthenes.PrimesCount(1), 0);

		// passing negative number
		assertEquals(PrimeNumbersSieveEratosthenes.PrimesCount(-111), -1);

	}
}
