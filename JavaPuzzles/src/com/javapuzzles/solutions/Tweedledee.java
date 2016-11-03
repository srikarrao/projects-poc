package com.javapuzzles.solutions;

/**
 * This example may not be true or invalid
 * 
 * @author SrikarRao
 *
 */
public class Tweedledee {

	public static void main(String[] args) {

		Object x = "Example ";
		String i = "HelloWorld";

		Object x1 = "Example1 ";
		String i1 = "HelloWorld1";

		x = x + i;
		System.out.println(x);

		x1 += i1;
		System.out.println(x1);
	}
}
