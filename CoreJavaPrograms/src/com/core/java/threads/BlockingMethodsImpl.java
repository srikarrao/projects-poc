package com.core.java.threads;

import java.util.ArrayList;
import java.util.List;

public class BlockingMethodsImpl {

	List<String> list = new ArrayList<String>();

	// Wait for the list to have an item and return it
	public String getFromList() throws InterruptedException {
		synchronized (list) {
			// Do this inside a while loop -- wait() is
			// not guaranteed to only return if the condition
			// is satisfied -- it can return any time
			while (list.isEmpty()) {
				// Wait until list.notify() is called
				// Note: The lock will be released until
				// this call returns.
				list.wait();
			}
			return list.remove(0);
		}
	}

	// Add an object to the list and wake up
	// anyone waiting
	public void addToList(String item) {
		synchronized (list) {
			list.add(item);
			// Wake up anything blocking on list.wait()
			// Note that we know that only one waiting
			// call can complete (since we only added one
			// item to process. If we wanted to wake them
			// all up, we'd use list.notifyAll()
			list.notify();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		BlockingMethodsImpl bim = new BlockingMethodsImpl();
		BlockingMethodsImpl bim1 = new BlockingMethodsImpl();
		System.out.println(bim.getFromList());
		bim1.addToList("Hello");
		System.out.println(bim.getFromList());
	}
}
