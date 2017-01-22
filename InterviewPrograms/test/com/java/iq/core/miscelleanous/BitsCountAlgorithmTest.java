package com.java.iq.core.miscelleanous;

import static org.junit.Assert.*;

import org.junit.Test;
import com.java.iq.core.bitManipulation.BitsCountAlgorithm;

public class BitsCountAlgorithmTest {

	/**
	 * Method to perform test cases
	 */
	@Test
	public void test() {
		assertEquals(BitsCountAlgorithm.countBits(8), 1);
		assertEquals(BitsCountAlgorithm.countBits(0), 0);
		assertEquals(BitsCountAlgorithm.countBits(9), 2);
		assertEquals(BitsCountAlgorithm.countBits(15), 4);
	}
}
