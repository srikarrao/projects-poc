package com.srikar.collections.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetImpl {

	public static void main(String args[]) {
		Set<Integer> set = new HashSet<Integer>();

		for (int i = 0; i < 10; i++)
			set.add(i);
		System.out.println(set);

		Iterator<Integer> iterator = set.iterator();
		while (iterator.hasNext()) {
			Integer element = iterator.next();
			if (element % 2 == 0) {
				iterator.remove();
			}
		}
		System.out.println(set);
	}
}
