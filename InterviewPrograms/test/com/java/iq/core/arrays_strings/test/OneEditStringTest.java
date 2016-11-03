package com.java.iq.core.arrays_strings.test;

import org.junit.Test;

import com.java.iq.core.arrays_strings.OneEditString;

import static org.junit.Assert.*;

/**
 * Java Test class to test OneEditString program
 * 
 * @author SrikarRao
 *
 */
public class OneEditStringTest {
	@Test
	public void test() {
		assertTrue(OneEditString.checkIfOneEditAway("pale", "ple"));
		assertTrue(OneEditString.checkIfOneEditAway("pales", "pale"));
		assertTrue(OneEditString.checkIfOneEditAway("pale", "bale"));
		assertFalse(OneEditString.checkIfOneEditAway("pale", "bae"));
		assertFalse(OneEditString.checkIfOneEditAway("pale", "pale"));
		assertTrue(OneEditString.checkIfOneEditAway("", " "));
		assertFalse(OneEditString.checkIfOneEditAway("", ""));
		assertFalse(OneEditString.checkIfOneEditAway("pale", "baerrrrr"));
		assertFalse(OneEditString.checkIfOneEditAway("xyz", null));
	}

}
