package com.java.iq.core.companies.facebook;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.java.iq.core.companies.facebook.SortPeople.Person;

public class SortPeopleTest {
	private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

	// Collection with true & false entries
	public static List<Person> getTestData1() {
		List<Person> sortableArray = new ArrayList<>();
		try {
			Person p1 = new Person(dateFormatter.parse("1950-08-25"), dateFormatter.parse("2000-07-11"));
			Person p2 = new Person(dateFormatter.parse("1963-02-15"), null);
			Person p3 = new Person(dateFormatter.parse("1996-06-12"), dateFormatter.parse("2010-07-01"));
			Person p4 = new Person(dateFormatter.parse("2010-03-25"), dateFormatter.parse("2012-11-11"));
			Person p5 = new Person(dateFormatter.parse("1997-10-25"), dateFormatter.parse("2000-10-01"));
			Person p6 = new Person(dateFormatter.parse("1997-10-25"), dateFormatter.parse("2000-10-01"));
			Person p7 = new Person(dateFormatter.parse("1954-04-18"), null);
			sortableArray.addAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7));
		} catch (ParseException e) {
			System.err.println("Error: " + e);
		}
		Collections.sort(sortableArray);
		return sortableArray;
	}

	// Collection with true & false entries
	public static List<Person> getTestData2() {

		List<Person> sortableArray = new ArrayList<>();
		try {
			Person p1 = new Person(dateFormatter.parse("1950-08-25"), dateFormatter.parse("2000-07-11"));
			Person p2 = new Person(dateFormatter.parse("1963-02-15"), null);
			Person p3 = new Person(dateFormatter.parse("1996-06-12"), dateFormatter.parse("2010-07-01"));
			Person p4 = new Person(dateFormatter.parse("2010-03-25"), dateFormatter.parse("2012-11-11"));
			Person p7 = new Person(dateFormatter.parse("1954-04-18"), null);
			Person p8 = new Person(dateFormatter.parse("1993-02-15"), null);
			Person p9 = new Person(dateFormatter.parse("1943-02-15"), null);
			Person p10 = new Person(dateFormatter.parse("2013-02-15"), null);
			sortableArray.addAll(Arrays.asList(p1, p2, p3, p4, p7, p8, p9, p10));
		} catch (ParseException e) {
			System.err.println("Error: " + e);
		}
		Collections.sort(sortableArray);
		return sortableArray;
	}

	// Collection with only true entries
	public static List<Person> getTestData3() {

		List<Person> sortableArray = new ArrayList<>();
		try {
			Person p2 = new Person(dateFormatter.parse("1963-02-15"), null);
			Person p7 = new Person(dateFormatter.parse("1954-04-18"), null);
			Person p8 = new Person(dateFormatter.parse("1993-02-15"), null);
			Person p9 = new Person(dateFormatter.parse("1943-02-15"), null);
			Person p10 = new Person(dateFormatter.parse("2013-02-15"), null);
			sortableArray.addAll(Arrays.asList(p2, p7, p8, p9, p10));
		} catch (ParseException e) {
			System.err.println("Error: " + e);
		}
		Collections.sort(sortableArray);
		return sortableArray;
	}

	// Collection with only false entries
	public static List<Person> getTestData4() {
		List<Person> sortableArray = new ArrayList<>();
		try {
			Person p1 = new Person(dateFormatter.parse("1950-08-25"), dateFormatter.parse("2000-07-11"));
			Person p3 = new Person(dateFormatter.parse("1996-06-12"), dateFormatter.parse("2010-07-01"));
			Person p4 = new Person(dateFormatter.parse("2010-03-25"), dateFormatter.parse("2012-11-11"));
			Person p5 = new Person(dateFormatter.parse("1997-10-25"), dateFormatter.parse("2000-10-01"));
			Person p6 = new Person(dateFormatter.parse("1997-10-25"), dateFormatter.parse("2000-10-01"));
			sortableArray.addAll(Arrays.asList(p1, p3, p4, p5, p6));
		} catch (ParseException e) {
			System.err.println("Error: " + e);
		}
		Collections.sort(sortableArray);
		return sortableArray;
	}

	// Collection with only one false entry
	public static List<Person> getTestData5() {
		List<Person> sortableArray = new ArrayList<>();
		try {
			Person p6 = new Person(dateFormatter.parse("1997-10-25"), dateFormatter.parse("2000-10-01"));
			sortableArray.addAll(Arrays.asList(p6));
		} catch (ParseException e) {
			System.err.println("Error: " + e);
		}
		Collections.sort(sortableArray);
		return sortableArray;
	}

	// Collection with only one true entry
	public static List<Person> getTestData6() {

		List<Person> sortableArray = new ArrayList<>();
		try {
			Person p2 = new Person(dateFormatter.parse("1963-02-15"), null);
			sortableArray.addAll(Arrays.asList(p2));
		} catch (ParseException e) {
			System.err.println("Error: " + e);
		}
		Collections.sort(sortableArray);
		return sortableArray;
	}
}