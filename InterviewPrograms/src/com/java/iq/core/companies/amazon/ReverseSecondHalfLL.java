package com.java.iq.core.companies.amazon;

/**
 * Java program to reverse the second half of the linked list
 * 
 * @author SrikarRao
 *
 */
public class ReverseSecondHalfLL {

	static LNode head;

	static class LNode {
		int data;
		LNode next;

		LNode() {
			data = 0;
			next = null;
		}

		void reverseHalf() {
			LNode H = new LNode();
			H.next = head;
			LNode fast = H;
			LNode slow = H;

			while (fast != null && fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
			}
			slow.next = reverseLL(slow.next);
		}

		LNode reverseLL(LNode node) {
			LNode curr = node;
			LNode prev = null;

			while (curr != null) {
				LNode temp = curr.next;
				curr.next = prev;
				prev = curr;
				curr = temp;
			}
			return prev;
		}

		void push(int new_data) {
			LNode new_node = new LNode();
			new_node.data = new_data;
			if (head == null) {
				head = new_node;
			} else {
				LNode temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = new_node;
			}
		}

		void printList() {
			LNode node = head;
			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		LNode llist = new LNode();
		llist.push(1);
		llist.push(2);
		llist.push(3);
		llist.push(4);
		llist.push(5);
		llist.push(6);
		llist.push(7);
		llist.printList();
		llist.reverseHalf();
		llist.printList();
	}
}