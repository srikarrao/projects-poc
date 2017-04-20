package com.java.iq.core.btree;

/**
 * Source:
 * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-
 * a-tree-into-its-mirror-tree/ <br>
 * Java program to convert binary tree into its mirror <br>
 * Space: O (1) <br>
 * Time : O (N)
 * 
 * @author SrikarRao
 *
 */
public class MirrorTree {

	static class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class BinaryTree {
		Node root;

		void mirror() {
			mirror(root);
		}

		void mirror(Node node) {
			if (node != null) {
				swap(node.left);
				swap(node.right);
				swap(node);
			}
		}

		void swap(Node node) {
			if (node != null) {
				Node temp = node.left;
				node.left = node.right;
				node.right = temp;
			}
		}

		void inOrder() {
			inOrder(root);
		}

		/*
		 * Helper function to test mirror(). Given a binary search tree, print
		 * out its data elements in increasing sorted order.
		 */
		void inOrder(Node node) {
			if (node == null)
				return;

			inOrder(node.left);
			System.out.print(node.data + " ");

			inOrder(node.right);
		}

	}

	/* testing for example nodes */
	public static void main(String args[]) {
		/* creating a binary tree and entering the nodes */
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);

		/* print inorder traversal of the input tree */
		System.out.println("Inorder traversal of input tree is :");
		tree.inOrder();
		System.out.println("");

		/* convert tree to its mirror */
		tree.mirror();

		/* print inorder traversal of the minor tree */
		System.out.println("My way traversal of binary tree is : ");
		tree.inOrder();
	}
}
