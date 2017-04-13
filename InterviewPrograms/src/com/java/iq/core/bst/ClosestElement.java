package com.java.iq.core.bst;

/**
 * Source: http://www.geeksforgeeks.org/find-closest-element-binary-search-tree/ <br>
 * Time: O(n) <br>
 * Space: O (1)
 * 
 * @author srikarrao.gandla
 *
 */
public class ClosestElement {

	static class Node {
		int key;
		Node left, right;
	}

	static class MinElement {
		int element;
		int absDiff;

		public MinElement(int element, int absDiff) {
			this.element = element;
			this.absDiff = absDiff;
		}
	}

	Node insertNode(int key) {
		Node node = new Node();
		node.key = key;
		node.left = node.right = null;
		return (node);
	}

	public static void main(String[] args) {
		ClosestElement ce = new ClosestElement();
		Node root = ce.insertNode(9);
		root.left = ce.insertNode(4);
		root.right = ce.insertNode(17);
		root.left.left = ce.insertNode(3);
		root.left.right = ce.insertNode(6);
		root.left.right.left = ce.insertNode(5);
		root.left.right.right = ce.insertNode(7);
		root.right.right = ce.insertNode(22);
		root.right.right.left = ce.insertNode(20);
		System.out.println(ce.findClosestElement(root));
	}

	private int findClosestElement(Node root) {
		if (root == null) {
			return -1;
		}
		int K = 1;
		return findClosetElement(root, K).element;
	}

	private MinElement findClosetElement(Node node, int K) {

		if (node == null) {
			return new MinElement(-1, Integer.MAX_VALUE);
		} else if (node.key == K) {
			return new MinElement(node.key, 0);
		}

		MinElement left = findClosetElement(node.left, K);
		MinElement right = findClosetElement(node.right, K);
		int tempAbsDiff = left.absDiff < right.absDiff ? left.absDiff
				: right.absDiff;

		int finalAbsDiff = Math.min(tempAbsDiff, Math.abs(node.key - K));
		int element = node.key;

		if (finalAbsDiff == tempAbsDiff) {
			if (tempAbsDiff == left.absDiff) {
				element = left.element;
			} else {
				element = right.element;
			}
		}
		return new MinElement(element, finalAbsDiff);
	}
}
