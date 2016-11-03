package com.javapuzzles.solutions;

public class EscapeRout {

	public static void main(String[] args) {

		System.out.println("abc".length()); // 3
		/**
		 * "a".length() + "b".length() --> 2
		 **/
		System.out.println("a\u0022.length() + \u0022b".length()); // 2
	}
}
