package com.core.java.programs;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

class NameStore implements Serializable {
	private static final long serialVersionUID = 156854555L;
	private String firstName;
	private transient String middleName;
	private String lastName;
	private Date date;

	public NameStore(String fName, String mName, String lName, Date date) {
		this.firstName = fName;
		this.middleName = mName;
		this.lastName = lName;
		this.date = date;
		System.out.println("Date before: " + this.date);
	}

	public String toString() {
		StringBuffer sb = new StringBuffer(40);
		/*
		 * sb.append("First Name : "); sb.append(this.firstName);
		 * sb.append(" Middle Name : "); sb.append(this.middleName);
		 * sb.append(" Last Name : "); sb.append(this.lastName);
		 */sb.append("Date after: ");
		sb.append(this.date);
		return sb.toString();
	}
}

public class TransientExample {
	public static void main(String args[]) throws Exception {
		/*NameStore nameStore = new NameStore("Steve", "Middle", "Jobs",
				new Date());
		ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(
				"transientExample"));
		// writing to object
		o.writeObject(nameStore);
		o.close();*/

		// reading from object
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"transientExample"));
		NameStore nameStore1 = (NameStore) in.readObject();
		System.out.println(nameStore1);
	}
}