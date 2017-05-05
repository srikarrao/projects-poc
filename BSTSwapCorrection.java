package com.java.iq.core.bst;

/**
 * Source: http://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/ <br>
 * Time Complexity: O (N)
 * 
 * @author srikarrao.gandla
 *
 */
public class BSTSwapCorrection {

	private static Node root = null;
	private static PositionHolder holder = new PositionHolder();

	static class PositionHolder {
		Node prev = null;
		Node first = null;
		Node middle = null;
		Node last = null;
	}

	static class Node {
		int data;
		Node left, right;
	}

	private Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		return node;
	}

	private void printInorder(Node node) {
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.data + " ");
			printInorder(node.right);
		}
	}

	public static void main(String[] args) {
		BSTSwapCorrection swapping = new BSTSwapCorrection();
		root = swapping.newNode(6);
		root.left = swapping.newNode(10);
		root.right = swapping.newNode(2);
		root.left.left = swapping.newNode(1);
		root.left.right = swapping.newNode(3);
		root.right.right = swapping.newNode(12);
		root.right.left = swapping.newNode(7);

		System.out.println("Inorder Traversal of the original tree \n");
		swapping.printInorder(root);

		swapping.correctBST(root, holder);

		System.out.println("\nInorder Traversal of the fixed tree \n");
		swapping.printInorder(root);
	}

	private void swap(Node a, Node b) {
		int t = a.data;
		a.data = b.data;
		b.data = t;
	}

	private void correctBSTUtil(Node root, PositionHolder holder) {
		if (root != null) {
			correctBSTUtil(root.left, holder);
			if (holder.prev != null && root.data < (holder.prev).data) {
				if (holder.first == null) {
					holder.first = holder.prev;
					holder.middle = root;
				} else {
					holder.last = root;
				}
			}

			holder.prev = root;

			correctBSTUtil(root.right, holder);
		}
	}

	private void correctBST(Node root, PositionHolder holder) {
		correctBSTUtil(root, holder);

		if (holder.first != null && holder.last != null) {
			swap(holder.first, holder.last);
		} else if (holder.first != null && holder.middle != null) {
			swap(holder.first, holder.middle);
		}
	}
}
