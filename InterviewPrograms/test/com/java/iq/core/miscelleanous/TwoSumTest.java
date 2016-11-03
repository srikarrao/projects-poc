package com.java.iq.core.miscelleanous;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;
import com.java.iq.core.miscelleanous.TwoSum;

public class TwoSumTest {

	/**
	 * Method to perform test cases
	 */
	@Test
	public void test() {
		// list is null
		assertFalse(TwoSum.hasTwoSum(null, 0));

		// List size < 2 elements
		assertFalse(TwoSum.hasTwoSum(new ArrayList<Integer>(Arrays.asList(11)),
				21));

		// List more than 2 elements
		assertTrue(TwoSum.hasTwoSum(
				new ArrayList<Integer>(Arrays.asList(11, 5, 2, 7, 3)), 14));

		// List more than 2 elements
		assertTrue(TwoSum
				.hasTwoSum(
						new ArrayList<Integer>(Arrays.asList(11, -15, 2, 1, 17,
								20, 3)), 5));
		// negative numbers
		assertTrue(TwoSum
				.hasTwoSum(
						new ArrayList<Integer>(Arrays.asList(-11, -15, 2, 1,
								17, 20, 3)), 6));
		assertFalse(TwoSum
				.hasTwoSum(
						new ArrayList<Integer>(Arrays.asList(-11, -15, 2, 1,
								17, 20, 3)), -6));
	
	}
}
