package com.core.java.threads;

public class RunnableImpl implements Runnable {

	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		RunnableImpl runnable = new RunnableImpl();
		Thread t1 = new Thread(runnable);
		t1.start();
	}
}
