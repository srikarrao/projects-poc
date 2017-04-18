package com.java.iq.core.btree;

import java.util.*;

/**
 * Java program to return the zigzag level order traversal of its node values in
 * a Binary tree <br>
 * Source: http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/ <br>
 * Space: O(N) <br>
 * Time: O(N)<br>
 * 
 * @author SrikarRao
 *
 */
public class ZigZagBTree {

	private static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();

		if (root == null) {
			return result;
		}

		Stack<TreeNode> currLevel = new Stack<TreeNode>();
		Stack<TreeNode> nextLevel = new Stack<TreeNode>();
		Stack<TreeNode> tmp;

		currLevel.push(root);
		boolean normalOrder = true;

		while (!currLevel.isEmpty()) {
			ArrayList<Integer> currLevelResult = new ArrayList<Integer>();

			while (!currLevel.isEmpty()) {
				TreeNode node = currLevel.pop();
				currLevelResult.add(node.val);

				if (normalOrder) {
					if (node.left != null) {
						nextLevel.push(node.left);
					}
					if (node.right != null) {
						nextLevel.push(node.right);
					}
				} else {
					if (node.right != null) {
						nextLevel.push(node.right);
					}
					if (node.left != null) {
						nextLevel.push(node.left);
					}
				}
			}

			result.add(currLevelResult);
			tmp = currLevel;
			currLevel = nextLevel;
			nextLevel = tmp;
			normalOrder = !normalOrder;
		}
		return result;
	}
}