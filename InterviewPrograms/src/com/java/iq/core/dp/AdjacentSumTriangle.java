package com.java.iq.core.dp;

import java.util.*;

/**
 * Source: https://leetcode.com/problems/triangle/#/description <br>
 * Time Complexity: O (N ^ 2) <br>
 * Space Complexity: O (N)
 * 
 * @author SrikarRao.Gandla
 *
 */
public class AdjacentSumTriangle {

	public static int minimumTotal(List<List<Integer>> triangle) {
		int[] A = new int[triangle.size() + 1];
		for (int i = triangle.size() - 1; i >= 0; i--) {
			for (int j = 0; j < triangle.get(i).size(); j++) {
				A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
			}
		}
		return A[0];
	}

	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		input.add(new ArrayList<Integer>(Arrays.asList(2)));
		input.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		input.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
		input.add(new ArrayList<Integer>(Arrays.asList(4, 3, 8, 1)));
		System.out.println(minimumTotal(input));
	}
}