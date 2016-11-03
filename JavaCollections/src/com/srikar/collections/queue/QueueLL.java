package com.srikar.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLL {

	public static void main(String[] args) {
		Queue<Integer> LL = new LinkedList<Integer>();

		System.out.println(LL.isEmpty());
		LL.add(23);
		LL.add(405);
		LL.add(1);
		LL.add(103);

		System.out.println(LL);
		System.out.println(LL.remove());
		System.out.println(LL);
	}

}
