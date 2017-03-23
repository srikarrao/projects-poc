package com.java.iq.core.graphs;

import java.util.*;

/**
 * Source: http://www.geeksforgeeks.org/count-number-edges-undirected-graph/ <br>
 * Time Complexity : O(V) <br>
 * 
 * @author srikarrao.gandla
 *
 */
public class EdgesCount {

	public static void main(String[] args) {
		int V = 9;
		List<List<Integer>> adj = new ArrayList<List<Integer>>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 7);
		addEdge(adj, 1, 2);
		addEdge(adj, 1, 7);
		addEdge(adj, 2, 3);
		addEdge(adj, 2, 8);
		addEdge(adj, 2, 5);
		addEdge(adj, 3, 4);
		addEdge(adj, 3, 5);
		addEdge(adj, 4, 5);
		addEdge(adj, 5, 6);
		addEdge(adj, 6, 7);
		addEdge(adj, 6, 8);
		addEdge(adj, 7, 8);

		System.out.println("Sum of dependencies is " + findSum(adj, V));
	}

	private static int findSum(List<List<Integer>> adj, int V) {
		int sum = 0;

		for (int u = 0; u < V; u++)
			sum += adj.get(u).size();

		return sum / 2;
	}

	private static void addEdge(List<List<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
}
