package com.java.iq.core.companies.bloomberg;

import java.util.*;

public class BlockingQueueImpl {

	private List<String> queue = new LinkedList<String>();
	private int limit = 10;

	public BlockingQueueImpl(int limit) {
		this.limit = limit;
	}

	public boolean isEmpty() {
		return queue.size() == 0;
	}

	public int size() {
		return queue.size();
	}

	public synchronized void enqueue(String item) throws InterruptedException {
		while (this.queue.size() == this.limit) {
			wait();
		}
		if (this.queue.size() == 0) {
			notifyAll();
		}
		this.queue.add(item);
	}

	public synchronized String dequeue() throws InterruptedException {
		while (this.queue.size() == 0) {
			wait();
		}
		if (this.queue.size() == this.limit) {
			notifyAll();
		}

		return this.queue.remove(0);
	}
}