package com.elevator.impl;

/**
 * 
 * @author SrikarRao
 *
 */
public class ElevatorSimpleVersion {

	private static Consumer consumer;
	private static Producer producer;

	public static void main(String args[]) {
		consumer = new Consumer();
		producer = new Producer();
	}
}