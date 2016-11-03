package com.java.iq.core.arrays_strings.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.iq.core.arrays_strings.PalindromePermutation;

/**
 * Java test class to test PalindromePermutation program
 * 
 * @author SrikarRao
 *
 */
public class PalindromePermutationTest {

	/**
	 * Method to perform test cases
	 */
	@Test
	public void test() {
		assertTrue("test if formiddable palindrome",
				PalindromePermutation.isPermutationPalindrome("Tact Coa"));
	}
}
