package com.javapuzzles.solutions;

public class TheJoyOfHex {

	public static void main(String[] args) {
		long hex1 = 0x100000000L;
		long hex2 = 0xcafebabeL;

		System.out.println(hex1);
		System.out.println(hex2);
		System.out.println(hex1 + hex2);
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));
	}
}
