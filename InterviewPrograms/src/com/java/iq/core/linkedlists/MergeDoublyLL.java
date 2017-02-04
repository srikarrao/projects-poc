package com.java.iq.core.linkedlists;

/**
 * Java program to implement merge sort in doubly linked list
 * 
 * @author SrikarRao
 *
 */

public class MergeDoublyLL {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.head = new Node(10);
		list.head.next = new Node(30);
		list.head.next.next = new Node(3);
		list.head.next.next.next = new Node(4);
		list.head.next.next.next.next = new Node(20);
		list.head.next.next.next.next.next = new Node(5);

		Node node = null;
		node = list.mergeSort(list.head);
		System.out.println("Linked list after sorting :");
		list.print(node);

	}
}

class Node {

	int data;
	Node next, prev;

	Node(int d) {
		data = d;
		next = prev = null;
	}
}

class LinkedList {

	public Node head;

	void print(Node node) {
		Node temp = node;
		System.out.println("Forward Traversal using next pointer");
		while (node != null) {
			System.out.print(node.data + " ");
			temp = node;
			node = node.next;
		}
		System.out.println("\nBackward Traversal using prev pointer");
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.prev;
		}
	}

	/**
	 * Split a doubly linked list (DLL) into 2 DLLs of half sizes
	 * 
	 * @param head
	 * @return
	 */
	Node split(Node head) {
		Node fast = head, slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		Node temp = slow.next;
		slow.next = null;
		return temp;
	}

	Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
		Node second = split(node);

		// Recur for left and right halves
		node = mergeSort(node);
		second = mergeSort(second);

		// Merge the two sorted halves
		return merge(node, second);
	}

	// Function to merge two linked lists
	Node merge(Node first, Node second) {
		// If first linked list is empty
		if (first == null) {
			return second;
		}

		// If second linked list is empty
		if (second == null) {
			return first;
		}

		// Pick the smaller value
		if (first.data < second.data) {
			first.next = merge(first.next, second);
			first.next.prev = first;
			first.prev = null;
			return first;
		} else {
			second.next = merge(first, second.next);
			second.next.prev = second;
			second.prev = null;
			return second;
		}
	}

}
