package com.javapuzzles.solutions;

public class AnimalFarm {

	public static void main(String[] args) {

		final String pig = "length: 10";
		final String dog = "length: " + pig.length();
		final String hen = pig;
		System.out.println("1. Animals are equal: " + pig == dog); // false
		System.out.println("2. Animals are equal: " + (pig == dog)); // 2. Animals are equal: false
		System.out.println("3. Animals are equal: " + (pig == dog.intern())); // 3. Animals are equal: true
		System.out.println("4. Animals are equal: " + (hen == pig)); // 4. Animals are equal: true
		System.out.println("5. Animals are equal: " + (pig.equals(dog))); // 5. Animals are equal: true
	}
}
