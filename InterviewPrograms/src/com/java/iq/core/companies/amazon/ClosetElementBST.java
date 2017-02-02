package com.java.iq.core.companies.amazon;

/**
 * Find the closest element in Binary Search Tree
 * 
 * @author SrikarRao
 *
 */
public class ClosetElementBST {

	static class TNode {
		int data;
		TNode left, right;

		TNode(int d) {
			data = d;
			left = right = null;
		}
	}

	public static void main(String[] args) {
		TNode N1 = new TNode(9);
		TNode N2 = new TNode(4);
		TNode N3 = new TNode(3);
		TNode N4 = new TNode(6);
		TNode N5 = new TNode(5);
		TNode N6 = new TNode(7);
		TNode N7 = new TNode(17);
		TNode N8 = new TNode(22);
		TNode N9 = new TNode(20);

		N4.left = N5;
		N4.right = N6;
		N2.left = N3;
		N2.right = N6;
		N8.left = N9;
		N7.right = N8;
		N1.left = N2;
		N1.right = N7;
		System.out.println(findClosetElement(N1, 4));
		System.out.println(findClosetElement(N1, 18));
		System.out.println(findClosetElement(N1, 1000));
		System.out.println(findClosetElement(N1, 0));
	}

	private static int findClosetElement(TNode root, int k) {
		return minDiffKey(root, k).data;
	}

	private static TNode minDiffKey(TNode node, int k) {
		TNode temp = node;
		TNode minKey = new TNode(-1);
		int minDiff = Integer.MAX_VALUE;

		while (temp != null) {
			if (temp.data == k) {
				return temp;
			} else {
				int diff = Math.abs(temp.data - k);
				if (diff < minDiff) {
					minDiff = diff;
					minKey = temp;
				}
				temp = (k < temp.data) ? temp.left : temp.right;
			}
		}
		return minKey;
	}
}