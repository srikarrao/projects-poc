package com.core.java.api.guava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.collect.Ordering;

public class OrderingTester {
	public static void main(String args[]) {
		List<Integer> numbers = new ArrayList<Integer>();

		numbers.add(new Integer(5));
		numbers.add(new Integer(2));
		numbers.add(new Integer(15));
		numbers.add(new Integer(51));
		numbers.add(new Integer(53));
		numbers.add(new Integer(35));
		numbers.add(new Integer(45));
		numbers.add(new Integer(32));
		numbers.add(new Integer(43));
		numbers.add(new Integer(16));

		Ordering ordering = Ordering.natural();
		System.out.println("Input List: ");
		System.out.println(numbers);

		Collections.sort(numbers, ordering);
		System.out.println("Sorted List: ");
		System.out.println(numbers);

		System.out.println("======================");
		System.out.println("List is sorted: " + ordering.isOrdered(numbers));
		System.out.println("Minimum: " + ordering.min(numbers));
		System.out.println("Maximum: " + ordering.max(numbers));

		Collections.sort(numbers, ordering.reverse());
		System.out.println("Reverse: " + numbers);

		numbers.add(null);
		System.out.println("Null added to Sorted List: ");
		System.out.println(numbers);

		Collections.sort(numbers, ordering.nullsFirst());
		System.out.println("Null first Sorted List: ");
		System.out.println(numbers);
		System.out.println("======================");

		List<String> names = new ArrayList<String>();

		names.add("RockFord");
		names.add("Musk");
		names.add("Bill Gates");
		names.add("Bill Joy");
		names.add("Wozniak");
		names.add("David Bradley");
		names.add("Newton");
		names.add("Ford");
		names.add(null);
		names.add("Vint Cerf");
		names.add("Alok nath");

		System.out.println("Another List: ");
		System.out.println(names);

		Collections.sort(names, ordering.nullsFirst().reverse());
		System.out.println("Null first then reverse sorted list: ");
		System.out.println(names);
	}
}