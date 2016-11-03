package com.core.java.poc;

import java.util.*;

public class RandomDemo {

	public static void main(String args[]) {
		Random randomno = new Random();

		System.out.println("Next int value: " + randomno.nextInt(155));
		System.out.println(Integer.compare(3, 5));
	}
}