package com.effectivejava.generalprogramming;

import java.util.*;
import java.util.Map.*;

/**
 * JAVA program implementing hashcode and equals contract
 * 
 * @author SrikarRao
 *
 */
public class EqualsImpl {

	private static class Person {
		private Integer age;
		private String name;

		public Person(Integer age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public boolean equals(Object o) {
			if (o == null) {
				return false;
			}
			if (!(o instanceof Person)) {
				return false;
			}
			Person person = (Person) o;
			return this.name.equals(person.name) && this.age == person.age;
		}

		@Override
		public int hashCode() {
			return (int) age * name.hashCode();
		}

	}

	public static void main(String[] args) {

		Map<Person, Integer> personMap = new HashMap<Person, Integer>();
		personMap.put(new Person(25, "Srikar"), 1);
		personMap.put(new Person(30, "Ronaldo"), 2);
		personMap.put(new Person(26, "Kohli"), 3);

		Set<Map.Entry<Person, Integer>> entrySet = personMap.entrySet();
		for (Entry entry : entrySet) {
			Person p = (Person) entry.getKey();
			System.out.println("key: (" + p.age + "," + p.name + ")"
					+ "and  value: " + entry.getValue());
		}

		System.out.println(personMap.get(new Person(25, "Srikar")));
		System.out.println(personMap.get(new Person(30, "Ronaldo")));
	}
}
