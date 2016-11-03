package com.designpatterns.creational.singleton;

public class DoubleCheckLockingSingleton {

	private static DoubleCheckLockingSingleton instance;

	// private constructor
	private DoubleCheckLockingSingleton() {
	}

	public static DoubleCheckLockingSingleton getInstance() {
		if (instance == null) {
			synchronized (DoubleCheckLockingSingleton.class) {
				instance = new DoubleCheckLockingSingleton();
			}
		}
		return instance;
	}
}
