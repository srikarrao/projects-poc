package com.javapuzzles.solutions;

public class Abc {

	public static void main(String[] args) {

		String letters = "ABC";
		char[] numbers = null ;
		//= { '1', '2', '3' };
		
		System.out.println(numbers); // 123
		System.out.println(letters + " easy as " + numbers); // ABC easy as [C@20eb607d
		
		System.out.println(letters + " easy as " + String.valueOf(numbers)); // ABC easy as 123
	}

}
