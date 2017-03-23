package com.java.iq.core.graphs;

import java.util.*;

/**
 * Source: http://www.geeksforgeeks.org/sum-dependencies-graph/ <br>
 * Space Complexity: O (E) <br>
 * Time Complexity: O (V)
 * 
 * @author srikarrao.gandla
 *
 */

public class DepenedencyCountDirected {

	public static void main(String[] args) {
		int V = 4;
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 2);
		addEdge(adj, 0, 3);
		addEdge(adj, 1, 3);
		addEdge(adj, 2, 3);

		System.out.println("Sum of dependencies is " + findSum(adj, V));
	}

	private static int findSum(List<List<Integer>> adj, int V) {
		int sum = 0;

		for (int u = 0; u < V; u++)
			sum += adj.get(u).size();

		return sum;
	}

	private static void addEdge(List<List<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
	}
}
