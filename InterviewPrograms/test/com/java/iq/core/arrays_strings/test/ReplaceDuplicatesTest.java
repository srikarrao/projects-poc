package com.java.iq.core.arrays_strings.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.java.iq.core.arrays_strings.ReplaceDuplicates;

/**
 * JAVA Test class to test the ReplaceDuplicates program
 * 
 * @author SrikarRao
 *
 */
public class ReplaceDuplicatesTest {

	/**
	 * method to perform test cases
	 */
	@Test
	public void test() {
		assertEquals("String does not have any duplicates",
				ReplaceDuplicates.replaceDuplicates(new String("abcd")
						.toCharArray()), "[a, b, c, d]");
		assertEquals("String contains all duplicates",
				ReplaceDuplicates.replaceDuplicates(new String("aaaa")
						.toCharArray()), "[a]");
		assertEquals(
				"Null",
				ReplaceDuplicates.replaceDuplicates(new String().toCharArray()),
				"");
		assertEquals("Empty String",
				ReplaceDuplicates.replaceDuplicates(new String("")
						.toCharArray()), "");
		assertEquals("Continous duplicates String",
				ReplaceDuplicates.replaceDuplicates(new String("aaabbb")
						.toCharArray()), "[a, b]");
		assertEquals("Non-continous duplicates String",
				ReplaceDuplicates.replaceDuplicates(new String("abababa")
						.toCharArray()), "[a, b]");
	}
}
