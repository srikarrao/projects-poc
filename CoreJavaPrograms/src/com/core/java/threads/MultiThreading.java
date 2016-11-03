package com.core.java.threads;

public class MultiThreading extends Thread {
	
	public void run() {
		System.out.println("thread is running...");
	}

	public static void main(String args[]) {
		MultiThreading t1 = new MultiThreading();
		t1.start();
	}
}
