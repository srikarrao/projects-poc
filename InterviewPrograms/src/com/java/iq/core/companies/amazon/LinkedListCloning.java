package com.java.iq.core.companies.amazon;

//Java program to clone a linked list with random pointers
import java.util.*;

/**
 * Space: O(n)
 * 
 * Time: O(n)
 * 
 * @author SrikarRao
 *
 */
class LinkedListCloning {
	static class Node {
		int data;
		Node next, random;

		public Node(int data) {
			this.data = data;
			this.next = this.random = null;
		}
	}

	static class LinkedList {
		Node head;

		public LinkedList(Node head) {
			this.head = head;
		}

		public void push(int data) {
			Node node = new Node(data);
			node.next = this.head;
			this.head = node;
		}

		void print() {
			Node temp = head;
			while (temp != null) {
				Node random = temp.random;
				int randomData = (random != null) ? random.data : -1;
				System.out.println("Data = " + temp.data + ", Random data = "
						+ randomData);
				temp = temp.next;
			}
		}

		public LinkedList clone() {
			Node origCurr = this.head, cloneCurr = null;
			Map<Node, Node> map = new HashMap<Node, Node>();

			while (origCurr != null) {
				cloneCurr = new Node(origCurr.data);
				map.put(origCurr, cloneCurr);
				origCurr = origCurr.next;
			}

			origCurr = this.head;
			while (origCurr != null) {
				cloneCurr = map.get(origCurr);
				cloneCurr.next = map.get(origCurr.next);
				cloneCurr.random = map.get(origCurr.random);
				origCurr = origCurr.next;
			}

			return new LinkedList(map.get(this.head));
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList(new Node(5));
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);

		list.head.random = list.head.next.next;
		list.head.next.random = list.head.next.next.next;
		list.head.next.next.random = list.head.next.next.next.next;
		list.head.next.next.next.random = list.head.next.next.next.next.next;
		list.head.next.next.next.next.random = list.head.next;

		LinkedList clone = list.clone();

		System.out.println("Original linked list");
		list.print();
		System.out.println("\nCloned linked list");
		clone.print();
	}
}