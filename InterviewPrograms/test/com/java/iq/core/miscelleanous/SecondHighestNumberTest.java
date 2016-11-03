package com.java.iq.core.miscelleanous;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Test;

public class SecondHighestNumberTest {

	/**
	 * Method to perform test cases
	 */
	@Test
	public void test() {

		// list is null
		assertEquals(SecondHighestNumber.findSecondHighestNum(null), -1);

		// less than 2 elements
		assertEquals(
				SecondHighestNumber.findSecondHighestNum(new ArrayList<Integer>(
						Arrays.asList(11))), -1);
		// list with elements
		assertEquals(
				SecondHighestNumber.findSecondHighestNum(new ArrayList<Integer>(
						Arrays.asList(11, 5, 2, 7, 3))), 7);

		// list with only two elements
		assertEquals(
				SecondHighestNumber.findSecondHighestNum(new ArrayList<Integer>(
						Arrays.asList(2, 3))), 2);

		// list with negative numbers
		assertEquals(
				SecondHighestNumber.findSecondHighestNum(new ArrayList<Integer>(
						Arrays.asList(2, 1, -12, -7, 18, -90, 3))), 3);
	}
}
