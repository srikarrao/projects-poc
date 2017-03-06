package com.java.iq.core.companies.google;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Java program to test the Pivot Index API
 * 
 * @author SrikarRao.Gandla
 *
 */
public class PivotIndexTest {

	@Test
	public void test() {

		int[] arrTestcase1 = null;
		assertEquals("testcase-1: When array is null", -1,
				PivotIndex.findIndex(arrTestcase1));

		int[] arrTestcase2 = new int[0];
		assertEquals("testcase-2: When array is empty", -1,
				PivotIndex.findIndex(arrTestcase2));

		int[] arrTestcase3 = { 1, 2, 3, 4, 0, 6 };
		assertEquals("testcase-4: When array is having values", 3,
				PivotIndex.findIndex(arrTestcase3));
		
		int[] arrTestcase4 = { 0, 0, 0, 0, 0, 0 };
		assertEquals("testcase-4: When array is having all zeros", 0,
				PivotIndex.findIndex(arrTestcase4));
	}
}
