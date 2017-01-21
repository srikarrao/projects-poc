package com.java.iq.core.companies.amazon;

import java.util.HashMap;
import java.util.Scanner;

/**
 * JAVA Program to find the first non repeated character in a string
 * 
 * @author SrikarRao
 *
 */
public class FirstNonRepeated {

	public static void main(String[] args) {
		System.out.println(" Please enter the input string :");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		char c = firstNonRepeatedCharacter(s);
		System.out.println("The first non repeated character is :  " + c);
	}

	public static Character firstNonRepeatedCharacter(String str) {
		HashMap<Character, Integer> characterhashtable = new HashMap<Character, Integer>();
		int i, length;
		Character c;
		String lowerString = null;
		length = str.length(); // Scan string and build hash table
		for (i = 0; i < length; i++) {
			lowerString = str.toLowerCase();
			c = lowerString.charAt(i);

			if (characterhashtable.containsKey(c)) {
				// increment count corresponding to c
				characterhashtable.put(c, characterhashtable.get(c) + 1);
			} else {
				characterhashtable.put(c, 1);
			}
		}
		// Search characterhashtable in in order of string str

		for (i = 0; i < length; i++) {
			c = lowerString.charAt(i);
			if (characterhashtable.get(c) == 1)
				return c;
		}
		return null;
	}
}