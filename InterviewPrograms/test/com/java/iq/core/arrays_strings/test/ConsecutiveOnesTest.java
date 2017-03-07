package com.java.iq.core.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ConsecutiveOnesTest {

	@Test
	public void test() {

		int[] testCase1 = null;
		assertEquals("testcase-1: When array is null", 0,
				ConsecutiveOnes.countConsecutiveOnes(testCase1));

		int[] testCase2 = {};
		assertEquals("testcase-2: When array is empty", 0,
				ConsecutiveOnes.countConsecutiveOnes(testCase2));

		int[] testCase3 = { 1 };
		assertEquals("testcase-3: When array has only one 1", 1,
				ConsecutiveOnes.countConsecutiveOnes(testCase3));

		int[] testCase4 = { 1, 1 };
		assertEquals("testcase-4: When array has only two 1s", 2,
				ConsecutiveOnes.countConsecutiveOnes(testCase4));

		int[] testCase5 = { 1, 0, 1 };
		assertEquals("testcase-5: When array has only non-consecutive 1s", 1,
				ConsecutiveOnes.countConsecutiveOnes(testCase5));

		int[] testCase6 = { 1, 1, 1 };
		assertEquals("testcase-6: When array has all consecutive 1s", 3,
				ConsecutiveOnes.countConsecutiveOnes(testCase6));

		int[] testCase7 = { 0, 0, 0 };
		assertEquals("testcase-7: When array has only no 1s", 0,
				ConsecutiveOnes.countConsecutiveOnes(testCase7));

		int[] testCase8 = { 1, 0, 1, 1 };
		assertEquals("testcase-8: When array has only consecutive 1s ending",
				2, ConsecutiveOnes.countConsecutiveOnes(testCase8));

		int[] testCase9 = { 1, 1, 0, 0, 1 };
		assertEquals("testcase-9: When array has only consecutive 1s starting",
				2, ConsecutiveOnes.countConsecutiveOnes(testCase9));

		int[] testCase10 = { 10, 7, 0, 0, 1 };
		assertEquals("testcase-10: When array has only one 1s ending", 1,
				ConsecutiveOnes.countConsecutiveOnes(testCase10));

		int[] testCase11 = { 1, 7, 0, 0, 10 };
		assertEquals("testcase-10: When array has only one 1s starting", 1,
				ConsecutiveOnes.countConsecutiveOnes(testCase11));
	}
}
