package com.java.iq.core.bst;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Source: http://www.geeksforgeeks.org/in-place-convert-bst-into-a-min-heap/ <br>
 * 
 * @author srikarrao.gandla
 *
 */
public class BSTToHeap {

	private static Node root;
	private static Node head_ref;

	static class Node {
		int data;
		Node left, right;
	}

	static Node newNode(int data) {
		Node node = new Node();
		node.data = data;
		node.left = node.right = null;
		return node;
	}

	public static void main(String[] args) {

		root = newNode(8);
		root.left = newNode(4);
		root.right = newNode(12);
		root.right.left = newNode(10);
		root.right.right = newNode(14);
		root.left.left = newNode(2);
		root.left.right = newNode(6);

		BSTToMinHeap();
		printLevelOrder();
	}

	private static void printLevelOrder() {
		if (root == null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);

		while (!q.isEmpty()) {
			int nodeCount = q.size();
			while (nodeCount > 0) {
				Node node = q.remove();
				System.out.print(node.data + " ");
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}

	private static void BSTToMinHeap() {
		BSTToSortedLL(root);
		root = null;
		SortedLLToMinHeap();
	}

	private static void SortedLLToMinHeap() {

		Node head = head_ref;
		if (head == null)
			return;

		Queue<Node> q = new LinkedList<Node>();
		root = head;
		head = head.right;
		root.right = null;

		q.add(root);
		while (head != null) {
			Node parent = q.remove();
			Node leftChild = head;
			head = head.right;
			leftChild.right = null;
			q.add(leftChild);

			parent.left = leftChild;
			if (head != null) {
				Node rightChild = head;
				head = head.right;
				rightChild.right = null;
				q.add(rightChild);

				parent.right = rightChild;
			}
		}
	}

	private static void BSTToSortedLL(Node root) {
		if (root == null)
			return;

		BSTToSortedLL(root.right);

		root.right = head_ref;

		if (head_ref != null)
			(head_ref).left = null;
		head_ref = root;

		BSTToSortedLL(root.left);
	}

}
