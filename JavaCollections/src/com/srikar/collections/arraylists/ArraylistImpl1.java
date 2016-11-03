package com.srikar.collections.arraylists;

import java.util.ArrayList;

/**
 * @author SrikarRao 
 *  Java program for arrayLists
 */
public class ArraylistImpl1 {

	public static void main(String args[]) {

		ArrayList<String> arraylist_In = new ArrayList<String>();

		/**
		 * looping to assign and display "*" to the arraylist_In
		 */
		for (int i = 1; i < 4; i++) {
			for (int j = 0; j < i; j++) {
				arraylist_In.add("*");
				System.out.print(arraylist_In.get(j) + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		// displays the size of the arraylist_In
		System.out.println(arraylist_In.size());
	}
}
