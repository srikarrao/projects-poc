package com.designpatterns.creational.singleton;

class SingletonSuper implements Cloneable {
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}

class Singleton extends SingletonSuper {
	// 1. Make all constructors private
	private Singleton() {
	}

	// 2. Declare a private static variable to hold single instance of class
	private static Singleton INSTANCE = new Singleton();

	// 3. Declare a public static function that returns the single instance of
	// class
	public static Singleton getInstance() {
		return INSTANCE;
	}

	public Object clone() throws CloneNotSupportedException {
		// throw CloneNotSupportedException if someone tries to clone the
		// singleton object
		throw new CloneNotSupportedException();
	}

}

public class CloningSingleton {
	public static void main(String[] args) throws Exception {
		System.out.println("Singleton Test!");
		System.out.println("Singleton Instance: " + Singleton.getInstance());
		System.out.println("Singleton clone: "
				+ Singleton.getInstance().clone());
	}
}