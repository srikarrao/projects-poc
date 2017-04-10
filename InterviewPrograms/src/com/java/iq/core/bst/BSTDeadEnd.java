package com.java.iq.core.bst;

/**
Source: http://www.geeksforgeeks.org/check-whether-bst-contains-dead-end-not/ <br>
Time: O(n)
Space: O(1)
**/

public class BSTDeadEnd {

	static class Node {
		int data;
		Node left, right;
	};

	public static void main(String[] args) {

		BSTDeadEnd de = new BSTDeadEnd();
		Node root = null;
		root = de.insert(root, 8);
		root = de.insert(root, 5);
		root = de.insert(root, 2);
		// root = de.insert(root, 3);
		root = de.insert(root, 7);
		root = de.insert(root, 11);
		// root = de.insert(root, 4);
		if (de.isDeadEnd(null, root) == true)
			System.out.println("Yes");
		else
			System.out.println("No");
	}

	boolean isDeadEnd(Node parent, Node curr) {
		if (curr == null) {
			return false;
		}

		if (curr.left == null && curr.right == null) {
			if (parent != null && Math.abs(parent.data - curr.data) == 1) {
				return true;
			}
		} else {
			return isDeadEnd(curr, curr.left) || isDeadEnd(curr, curr.right);
		}

		return false;
	}

	Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = temp.right = null;
		return temp;
	}

	Node insert(Node node, int key) {
		if (node == null)
			return newNode(key);
		if (key < node.data)
			node.left = insert(node.left, key);
		else if (key > node.data)
			node.right = insert(node.right, key);
		return node;
	}
}