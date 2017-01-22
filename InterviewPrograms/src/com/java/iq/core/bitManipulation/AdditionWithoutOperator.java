package com.java.iq.core.bitManipulation;

/**
 * JAVA program to perform addition without '+' operator
 * 
 * @author SrikarRao
 *
 */
public class AdditionWithoutOperator {

	public static void main(String[] args) {

		System.out.println(addIterative(2, 2));
		System.out.println(addIterative(19999, 14429));
		System.out.println(addIterative(0, 2));
		System.out.println(addIterative(-1, -5));
	}

	public static int addIterative(int a, int b) {
		while (b != 0) {
			int carry = (a & b); // CARRY is AND of two bits
			a = a ^ b; // SUM of two bits is A XOR B
			b = carry << 1; // shifts carry to 1 bit to calculate sum
		}
		return a;
	}
}