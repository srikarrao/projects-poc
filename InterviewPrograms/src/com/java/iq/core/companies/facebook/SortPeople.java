package com.java.iq.core.companies.facebook;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

public class SortPeople {

	public static class Person implements Comparable<Person> {
		private static int idCounter = 1;
		private int personId;
		private Date dateOfBirth;
		private Date dateOfDeath;
		private boolean isAlive;

		public Person(Date dateOfBirth, Date dateOfDeath) {
			this.personId = idCounter++;
			this.dateOfBirth = dateOfBirth;
			this.dateOfDeath = dateOfDeath;
			this.isAlive = (this.dateOfDeath == null || !(this.dateOfDeath.compareTo(this.dateOfBirth) >= 0)) ? true
					: false;
		}

		public int getPersonId() {
			return personId;
		}

		public Date getDateOfBirth() {
			return dateOfBirth;
		}

		public Date getDateOfDeath() {
			return dateOfDeath;
		}

		public boolean isAlive() {
			return isAlive;
		}

		public void setAlive(boolean isAlive) {
			this.isAlive = isAlive;
		}

		@Override
		public int compareTo(Person person) {
			if (this.isAlive && !person.isAlive) {
				return -1;
			} else if (!this.isAlive && person.isAlive) {
				return 1;
			}

			int sorter = this.dateOfBirth.compareTo(person.dateOfBirth);
			if (sorter == 0) {
				sorter = this.dateOfDeath == null ? -1 : this.dateOfDeath.compareTo(person.dateOfDeath);
			}

			if (sorter == 0) {
				sorter = Integer.compare(this.personId, person.personId);
			}
			return sorter;
		}

		public String toString() {
			return "<Person ID: " + personId + ", Date of birth: " + this.dateOfBirth + ", Date of death: "
					+ this.dateOfDeath + ", Is Alive: " + this.isAlive + ">";
		}
	}

	public static void main(String[] args) throws ParseException {
		Assert.assertEquals("test case 1", 2, numberOfPeopleAlive(SortPeopleTest.getTestData1()));
		Assert.assertEquals("test case 2", 5, numberOfPeopleAlive(SortPeopleTest.getTestData2()));
		Assert.assertEquals("test case 3", 5, numberOfPeopleAlive(SortPeopleTest.getTestData3()));
		Assert.assertEquals("test case 4", 0, numberOfPeopleAlive(SortPeopleTest.getTestData4()));
		Assert.assertEquals("test case 5", 0, numberOfPeopleAlive(SortPeopleTest.getTestData5()));
		Assert.assertEquals("test case 6", 1, numberOfPeopleAlive(SortPeopleTest.getTestData6()));
		Assert.assertEquals("test case 7", 0, numberOfPeopleAlive(null));
	}

	private static int numberOfPeopleAlive(List<Person> people) {

		if (people == null || people.isEmpty()) {
			return 0;
		}
		int index = -1;
		int low = 0;
		int high = people.size() - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			Person person = people.get(mid);

			if (person.isAlive()) {
				index = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		return index + 1;
	}
}