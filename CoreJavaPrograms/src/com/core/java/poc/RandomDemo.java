package com.core.java.poc;

import java.util.*;

public class RandomDemo {

	public static void main(String args[]) {
		Random random1 = new Random(441287210);
		for (int i = 0; i < 10; i++) {
			System.out.print(random1.nextInt(10) + " ");
		}

		System.out.println();
		Random random2 = new Random(-6732303926L);
		for (int i = 0; i < 10; i++) {
			System.out.print(random2.nextInt(10) + " ");
		}
		System.out.println();

		int first, second;
		for (first = 0; first <= 1; ++first) {
			for (second = 0; second < 1; ++second) {
				System.out.print(1 * first + second + " ");
			}
		}
	}
}