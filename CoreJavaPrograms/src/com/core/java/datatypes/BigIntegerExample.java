package com.core.java.datatypes;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * JAVA program to implement BigInteger
 * 
 * @author SrikarRao
 *
 */
public class BigIntegerExample {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BigInteger bi1, bi2;

		System.out.println("Enter number 1");
		bi1 = new BigInteger(scn.nextLine());

		System.out.println("Enter number 2");
		bi2 = new BigInteger(scn.nextLine());

		System.out.println(bi1.add(bi2));
		System.out.println(bi1.multiply(bi2));
	}
}
