package com.javapuzzles.solutions;

public class DosEquis {

	/**
	 * Avoiding mix type computation
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		char x = 'X';
		final int i = 0; // gives expected answers

		System.out.println(true ? x : 0); // X // second operand (char, short,
											// byte type) and third operand a
											// constant of int type then type is
											// of second operand
		System.out.println(false ? i : x); // 88 // type promotion for second operand type
	}
}
