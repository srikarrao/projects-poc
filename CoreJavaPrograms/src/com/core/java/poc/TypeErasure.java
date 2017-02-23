package com.core.java.poc;

import java.util.ArrayList;

public class TypeErasure {

	public static void main(String[] args) {

		ArrayList<String> al = new ArrayList<String>();
		al.add("abc");
		test(al);
	}

	public static void test(ArrayList<?> al) {
		for (Object e : al) {// no matter what type, it will be Object
			System.out.println(e);
		}
	}
}
