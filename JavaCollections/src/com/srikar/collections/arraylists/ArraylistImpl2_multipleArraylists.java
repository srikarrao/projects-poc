package com.srikar.collections.arraylists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author SrikarRao 
 * Java program for arrayLists using multiple arrayLists
 * Displays no. of rows of "x" for the input given 
 */
public class ArraylistImpl2_multipleArraylists {

	public static void main(String args[]) {

		List<ArrayList<String>> arraylist_Out = new ArrayList<ArrayList<String>>();
		
		//pass input through keyboard
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int myInput = keyboard.nextInt();
		/**
		 * for loop to insert "x" into the arraylists
		 */
		for (int k = 0; k < myInput; k++) {
			ArrayList<String> arraylist_In = new ArrayList<String>();
			for (int m = 0; m < k + 1; m++) {
				arraylist_In.add("x");
			}
			arraylist_Out.add(k,arraylist_In);
		}

		/**
		 * for loop to print the "x" from ararylists
		 */
		for (int z = 0; z < myInput; z++) {
			for (int m = 0; m < z + 1; m++) {
				System.out.print(arraylist_Out.get(z).get(m) + " ");
			}
			System.out.println();
		}
	}

}
