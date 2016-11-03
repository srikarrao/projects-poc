package com.designpatterns.creational.singleton;

public enum SingletonEnum {

	INSTANCE;
	public void doStuff() {
		System.out.println("Singleton using Enum");
	}

	public static void main(String[] args) {
		SingletonEnum.INSTANCE.doStuff();

	}
}