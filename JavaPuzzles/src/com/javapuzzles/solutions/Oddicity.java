package com.javapuzzles.solutions;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Program implementing the Oddocity (Odd number check) of Java Puzzlers
 * 
 * @author SrikarRao
 *
 */
public class Oddicity {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Enter an integer: ");
			int myInput = keyboard.nextInt();
			
			boolean result = isOdd(myInput);
			if (result) {
				System.out.println("The number " + myInput + " is Odd");
			} else {
				System.out.println("The number " + myInput + " is Even");
			}
		} catch (InputMismatchException ime) {
			System.out
					.println("Inappropriate Input Type, pass integer as value int of range -2147483648 to 2147483647"
							+ ime);
		}
	}

	/**
	 * This method is implemented to check if the number is Odd
	 * 
	 * @param num
	 * @return true/false
	 */
	public static boolean isOdd(int num) {
		// return num % 2 == 1; // this return false for negative values
		// return num % 2 != 0; // convention appliance of odd check
		return (num & 1) != 0; // unconventional and faster way of checking
	}
}
