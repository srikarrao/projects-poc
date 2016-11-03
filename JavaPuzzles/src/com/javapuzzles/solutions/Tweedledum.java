package com.javapuzzles.solutions;

public class Tweedledum {

	/**
	 * narrow primitive conversion by compund assigment operator
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		int i = 123456;
		short x = 0;

		x += i; // narrowing primitive type takes place
		System.out.println(x); 

		/** causes compile time if type explicit type casting not done **/
		//x = x + i; 
	}
}
