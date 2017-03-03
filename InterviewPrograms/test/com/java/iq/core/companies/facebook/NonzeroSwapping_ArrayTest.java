package com.java.iq.core.companies.facebook;

import org.junit.Assert;
import org.junit.Test;

/**
 * Java program to test NonzeroSwapping_Array
 * 
 * @author SrikarRao.Gandla
 *
 */
public class NonzeroSwapping_ArrayTest {

	@Test
	public void test() {

		// test case-1: When array is null
		int[] arrTestcase1 = null;
		Assert.assertArrayEquals(null,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase1));

		// test case-2: When array is empty
		int[] arrTestcase2 = new int[0];
		int[] arrTestRes2 = null;
		Assert.assertArrayEquals(arrTestRes2,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase2));

		// test case-3: When array is all non-zero
		int[] arrTestcase3 = { 10, 7, -5, 13, 9, 1, 2 };
		int[] arrTestRes3 = { 10, 7, -5, 13, 9, 1, 2 };
		Assert.assertArrayEquals(arrTestRes3,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase3));

		// test case-4: When array is all zeros
		int[] arrTestcase4 = { 0, 0, 0, 0, 0, 0, 0 };
		int[] arrTestRes4 = { 0, 0, 0, 0, 0, 0, 0 };
		Assert.assertArrayEquals(arrTestRes4,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase4));

		// test case-5: When array is both zeros and non-zeros
		int[] arrTestcase5 = { 0, 7, 0, 3, 0, 0, 2 };
		int[] arrTestRes5 = { 0, 0, 0, 0, 3, 7, 2 };
		Assert.assertArrayEquals(arrTestRes5,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase5));

		/**
		 * test case-6: When array is both zeros and non-zeros (corner case-1:
		 * ending zero)
		 */
		int[] arrTestcase6 = { 0, 7, 0, 3, 0, 2, 0 };
		int[] arrTestRes6 = { 0, 0, 0, 0, 3, 2, 7 };
		Assert.assertArrayEquals(arrTestRes6,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase6));

		/**
		 * test case-7: When array is both zeros and non-zeros (corner case-2 :
		 * leading zeros)
		 */

		int[] arrTestcase7 = { 0, 0, 0, 0, 3, 7, 2 };
		int[] arrTestRes7 = { 0, 0, 0, 0, 3, 7, 2 };
		Assert.assertArrayEquals(arrTestRes7,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase7));

		/**
		 * test case-8: When array is both zeros and non-zeros (corner case-3 :
		 * leading non-zeros)
		 */

		int[] arrTestcase8 = { 1, 7, 2, 0, 0, 0, 0 };
		int[] arrTestRes8 = { 0, 0, 0, 0, 2, 7, 1 };
		Assert.assertArrayEquals(arrTestRes8,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase8));

		/**
		 * test case-8: When array is both zeros and non-zeros (corner case-3 :
		 * starting zeros)
		 */
		int[] arrTestcase9 = { 0, 71, 22, 14, -10, 1, 7, 2 };
		int[] arrTestRes9 = { 0, 71, 22, 14, -10, 1, 7, 2 };

		Assert.assertArrayEquals(arrTestRes9,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase9));

		// other cases
		int[] arrTestcase10 = { 7, 90, 3, 10, 2, 0 };
		int[] arrTestRes10 = { 0, 90, 3, 10, 2, 7 };
		Assert.assertArrayEquals(arrTestRes10,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase10));

		int[] arrTestcase11 = { 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 };
		int[] arrTestRes11 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		Assert.assertArrayEquals(arrTestRes11,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase11));

		int[] arrTestcase12 = { 102, 120, 11, 61, 88, 12, 0, 10, 199, -19, 22,
				76, 9, 77 };
		int[] arrTestRes12 = { 0, 120, 11, 61, 88, 12, 102, 10, 199, -19, 22,
				76, 9, 77 };
		Assert.assertArrayEquals(arrTestRes12,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase12));

		int[] arrTestcase13 = { 7, 90, 3, 10, 2, 0, 80 };
		int[] arrTestRes13 = { 0, 90, 3, 10, 2, 7, 80 };
		Assert.assertArrayEquals(arrTestRes13,
				NonzeroSwapping_Array.swapArrayElements(arrTestcase13));
	}
}
