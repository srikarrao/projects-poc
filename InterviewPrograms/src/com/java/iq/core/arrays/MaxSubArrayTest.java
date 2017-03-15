package com.java.iq.core.dp;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaxSubArrayTest {

	@Test
	public void test() {

		int[] testcase1 = null;
		Range rt1 = null;
		assertEquals(rt1, MaxSubArray.findMaxSubArray(testcase1));

		int[] testcase2 = {};
		Range rt2 = null;
		assertEquals(rt2, MaxSubArray.findMaxSubArray(testcase2));

		int[] testcase3 = { 904, 40, 523, 12, -335, -385, -124, 481, -31 };
		Range rt3 = new Range(0, 4);
		assertEquals(rt3, MaxSubArray.findMaxSubArray(testcase3));

		int[] testcase4 = { -904, 40, 523, 12, -335, -385, -124, 481, -31 };
		Range rt4 = new Range(1, 4);
		assertEquals(rt4, MaxSubArray.findMaxSubArray(testcase4));

		int[] testcase5 = { -904, 40, -523, 12, -335, -385, -124, 481, -31 };
		Range rt5 = new Range(7, 8);
		assertEquals(rt5, MaxSubArray.findMaxSubArray(testcase5));

		int[] testcase6 = { -904, -40, -523, -12, -335, -385, -124, -481, -31 };
		Range rt6 = new Range(3, 4);
		assertEquals(rt6, MaxSubArray.findMaxSubArray(testcase6));

		int[] testcase7 = { -904, -40, -523, -12, -335, -385, -124, -481, 31 };
		Range rt7 = new Range(8, 9);
		assertEquals(rt7, MaxSubArray.findMaxSubArray(testcase7));

		int[] testcase8 = { 904, -40, -523, -12, -335, -385, -124, -481, -31 };
		Range rt8 = new Range(0, 1);
		assertEquals(rt8, MaxSubArray.findMaxSubArray(testcase8));

		int[] testcase9 = { 904, 40, 523, 12, 335, 385, 124, 481, 31 };
		Range rt9 = new Range(0, 9);
		assertEquals(rt9, MaxSubArray.findMaxSubArray(testcase9));
	}
}
