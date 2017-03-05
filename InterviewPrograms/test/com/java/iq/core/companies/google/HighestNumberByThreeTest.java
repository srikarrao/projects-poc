package com.java.iq.core.companies.google;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Java program to test HighestNumberByThree API
 * @author SrikarRao
 *
 */
public class HighestNumberByThreeTest {

	@Test
	public void test() {

		int[] arr1 = null;
		assertEquals("array as null",
				HighestNumberByThree.getHigestNumDivisibleByThree(arr1), -1);

		int[] arr2 = {};
		assertEquals("array with empty values",
				HighestNumberByThree.getHigestNumDivisibleByThree(arr2), -1);

		int[] arr3 = { 9, 4, 3, 2, 4 };
		assertEquals("array with two same values",
				HighestNumberByThree.getHigestNumDivisibleByThree(arr3), 9432);

		int[] arr4 = { 9, 4, 3, 2 };
		assertEquals("array with different values",
				HighestNumberByThree.getHigestNumDivisibleByThree(arr4), 9432);

		int[] arr5 = { 1, 1, 1, 1 };
		assertEquals("array with all same values",
				HighestNumberByThree.getHigestNumDivisibleByThree(arr5), 111);

		int[] arr6 = { 1, 1, 1 };
		assertEquals("array with all same values",
				HighestNumberByThree.getHigestNumDivisibleByThree(arr6), 111);

		int[] arr7 = { 1, 7, 0 };
		assertEquals("array with all same values",
				HighestNumberByThree.getHigestNumDivisibleByThree(arr7), 0);

		int[] arr8 = { 0, 0, 0 };
		assertEquals("array with all same values",
				HighestNumberByThree.getHigestNumDivisibleByThree(arr8), 0);

	}
}
