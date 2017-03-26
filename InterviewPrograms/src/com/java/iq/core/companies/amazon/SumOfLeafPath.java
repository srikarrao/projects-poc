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

	static class MinMax {
		private int min;
		private int max;
		private Node node;

		public MinMax(int min, int max, Node node) {
			this.min = min;
			this.max = max;
			this.node = node;
		}
	}

	static class BinaryTree {
		Node root;
		MaxMin maxMin = new MaxMin();
		Node target_min_leaf = null;
		Node target_max_leaf = null;

		private boolean printPath(Node node, Node target_leaf) {
			if (node == null)
				return false;

			if (node == target_leaf || printPath(node.left, target_leaf)
					|| printPath(node.right, target_leaf)) {
				System.out.print(node.data + " ");
				return true;
			}
			return false;
		}

		private void getMaxTargetLeaf(Node node, MaxMin max_sum_ref,
				int curr_sum) {
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

		private void getMinTargetLeaf(Node node, MaxMin sum_ref, int curr_sum) {
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

		private MaxMin sumPath() {
			if (root == null)
				return maxMin;

			getMaxTargetLeaf(root, maxMin, 0);
			getMinTargetLeaf(root, maxMin, 0);

			printPath(root, target_min_leaf);
			System.out.println();
			printPath(root, target_max_leaf);
			return maxMin;
		}

		/**
		 * Optimized Result
		 * 
		 * @param tree
		 * @return
		 */
		private MinMax findMinMax(Node tree) {
			if (tree == null) {
				return new MinMax(0, 0, null);
			}

			MinMax left = findMinMax(tree.left);
			MinMax right = findMinMax(tree.right);
			MinMax res = new MinMax(Math.min(left.min + tree.data, right.min
					+ tree.data), Math.max(left.max + tree.data, right.max
					+ tree.data), tree);

			return res;
		}
	}

	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(-100);
		tree.root.left = new Node(102);
		tree.root.right = new Node(17);
		tree.root.left.left = new Node(-18);
		tree.root.left.right = new Node(664);
		System.out.println("Following are the nodes " + "on max-min sum path");
		MinMax res = tree.findMinMax(tree.root);
		System.out.println(res.max + "::" + res.min);
		System.out.println("");
		MaxMin maxMin = tree.sumPath();
		System.out.println("Max Sum of nodes is : " + maxMin.max_no);
		System.out.println("Min Sum of nodes is : " + maxMin.min_no);
	}
}