package com.java.iq.core.linkedlists;

/**
 * Java program to insert node at nth position
 * 
 * @author SrikarRao
 *
 */
public class LinkedListsInsertion {

	public static class Node {
		public int data;
		public Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	/**
	 * method to place the node at nth position
	 * 
	 * @param head
	 * @param data
	 * @param position
	 * @return
	 */
	public static Node insertAtNthPosition(Node head, int data, int position) {
		Node n1 = new Node(data);
		if (head == null || position == 0) {
			n1.data = data;
			n1.next = head;
			head = n1;
			return head;
		}

		Node curr = null;
		Node temp = head;

		int i = 0;
		while (i++ < position) {
			curr = temp;
			temp = temp.next;
		}

		n1.data = data;
		n1.next = temp;
		curr.next = n1;

		return head;
	}
}