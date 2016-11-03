package com.srikar.collections.hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author SrikarRao 
 * Java program for hashMaps using multiple arrayLists Displays
 *          no. of rows of "x" for the input given
 */
public class HashMapImpl {

	public static void main(String[] args) {
		HashMap<Integer, ArrayList<String>> hmap = new HashMap<Integer, ArrayList<String>>();

		Scanner Input = new Scanner(System.in);
		System.out.println("Enter number of rows");

		// pass input through keyboard
		int myInput = Input.nextInt();


		/**
		 * for loop to insert "x" into the arraylists and into hashMap
		 */
		for (int k = 0; k < myInput; k++) {
			ArrayList<String> arraylist_In = new ArrayList<String>();
			for (int m = 0; m < k + 1; m++) {
				arraylist_In.add("x");
			}
			hmap.put(k, arraylist_In);
		}

		/**
		 * for loop to print the "x" from ararylists and hashMap
		 */
		for (int l = 0; l < myInput; l++) {
			ArrayList<String> array = hmap.get(l);
			for (int m = 0; m <= l; m++) {
				System.out.print(array.get(m) + " ");
			}
			System.out.println(" ");
		}
	}
}
