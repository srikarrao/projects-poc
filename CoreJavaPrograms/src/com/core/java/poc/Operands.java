package com.core.java.poc;

public class Operands {

	public static void main(String[] args) {

		int x = 0;
		int y = 10;
		if ((x > 0 && y > 0) && (x == y)) {
			System.out.println("Are equal");
		} else if (x == -1) {
			System.out.println("X is negative");
		} else if (y == -1) {
			System.out.println("Y is negative");
		}

	}

}
