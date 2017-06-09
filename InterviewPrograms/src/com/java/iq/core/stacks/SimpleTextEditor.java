package com.java.iq.core.stacks;

import java.util.*;

/**
 * Source: https://www.hackerrank.com/challenges/simple-text-editor <br>
 * 
 * @author srikarrao
 *
 */
public class SimpleTextEditor {

	public static void main(String[] args) {
		int i, n, type, k;
		LinkedList<String> stack = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < n; i++) {
			type = sc.nextInt();
			if (type == 1) {
				// append
				String str = sc.next();
				sb.append(str);
				stack.offerFirst(Integer.toString(str.length()));
			}
			if (type == 2) {
				// delete
				k = sc.nextInt();
				int len = sb.length();
				stack.offerFirst(sb.substring(len - k, len));
				String sub = sb.substring(0, len - k);
				sb.setLength(0);
				sb.append(sub);
			}

			if (type == 3) {
				// print
				k = sc.nextInt();
				System.out.println(sb.charAt(k - 1));
			}

			if (type == 4) {
				// undo
				String top = stack.pollFirst();
				if (top.charAt(0) >= 97 && top.charAt(0) <= 122) {
					sb.append(top);
				} else {
					// if not really a string, hence undo addition
					int del = Integer.parseInt(top);
					int len = sb.length();
					String sub = sb.substring(0, len - del);
					sb.setLength(0);
					sb.append(sub);
				}
			}
		}
	}
}