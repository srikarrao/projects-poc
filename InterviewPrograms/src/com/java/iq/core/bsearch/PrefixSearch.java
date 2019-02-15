package com.java.iq.core.bsearch;

import org.junit.Assert;

public class PrefixSearch {

	public static void main(String[] args) {
		Assert.assertEquals("Null array", -1, search(null, "P"));
		Assert.assertEquals("Empty array", -1, search(new String[] {}, "P"));
		Assert.assertEquals("Random Index. Found!", 3,
				search(new String[] { "Agarkar", "Clarke", "Kohli", "Parthiv", "Pruthi Shaw" }, "P"));
		Assert.assertEquals("Not Found!", -1,
				search(new String[] { "Agarkar", "Clarke", "Dravid", "Ganguly", "Kohli" }, "P"));
		Assert.assertEquals("Middle Index", 2,
				search(new String[] { "Agarkar", "Clarke", "Pietersen", "Pruthi Shaw", "Sachin" }, "P"));
		Assert.assertEquals("Index 0", 0, search(new String[] { "Pietersen", "Sachin" }, "P"));
		Assert.assertEquals("Index 1", 1, search(new String[] { "Kohli", "Pietersen" }, "P"));
		Assert.assertEquals("Size 1. Found", 0, search(new String[] { "Ponting" }, "P"));
		Assert.assertEquals("Size 1. Not Found", -1, search(new String[] { "Root" }, "P"));
	}

	private static int search(String[] words, String searchPrefix) {

		if (words == null || words.length == 0) {
			return -1;
		}
		int low = 0;
		int high = words.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			String prefix = words[mid].substring(0, 1);
			if (prefix.compareTo(searchPrefix) == 0) {
				return mid;
			} else if (prefix.compareTo(searchPrefix) > 0) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}

		}
		return -1;
	}
}
