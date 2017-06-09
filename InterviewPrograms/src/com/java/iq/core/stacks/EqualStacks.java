package com.java.iq.core.stacks;

/**
 * Source: https://www.hackerrank.com/challenges/equal-stacks <br>
 * @author srikarrao
 *
 */
public class EqualStacks {

	public static void main(String[] args) {
		int n1 = 5;
		int n2 = 3;
		int n3 = 4;
		int[] arr = { 3, 2, 1, 1, 1, 4, 3, 2, 1, 1, 4, 1 };
		int[] numberOfCylinders = { n1, n2, n3 };
		int[][] stack = { new int[n1], new int[n2], new int[n3] };
		int[] height = { 0, 0, 0 };
		int x = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < numberOfCylinders[i]; j++) {
				int cylinderHeight = arr[x];
				stack[i][j] = cylinderHeight;
				height[i] += cylinderHeight;
				x++;
			}
		}
		int[] index = { 0, 0, 0 };
		int targetHeight = Math.min(Math.min(height[0], height[1]), height[2]);
		while (height[0] != height[1] || height[1] != height[2]) {
			for (int i = 0; i < 3; i++) {
				if (height[i] > targetHeight) {
					height[i] -= stack[i][index[i]++];
					targetHeight = Math.min(targetHeight, height[i]);
				}
			}
		}
		System.out.println(targetHeight);
	}
}