package com.java.iq.core.companies.amazon;

/**
 * Java program to find maximum and minimum sum leaf to root path in Binary Tree
 * 
 * @author SrikarRao
 *
 */
public class SumOfLeafPath {

	static class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	static class MaxMin {
		int max_no = Integer.MIN_VALUE;
		int min_no = Integer.MAX_VALUE;
	}

	static class BinaryTree {
		Node root;
		MaxMin maxMin = new MaxMin();
		Node target_min_leaf = null;
		Node target_max_leaf = null;

		boolean printPath(Node node, Node target_leaf) {
			if (node == null)
				return false;

			if (node == target_leaf || printPath(node.left, target_leaf)
					|| printPath(node.right, target_leaf)) {
				System.out.print(node.data + " ");
				return true;
			}
			return false;
		}

		void getMaxTargetLeaf(Node node, MaxMin max_sum_ref, int curr_sum) {
			if (node == null)
				return;

			curr_sum = curr_sum + node.data;

			if (node.left == null && node.right == null) {
				if (curr_sum > max_sum_ref.max_no) {
					max_sum_ref.max_no = curr_sum;
					target_max_leaf = node;
				}

			}

			getMaxTargetLeaf(node.left, max_sum_ref, curr_sum);
			getMaxTargetLeaf(node.right, max_sum_ref, curr_sum);
		}

		void getMinTargetLeaf(Node node, MaxMin sum_ref, int curr_sum) {
			if (node == null)
				return;

			curr_sum = curr_sum + node.data;

			if (node.left == null && node.right == null) {

				if (curr_sum < sum_ref.min_no) {
					sum_ref.min_no = curr_sum;
					target_min_leaf = node;
				}
			}

			getMinTargetLeaf(node.left, sum_ref, curr_sum);
			getMinTargetLeaf(node.right, sum_ref, curr_sum);
		}

		MaxMin sumPath() {
			if (root == null)
				return maxMin;

			getMaxTargetLeaf(root, maxMin, 0);
			getMinTargetLeaf(root, maxMin, 0);

			printPath(root, target_min_leaf);
			System.out.println();
			printPath(root, target_max_leaf);
			return maxMin;
		}
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(-2);
		tree.root.right = new Node(7);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(-4);
		System.out.println("Following are the nodes " + "on max-min sum path");
		MaxMin maxMin = tree.sumPath();
		System.out.println("");
		System.out.println("Max Sum of nodes is : " + maxMin.max_no);
		System.out.println("Min Sum of nodes is : " + maxMin.min_no);
	}

}
