package com.java.iq.core.linkedlists;

/**
 * Java program to convert binary tree to double linked list
 * 
 * @author SrikarRao
 *
 */
public class BSTToDLL {

	static class Node {
		int data;
		Node prev, next;

		Node(int item) {
			data = item;
			prev = next = null;
		}
	}

	static class BinaryTree {
		Node root;

		Node bintree2listUtil(Node node) {
			if (node == null)
				return node;

			if (node.prev != null) {
				Node prev = bintree2listUtil(node.prev);

				while (prev.next != null) {
					prev = prev.next;
				}

				prev.next = node;
				node.prev = prev;
			}

			if (node.next != null) {
				Node next = bintree2listUtil(node.next);

				while (next.prev != null) {
					next = next.prev;
				}

				next.prev = node;
				node.next = next;
			}
			return node;
		}

		Node bintree2list(Node node) {
			if (node == null)
				return node;
			node = bintree2listUtil(node);

			while (node.prev != null)
				node = node.prev;
			return node;
		}

		void printList(Node node) {
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
		}

	}

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.prev = new Node(12);
		tree.root.next = new Node(15);
		tree.root.prev.prev = new Node(25);
		tree.root.prev.next = new Node(30);
		tree.root.next.prev = new Node(36);

		Node head = tree.bintree2list(tree.root);
		tree.printList(head);
	}
}
