package com.elevator.impl;

import java.util.Deque;
import java.util.TreeSet;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 
 * @author SrikarRao
 *
 */
public class QueueHandler {
	public static Deque<Requests> readQ = new LinkedBlockingDeque<>();
	public static volatile int currentLiftLevel = 0;
	public static volatile String liftMovingDirection;
	private static volatile TreeSet<Integer> liftStoppages = new TreeSet<Integer>();

	public static void setLiftMovingDirection(String liftMovingDirection) {
		QueueHandler.liftMovingDirection = liftMovingDirection;
	}

	public static void setCurrentLiftLevel(int currentLiftLevel) {
		QueueHandler.currentLiftLevel = currentLiftLevel;
	}

	public static TreeSet<Integer> getLiftStoppages() {
		return liftStoppages;
	}

	public static void addLiftStoppages(int liftStoppages) {
		QueueHandler.liftStoppages.add(liftStoppages);
	}

	public static boolean removeLiftStoppages(int liftStoppages) {
		return QueueHandler.liftStoppages.remove(liftStoppages);
	}

	public static void enqueue(Requests object) {
		readQ.add(object);
	}

	public static void enqueueOnFront(Requests object) {
		readQ.addFirst(object);
	}

	public static Requests dequeue() {
		return readQ.poll();
	}
}