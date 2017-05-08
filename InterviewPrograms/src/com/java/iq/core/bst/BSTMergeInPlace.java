package com.java.iq.core.bst;

import java.util.Stack;

/**
Source: http://www.geeksforgeeks.org/merge-two-bsts-with-limited-extra-space/ <br>
**/
public class BSTMergeInPlace {

	private static Node root1 = null;
	private static Node root2 = null;

	static class Node {
		int data;
		Node left;
		Node right;
	}

	private Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;
	}

	private void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}
	}

	public static void main(String[] args) {
		BSTMergeInPlace bstMerge = new BSTMergeInPlace();

		root1 = bstMerge.newNode(3);
		root1.left = bstMerge.newNode(1);
		root1.right = bstMerge.newNode(5);

		root2 = bstMerge.newNode(4);
		root2.left = bstMerge.newNode(2);
		root2.right = bstMerge.newNode(6);

		System.out.println("Printing root-1 ....");
		bstMerge.inorder(root1);
		System.out.println();

		System.out.println("Printing root-2 ....");
		bstMerge.inorder(root2);
		System.out.println();

		System.out.println("Printing merge of root1 & root-2 ....");
		bstMerge.merge(root1, root2);
	}

	void merge(Node root1, Node root2) {
		Node current1 = root1;
		Node current2 = root2;

		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();

		if (root1 == null) {
			inorder(root2);
			return;
		}

		if (root2 == null) {
			inorder(root1);
			return;
		}

		while (current1 != null || !(s1.isEmpty()) || current2 != null
				|| !(s2.isEmpty())) {
			if (current1 != null || current2 != null) {
				if (current1 != null) {
					s1.push(current1);
					current1 = current1.left;
				}
				if (current2 != null) {
					s2.push(current2);
					current2 = current2.left;
				}

			} else {
				if (s1.isEmpty()) {
					while (!s2.isEmpty()) {
						current2 = s2.pop();
						current2.left = null;
						inorder(current2);
					}
					return;
				}
				if (s2.isEmpty()) {
					while (!s1.isEmpty()) {
						current1 = s1.pop();
						current1.left = null;
						inorder(current1);
					}
					return;
				}

				current1 = s1.pop();
				current2 = s2.pop();
				if (current1.data < current2.data) {
					System.out.print(current1.data + " ");
					current1 = current1.right;
					s2.push(current2);
					current2 = null;
				} else {
					System.out.print(current2.data + " ");
					current2 = current2.right;
					s1.push(current1);
					current1 = null;
				}
			}
		}

	}
}
