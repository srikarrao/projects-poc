package com.designpatterns.creational.singleton;

public class SingletonPatternImpl {

	private static volatile SingletonPatternImpl sObject;

	// private constructor
	private SingletonPatternImpl() {
	}

	public static SingletonPatternImpl getInstance() {
		/**
		 * Unsafe when used threads because at 1 a threads satisfies and get
		 * through, and between steps 1 and 2 there may occur another thread
		 * call such that two instances of singleton causing race condition such
		 * that violating the singleton functionality. Instead use double check
		 */
		if (sObject == null) { // 1
			sObject = new SingletonPatternImpl(); // 2
		}
		return sObject;
	}

	public void getWishes() {
		System.out.println("Happy BirthDay!!");
	}

	public static void main(String[] args) {
		SingletonPatternImpl single = SingletonPatternImpl.getInstance();
		single.getWishes();
	}
}
