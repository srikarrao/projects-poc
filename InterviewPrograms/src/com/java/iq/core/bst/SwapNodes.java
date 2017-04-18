package com.java.iq.core.bst;

import java.util.*;

/**
 * Java Program to swap nodes in a binary search tree <br>
 * Space: O (2 ^ K) i.e. K is level <br>
 * Time: O (((2 ^ K) - 1)+ (2 ^ (K-1)))
 * 
 * @author SrikarRao
 *
 */
public class SwapNodes {

	public static void main(String[] args) {
		swappingNodes(createTree3(), 2);
	}

	private static void swappingNodes(Node<Integer> root, int K) {
		System.out.println("Before swapping!!");
		printInorder(root);
		System.out.println();

		Queue<Node<Integer>> Q = new LinkedList<Node<Integer>>();
		Q.add(root);
		int x = 1;
		while (x++ < (Math.pow(2, K) / 2)) {
			Node<Integer> temp = Q.remove();
			if (temp.left != null) {
				Q.add(temp.left);
			}

			if (temp.right != null) {
				Q.add(temp.right);
			}

		}

		while (!Q.isEmpty()) {
			swap(Q.remove());
		}
		printInorder(root);
		System.out.println();
	}

	private static void swap(Node<Integer> node) {
		if (node != null) {
			Node<Integer> temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	private static Node<Integer> createTree() {

		Node<Integer> N6 = new Node<Integer>(7);
		Node<Integer> N5 = new Node<Integer>(6);
		Node<Integer> N4 = new Node<Integer>(5);
		Node<Integer> N3 = new Node<Integer>(4);
		Node<Integer> N2 = new Node<Integer>(3);
		Node<Integer> N1 = new Node<Integer>(2);

		N1.left = N3;
		N1.right = N4;
		N2.left = N5;
		N2.right = N6;

		Node<Integer> root = new Node<Integer>(1);
		root.left = N1;
		root.right = N2;
		return root;
	}

	private static Node<Integer> createTree3() {

		Node<Integer> N14 = new Node<Integer>(15);
		Node<Integer> N13 = new Node<Integer>(14);
		Node<Integer> N12 = new Node<Integer>(13);
		Node<Integer> N11 = new Node<Integer>(12);
		Node<Integer> N10 = new Node<Integer>(11);
		Node<Integer> N9 = new Node<Integer>(10);
		Node<Integer> N8 = new Node<Integer>(9);
		Node<Integer> N7 = new Node<Integer>(8);

		Node<Integer> N6 = new Node<Integer>(7);
		Node<Integer> N5 = new Node<Integer>(6);
		Node<Integer> N4 = new Node<Integer>(5);
		Node<Integer> N3 = new Node<Integer>(4);
		Node<Integer> N2 = new Node<Integer>(3);
		Node<Integer> N1 = new Node<Integer>(2);

		N6.left = N13;
		N6.right = N14;

		N5.left = N11;
		N5.right = N12;

		N4.left = N9;
		N4.right = N10;

		N3.left = N7;
		N3.right = N8;

		N1.left = N3;
		N1.right = N4;
		N2.left = N5;
		N2.right = N6;

		Node<Integer> root = new Node<Integer>(1);
		root.left = N1;
		root.right = N2;
		return root;
	}

	private static Node<Integer> createTree2() {

		Node<Integer> N4 = new Node<Integer>(5);
		Node<Integer> N3 = new Node<Integer>(4);
		Node<Integer> N2 = new Node<Integer>(3);
		Node<Integer> N1 = new Node<Integer>(2);

		N1.left = null;
		N1.right = N3;

		N2.left = null;
		N2.right = N4;

		Node<Integer> root = new Node<Integer>(1);
		root.left = N1;
		root.right = N2;
		return root;
	}

	private static void printInorder(Node<Integer> root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}
}