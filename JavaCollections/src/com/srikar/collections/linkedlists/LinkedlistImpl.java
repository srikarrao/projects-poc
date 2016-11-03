package com.srikar.collections.linkedlists;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author SrikarRao 
 * Java program for linkedLists
 * Displays no. of rows of "x" for the input given 
 */
public class LinkedlistImpl {

	public static void main(String[] args) {
		List<LinkedList<String>> linkedlist_Out = new LinkedList<LinkedList<String>>();
		
		//pass input through keyboard
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter an integer: ");
		int myInput = keyboard.nextInt();

		/**
		 * for loop to insert "x" into the linkedLists
		 */
		for (int k = 0; k < myInput; k++) {
			LinkedList<String> linkedlist = new LinkedList<String>();

			for (int m = 0; m < k + 1; m++) {
				linkedlist.add(m,"x");
			}
			linkedlist_Out.add(k, linkedlist);
		}

		/**
		 * for loop to print the "x" from linkedLists
		 */
		for (int z = 0; z < myInput; z++) {
			for (int m = 0; m < z + 1; m++) {
				System.out.print(linkedlist_Out.get(z).get(m) + " ");
			} 
			System.out.println();
		}
	}

}
