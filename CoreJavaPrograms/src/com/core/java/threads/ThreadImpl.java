package com.core.java.threads;

public class ThreadImpl extends Thread {

	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		ThreadImpl t1 = new ThreadImpl();
		t1.start();
	}
}
