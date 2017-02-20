package com.core.java.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicOperationImpl {

	public static void main(String[] args) throws InterruptedException {

		ProcessingThread pt = new ProcessingThread();
		Thread t1 = new Thread(pt, "t1");
		t1.start();
		Thread t2 = new Thread(pt, "t2");
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Processing count=" + pt.getCount());

		ProcessingThread2 pt2 = new ProcessingThread2();
		Thread t3 = new Thread(pt2, "t3");
		Thread t4 = new Thread(pt2, "t4");
		t3.start();
		t4.start();
		t3.join();
		t4.join();
		System.out.println("2 Processing count=" + pt2.getCount());

	}

}

class ProcessingThread2 implements Runnable {
	private int count = 0;

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			processSomething(i);
			count++;
		}
	}

	public int getCount() {
		return count;
	}

	private void processSomething(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class ProcessingThread implements Runnable {
	private AtomicInteger count = new AtomicInteger();

	@Override
	public void run() {
		for (int i = 1; i < 5; i++) {
			processSomething(i);
			count.incrementAndGet();
		}
	}

	public int getCount() {
		return this.count.get();
	}

	private void processSomething(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
