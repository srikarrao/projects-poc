package com.java.iq.core.arrays_strings.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.java.iq.core.arrays_strings.FrequencyCount;

public class FrequencyCountTest {

	/**
	 * method to perform test cases
	 */
	@Test
	public void test() {
		assertEquals("String passed for frequency count",
				FrequencyCount.implementFrequencyCount("srikar rao"),
				"(a : 2)(i : 1)(k : 1)(o : 1)(r : 3)(s : 1)");
	}
}
