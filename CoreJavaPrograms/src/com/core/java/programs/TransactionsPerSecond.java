package com.core.java.programs;

public class TransactionsPerSecond {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 950000; i++) {

		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

}
