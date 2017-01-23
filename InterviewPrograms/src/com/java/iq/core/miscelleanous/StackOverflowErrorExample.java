package com.java.iq.core.miscelleanous;

public class StackOverflowErrorExample {

	public static void recursivePrint(int num) throws InterruptedException {
		try {
			System.out.println("Number: " + num);

			if (num == 0)
				return;
			else
				recursivePrint(++num);
		} catch (Exception e) {
			System.out.println("error: " + e);
			System.exit(0);
		}
	}

	public static void main(String[] args) throws InterruptedException {
		try {
			StackOverflowErrorExample.recursivePrint(1);
		} catch (Exception e) {
			System.out.println("error-main: " + e);
			Thread.sleep(10000);
		}
	}
}