package com.java.iq.core.bst;

/**
 * Source: https://www.hackerrank.com/challenges/tree-huffman-decoding <br>
 * Reference: http://people.cs.pitt.edu/~kirk/cs1501/animations/Huffman.html <br>
 * Time: O (N logn) <br>
 * Space: O(1)
 * 
 * @author SrikarRao
 *
 */
public class HuffmanDecoding {

	public static void decode(String S, Node<String> root) {
		StringBuilder sb = new StringBuilder();
		Node<String> c = root;
		for (int i = 0; i < S.length(); i++) {
			c = S.charAt(i) == '1' ? c.right : c.left;
			if (c.left == null && c.right == null) {
				sb.append(c.data);
				c = root;
			}
		}
		System.out.print(sb);
	}

	public static void main(String[] args) {
		String S = "1001011";
		Node<String> N4 = new Node<String>("C");
		Node<String> N3 = new Node<String>("B");
		Node<String> N2 = new Node<String>("A");
		Node<String> N1 = new Node<String>("");

		N1.left = N3;
		N1.right = N4;

		Node<String> root = new Node<String>("");
		root.left = N1;
		root.right = N2;

		decode(S, root);
	}
}
