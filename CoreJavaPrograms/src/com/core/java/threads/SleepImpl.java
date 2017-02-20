package com.core.java.threads;

public class SleepImpl extends Thread {
	Integer val1 = 0;

	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				synchronized (this) {
				Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			val1 = val1 + i;
			System.out.println(val1);
		}
	}

	public static void main(String args[]) throws InterruptedException {
		SleepImpl s1 = new SleepImpl();
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s1);

		t1.start();
		t2.start();
		Thread.sleep(1000);
	}
}