package com.java.iq.core.bitManipulation;

/**
 * JAVA program to count the number of bits in a number
 * 
 * (Bits Count/Brian Kernighan’s Algorithm)
 * 
 * @author SrikarRao
 *
 */
public class BitsCountAlgorithm {

	public static int countBits(int number) {
		int count = 0;
		while (number > 0) {
			count++;
			number &= number - 1;
		}
		return count;
	}
}
