package com.java.iq.core.arrays_strings.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.java.iq.core.arrays_strings.ReplaceDuplicates_2;

/**
 * JAVA Test class to test the ReplaceDuplicates program
 * 
 * @author SrikarRao
 *
 */
public class ReplaceDuplicatesTest_2 {

	/**
	 * method to perform test cases
	 */
	@Test
	public void test() {
		assertEquals("String does not have any duplicates",
				ReplaceDuplicates_2.replaceDuplicates(new String("abcd")
						.toCharArray()), "[a, b, c, d]");
		assertEquals("String contains all duplicates",
				ReplaceDuplicates_2.replaceDuplicates(new String("aaaa")
						.toCharArray()), "[a]");
		assertEquals("Null", ReplaceDuplicates_2.replaceDuplicates(new String()
				.toCharArray()), "");
		assertEquals("Empty String",
				ReplaceDuplicates_2.replaceDuplicates(new String("")
						.toCharArray()), "");
		assertEquals("Continous duplicates String",
				ReplaceDuplicates_2.replaceDuplicates(new String("aaabbb")
						.toCharArray()), "[a, b]");
		assertEquals("Non-continous duplicates String",
				ReplaceDuplicates_2.replaceDuplicates(new String("abababa")
						.toCharArray()), "[a, b]");
	}
}
