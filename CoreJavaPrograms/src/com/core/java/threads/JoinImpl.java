package com.core.java.threads;

public class JoinImpl extends Thread {

	public void run() {
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(500);
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.println(i);
		}
	}

	public static void main(String args[]) {
		JoinImpl t1 = new JoinImpl();
		JoinImpl t2 = new JoinImpl();
		JoinImpl t3 = new JoinImpl();
		t1.start();
		try {
			t1.join();
		} catch (Exception e) {
			System.out.println(e);
		}
		t2.start();
		t3.start();
	}
}