package com.java.iq.core.arrays;

/**
 * Java program to left shift an array by n moves
 * 
 * @author SrikarRao
 *
 */
public class LeftRotation {

	public static void main(String[] args) {
		method1(4);
	}

	public static void method1(int d) {
		int[] input = { 1, 2, 3, 4, 5 };
		int n = input.length;
		int[] array = new int[n];
		d %= n;
		for (int i = 0; i < n; i++) {
			array[(i + n - d) % n] = input[i];
		}
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}
}