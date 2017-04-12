package com.java.iq.core.bst;

/**
 * Source: http://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/ <br>
 * 
 * @author SrikarRao
 *
 */
public class SwapCorrection {

	static class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
		}
	}

	public void correctSwapBST(Node node, Node prev, Node next) {
	}

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(10);
		root.right = new Node(2);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(12);
		root.right.left = new Node(7);

		System.out.println("Inorder Traversal of the original tree \n");
		printInorder(root);
		System.out.println();
		SwapCorrection swap = new SwapCorrection();
		swap.correctSwapBST(root, null, null);

		System.out.println("\nInorder Traversal of the fixed tree \n");
		printInorder(root);
	}

	private static void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}
}
