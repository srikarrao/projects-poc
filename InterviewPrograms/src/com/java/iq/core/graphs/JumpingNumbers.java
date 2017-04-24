package com.java.iq.core.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * <p>
 * Source:
 * http://www.geeksforgeeks.org/print-all-jumping-numbers-smaller-than-or-equal-to-a-given-value/
 * <br>
 * 
 * Time Complexity: O (K) <br>
 * Space Complexity: O (K) <br>
 * 
 * </p>
 * 
 * @author srikarrao.gandla
 *
 */
public class JumpingNumbers {

	private static void bfs(int target, int num) {
		Queue<Integer> jumpNumbers = new LinkedList<Integer>();
		jumpNumbers.add(num);

		while (!jumpNumbers.isEmpty()) {
			num = jumpNumbers.remove();

			if (num <= target) {
				System.out.print(num + " ");
				int last_dig = num % 10;

				// If last digit is 0, append next digit only
				if (last_dig == 0)
					jumpNumbers.add((num * 10) + (last_dig + 1));
				// If last digit is 9, append previous digit only
				else if (last_dig == 9)
					jumpNumbers.add((num * 10) + (last_dig - 1));
				// If last digit is neither 0 nor 9, append both
				// previous and next digits
				else {
					jumpNumbers.add((num * 10) + (last_dig - 1));
					jumpNumbers.add((num * 10) + (last_dig + 1));
				}
			}
		}
	}

	private static void printJumping(int target) {
		System.out.print(0 + " ");
		for (int i = 1; i <= 9 && i <= target; i++)
			bfs(target, i);
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the tagert number");
		int target = scn.nextInt();
		printJumping(target);
	}
}