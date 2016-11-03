package com.core.java.threads;

public class SleepImpl extends Thread {
	Integer val1 = 0;

	public void run() {
		for (int i = 1; i < 5; i++) {
			try {
				synchronized (val1) {
					Thread.sleep(500);
				}
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		SleepImpl t1 = new SleepImpl();
		SleepImpl t2 = new SleepImpl();

		t1.start();
		t2.start();
	}
}