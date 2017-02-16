package com.core.java.threads;

class PrintDemo {
	public void printCount() {
		try {
			for (int i = 500; i > 0; i--) {
				System.out.println("Counter   ---   " + i);
			}
		} catch (Exception e) {
			System.out.println("Thread  interrupted.");
		}
	}

}

class ThreadDemo extends Thread {
	private Thread t;
	private String threadName;
	PrintDemo PD;

	ThreadDemo(String name, PrintDemo pd) {
		threadName = name;
		PD = pd;
	}

	public void run() {
		synchronized (PD) {
			PD.printCount();
		}
		System.out.println("Thread " + threadName + " exiting.");
	}

	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

}

public class TestThreadExample1 {
	public static void main(String args[]) throws InterruptedException {

		PrintDemo PD1 = new PrintDemo();
		PrintDemo PD2 = new PrintDemo();

		ThreadDemo T1 = new ThreadDemo("Thread - 1 ", PD1);
		ThreadDemo T2 = new ThreadDemo("Thread - 2 ", PD1);
		T1.start();
		T2.start();
		Thread.sleep(5000);
		ThreadDemo T3 = new ThreadDemo("Thread - 3 ", PD2);
		ThreadDemo T4 = new ThreadDemo("Thread - 4 ", PD2);
		T3.start();
		T4.start();
	}
}
