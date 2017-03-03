package com.java.iq.core.companies.yapstone;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Java program to test the ProductDiscount API
 * 
 * @author SrikarRao.Gandla
 *
 */
public class ProductDiscountTest {

	@Test
	public void test() {

		int[] arrTestcase1 = null;

		assertEquals("testcase-1: When array is null",
				ProductDiscount.perform(arrTestcase1), 0);

		int[] arrTestcase2 = { 12 };
		assertEquals("testcase-2 When array is of size 1",
				ProductDiscount.perform(arrTestcase2), arrTestcase2[0]);

		int[] arrTestcase3 = { 5, 1 };
		assertEquals("When array applies discount (size = 2)",
				ProductDiscount.perform(arrTestcase3), 5);

		int[] arrTestcase4 = { 1, 5 };
		assertEquals("When array cannot apply discount (size = 2)",
				ProductDiscount.perform(arrTestcase4), 6);

		int[] arrTestcase5 = { 7, 7 };
		assertEquals("When array has equal values (size = 2)",
				ProductDiscount.perform(arrTestcase5), 7);

		int[] arrTestcase6 = { 5, 1, 3, 1, 9 };
		assertEquals("When array cannot apply discount (size = N)",
				ProductDiscount.perform(arrTestcase6), 16);

		int[] arrTestcase7 = { 1, 5, 5, 3, 9, 9 };
		assertEquals("When array cannot apply discount (size = N)",
				ProductDiscount.perform(arrTestcase7), 15);

		int[] arrTestcase8 = { 7, 7, 7, 7 };
		assertEquals("When array has equal values (size = N)",
				ProductDiscount.perform(arrTestcase8), 7);

		int[] arrTestcase9 = { 7, 7, 1, 7 };
		assertEquals("When array has equal values (size = N)",
				ProductDiscount.perform(arrTestcase9), 14);

		int[] arrTestcase10 = { 1, 2, 3, 4, 5, 6 };
		assertEquals("When array values are sorted-ascending (size = N)",
				ProductDiscount.perform(arrTestcase10), 21);

		int[] arrTestcase11 = { 6, 5, 4, 3, 2, 1 };
		assertEquals("When array values are sorted-descending (size = N)",
				ProductDiscount.perform(arrTestcase11), 6);
	}
}
