package com.java.iq.core.companies.microsoft;

import org.junit.Assert;
import org.junit.Test;

public class ArrayLoopValidatorTest {

	@Test
	public void test() {

		// test case-1: When array is null
		int[] arrTestcase1 = null;
		Assert.assertFalse(ArrayLoopValidator.hasLoop(arrTestcase1));

		// test case-2: When array is empty
		int[] arrTestcase2 = new int[0];
		Assert.assertFalse(ArrayLoopValidator.hasLoop(arrTestcase2));

		// test case-3: When array having loop
		int[] arrTestcase3 = { 2, -1, 1, 2, 2 };
		Assert.assertTrue(ArrayLoopValidator.hasLoop(arrTestcase3));

		// test case-4: When array not having loop
		int[] arrTestcase4 = { 2, 1, 0, 2, 0 };
		Assert.assertFalse(ArrayLoopValidator.hasLoop(arrTestcase4));
	}
}
