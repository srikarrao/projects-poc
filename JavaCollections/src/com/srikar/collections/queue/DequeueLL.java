package com.srikar.collections.queue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeueLL {

	public static void main(String[] args) {
		Deque<Integer> FL = new LinkedList<Integer>();

		FL.addFirst(23);
		FL.addFirst(405);
		FL.addFirst(1);
		FL.addFirst(103);
		FL.addFirst(2300);

		System.out.println("First --> " + FL);
		System.out.println(FL.getFirst());
		System.out.println(FL.getFirst());

		Deque<Integer> LF = new LinkedList<Integer>();

		LF.addLast(23);
		LF.addLast(405);
		LF.addLast(1);
		LF.addLast(103);
		LF.addLast(2300);

		System.out.println("Last --> " + LF);
		System.out.println(LF.getLast());
		System.out.println(LF.getLast());

	}

}
