package com.designpatterns.creational.singleton;

public class EagerInitializationSingleton {

	// 1. Make all constructors private
	private EagerInitializationSingleton() {
	}

	// 2. Eagerly declare a private static variable to hold single instance
	// of class
	private static EagerInitializationSingleton INSTANCE = new EagerInitializationSingleton();

	// 3. Declare a public static function that returns the single instance
	// of class
	public static EagerInitializationSingleton getInstance() {
		return INSTANCE;
	}
}
