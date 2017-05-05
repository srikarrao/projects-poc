package com.java.iq.core.bst;
/**
 * Source:
 * http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is
 * -also-a-bst/ <br>
 * Time Complexity: O(n) <br>
 * 
 * @author srikarrao.gandla
 *
 */
public class LargestBSTSubtree {

	private static class Node {

		int data;
		Node left, right;

		Node(int d) {
			data = d;
		}
	}

	private static class Value {
		int size;
		boolean isBST;
		int min;
		int max;

		Value(int size, boolean isBST, int min, int max) {
			this.size = size;
			this.isBST = isBST;
			this.min = min;
			this.max = max;
		}
	}

	private Value largestBST(Node node) {

		if (node == null) {
			return new Value(0, true, Integer.MAX_VALUE, Integer.MIN_VALUE);
		}

		Value leftVal = largestBST(node.left);
		Value rightVal = largestBST(node.right);

		int min = node.data;
		int max = node.data;
		int maxSize = 0;

		if (verifyFormsBST(leftVal, rightVal, node)) {
			min = Math.min(leftVal.min, node.data);
			max = Math.max(rightVal.max, node.data);
			maxSize = Math.max(maxSize, 1 + leftVal.size + rightVal.size);
			return new Value(maxSize, true, min, max);
		}

		maxSize = Math.max(maxSize, Math.max(leftVal.size, rightVal.size));
		return new Value(maxSize, false, min, max);
	}

	private boolean verifyFormsBST(Value left, Value right, Node parent) {

		if (left.isBST && right.isBST && left.max < parent.data
				&& right.min > parent.data) {
			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		LargestBSTSubtree largestSubTree = new LargestBSTSubtree();

		Node root = new Node(50);
		root.left = new Node(10);
		root.right = new Node(60);
		root.left.left = new Node(5);
		root.left.right = new Node(20);
		root.right.left = new Node(55);
		root.right.left.left = new Node(45);
		root.right.right = new Node(70);
		root.right.right.left = new Node(65);
		root.right.right.right = new Node(80);

		int res = largestSubTree.largestBST(root).size;
		System.out.println("Size of largest BST is " + res);
	}
}
