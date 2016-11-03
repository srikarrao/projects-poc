package com.java.iq.core.arrays_strings.test;

import static org.junit.Assert.*;
import org.junit.Test;
import com.java.iq.core.arrays_strings.AnagramsFinder;

/**
 * JAVA test class to test the anagrams program
 * 
 * @author SrikarRao
 *
 */
public class AnagramsFinderTest {

	/**
	 * Method to perform test cases
	 */
	@Test
	public void test() {

		// test case string1 = null
		assertFalse(AnagramsFinder.areAnagrams_sorting(null, "levis"));
		assertFalse(AnagramsFinder.areAnagrams_conventional(null, "levis"));
		assertFalse(AnagramsFinder.areAnagrams_hashMap(null, "levis"));

		// test case string1 is empty
		assertFalse(AnagramsFinder.areAnagrams_sorting("", "hello"));
		assertFalse(AnagramsFinder.areAnagrams_conventional("", "hello"));
		assertFalse(AnagramsFinder.areAnagrams_hashMap("", "hello"));
		
		// test case strings are not anagrams and length is equal
		assertFalse(AnagramsFinder.areAnagrams_sorting("hello", "levis"));
		assertFalse(AnagramsFinder.areAnagrams_conventional("hello", "levis"));
		assertFalse(AnagramsFinder.areAnagrams_hashMap("hello", "levis"));
		
		// test case strings are not anagrams and length is not equal
		assertFalse(AnagramsFinder.areAnagrams_sorting("hello", "killers"));
		assertFalse(AnagramsFinder.areAnagrams_conventional("hello", "killers"));
		assertFalse(AnagramsFinder.areAnagrams_hashMap("hello", "killers"));
		
		// test case strings are anagrams
		assertTrue(AnagramsFinder.areAnagrams_sorting("lives", "levis"));
		assertTrue(AnagramsFinder.areAnagrams_conventional("lives", "levis"));
		assertTrue(AnagramsFinder.areAnagrams_hashMap("lives", "levis"));
		
		// test case if two string are empty
		assertTrue(AnagramsFinder.areAnagrams_sorting("", ""));
		assertTrue(AnagramsFinder.areAnagrams_conventional("", ""));
		assertTrue(AnagramsFinder.areAnagrams_hashMap("", ""));
	}
}