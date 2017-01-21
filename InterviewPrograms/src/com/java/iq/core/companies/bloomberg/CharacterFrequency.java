package com.java.iq.core.companies.bloomberg;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Java program to sort characters in a string by frequency
 * 
 * @author SrikarRao
 *
 */
public class CharacterFrequency {

	public static void main(String[] args) {

		Map<Character, Integer> hmap = new HashMap<Character, Integer>();
		String str = "abbcbadecae";
		for (int i = 0; i < str.length(); i++) {
			hmap.put(
					str.charAt(i),
					hmap.containsKey(str.charAt(i)) ? hmap.get(str.charAt(i)) + 1
							: 1);
		}

		StringBuilder sb = new StringBuilder();
		for (Character chr : sortByValues(hmap).keySet()) {
			for (int x = hmap.get(chr); x > 0; x--) {
				sb.append(chr);
			}
		}
		System.out.println(sb.toString());
	}

	private static Map<Character, Integer> sortByValues(
			Map<Character, Integer> map) {
		List<Entry<Character, Integer>> list = new LinkedList<Entry<Character, Integer>>(
				map.entrySet());

		Collections.sort(list, new Comparator<Entry<Character, Integer>>() {
			public int compare(Entry<Character, Integer> o1,
					Entry<Character, Integer> o2) {
				return ((Comparable<Integer>) ((Map.Entry<Character, Integer>) (o2))
						.getValue())
						.compareTo(((Map.Entry<Character, Integer>) (o1))
								.getValue());
			}
		});

		Map<Character, Integer> sortedHashMap = new LinkedHashMap<Character, Integer>();
		for (Iterator<Entry<Character, Integer>> it = list.iterator(); it
				.hasNext();) {
			Map.Entry<Character, Integer> entry = (Map.Entry<Character, Integer>) it
					.next();
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		return sortedHashMap;
	}

}
