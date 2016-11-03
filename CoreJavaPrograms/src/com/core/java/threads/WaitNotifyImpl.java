package com.core.java.threads;

/**
 * JAVA Program to implement Wait-Notify methods
 * 
 * @author SrikarRao
 *
 */
public class WaitNotifyImpl {
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();

		/**
		 * Synchronized block
		 */
		synchronized (b) {
			try {
				System.out.println("Waiting for b to complete...");
				// waits till the ThreadB execution is completed
				b.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Total is: " + b.total);
		}
	}
}

/**
 * JAVA Class extending Thread class
 * 
 * @author SrikarRao
 *
 */
class ThreadB extends Thread {
	int total;

	/**
	 * overriden method run()
	 */
	@Override
	public void run() {
		/**
		 * Synchronized block for current instance
		 */
		System.out.println("Inside ThreadB");
		synchronized (this) {
			for (int i = 0; i < 100; i++) {
				total += i;
			}

			// notifies the main Thread that execution is complete
			notify();
		}
	}
}