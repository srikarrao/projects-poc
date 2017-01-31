package com.java.iq.core.companies.uber;

import java.util.*;

/**
 * 
 * A file contains strings like abcd 3.0 xyx 4.0 foobar 5.0 return random string
 * but probability should be based on Probed average
 */
public class RandomItemChooser {

	public static void main(String[] args) {
		Item item1 = new Item("abcd",3.0);
		Item item2 = new Item("xyx",4.0);
		Item item3 = new Item("foobar",5.0);
		List<Item> itemsList = Arrays.asList(item1, item2, item3);
		Item res = chooseOnProb(itemsList);
		System.out.println(res.str+","+res.prob);
	}

	private static class Item {
		private String str;
		private double prob;

		public Item(String str, double prob) {
			this.str = str;
			this.prob = prob;
		}
	}

	private static Item chooseOnProb(List<Item> items) {
		double completeProb = 0.0;
		for (Item item : items)
			completeProb += item.prob;
		double r = Math.random() * completeProb;
		double countProb = 0.0;
		for (Item item : items) {
			countProb += item.prob;
			if (countProb >= r)
				return item;
		}
		throw new RuntimeException("Should never be shown.");
	}
}
