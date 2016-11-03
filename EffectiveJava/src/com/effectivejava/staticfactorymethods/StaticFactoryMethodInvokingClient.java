package com.effectivejava.staticfactorymethods;

public class StaticFactoryMethodInvokingClient {

	public static void main(String[] args) {
		int value1 = 90;
		int value2 = 100;
		String type = "add";

		int result1 = StaticFactoryMethodImpl.getSum(value1);
		int result2 = StaticFactoryMethodImpl.getDiff(value2);
		StaticFactoryMethodImpl sfml = new StaticFactoryMethodImpl(value1, type);
		int result3 = sfml.peformCalculation(1000);
		System.out.println("The result of getSum: " + result1);
		System.out.println("The result of getDiff: " + result2);
		System.out.println("The result of performCalculation: " + result3);
	}
}
