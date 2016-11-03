package com.srikar.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueImpl {

	public static void main(String[] args) {

		Queue<Integer> queue = new PriorityQueue<Integer>();
		System.out.println(queue.isEmpty());
		queue.add(10);
		queue.add(20);
		queue.add(7);
		queue.add(0);
		System.out.println(queue);

		queue.remove();
		System.out.println(queue);
		queue.remove(10);
		System.out.println(queue);
	}
}
