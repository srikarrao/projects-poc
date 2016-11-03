package com.javapuzzles.solutions;

public class SwapMeat {

	public static void main(String[] args) {

		int x = 1984;
		int y = 2001;
		x ^= y ^= x ^= y;
		System.out.println("x: " + x + " y: " + y);
	}
}
