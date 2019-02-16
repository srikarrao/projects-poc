package com.java.iq.core.bsearch;

import org.junit.Assert;

public class SmallesLetterGreaterThanTarget {
	private static char nextGreatestLetter(char[] array, char target) {

		if (array == null) {
			return '\0';
		}

		int low = 0;
		int high = array.length - 1;
		char result = array[low];
		while (low <= high) {
			int mid = low + (high - low) / 2;
			char value = array[mid];
			if (value == target) {
				low = mid + 1;
			} else if (value > target) {
				result = value;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		System.out.println("Result for array: " + String.valueOf(array) + " is: " + result);
		return result;
	}

	public static void main(String[] args) {

		Assert.assertEquals("Null array", '\0', nextGreatestLetter(null, 'p'));
		Assert.assertEquals("Test case 1", 'c', nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'j'));
		Assert.assertEquals("Test case 2", 'n',
				nextGreatestLetter(new char[] { 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n' }, 'e'));
		Assert.assertEquals("Test case 3", 'c', nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'a'));
		Assert.assertEquals("Test case 4", 'f', nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'c'));
		Assert.assertEquals("Test case 5", 'f', nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'd'));
		Assert.assertEquals("Test case 6", 'j', nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'g'));
		Assert.assertEquals("Test case 7", 'c', nextGreatestLetter(new char[] { 'c', 'f', 'j' }, 'k'));
	}
}