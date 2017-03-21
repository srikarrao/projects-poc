package com.java.iq.core.graphs;

import java.util.*;

/**
 * Source:
 * http://www.geeksforgeeks.org/delete-edge-minimize-subtree-sum-difference/ <br>
 * 
 * @author SrikarRao
 *
 */
public class MinimumDeletedEdgeSum {

	private static int res = Integer.MAX_VALUE;

	public static void main(String[] args) {

		int vertex[] = { 4, 2, 1, 6, 3, 5, 2 };
		List<List<Integer>> edges = new ArrayList<List<Integer>>();
		edges.add(Arrays.asList(0, 1));
		edges.add(Arrays.asList(0, 2));
		edges.add(Arrays.asList(0, 3));
		edges.add(Arrays.asList(2, 4));
		edges.add(Arrays.asList(2, 5));
		edges.add(Arrays.asList(3, 6));

		int N = vertex.length;
		getMinSubtreeSumDifference(vertex, edges, N);
		System.out.println(res);
	}

	/*
	 * DFS method to traverse through edges, calculating subtree sum at each
	 * node and updating the difference between subtrees
	 */
	private static void dfs(int u, int parent, int totalSum,
			List<List<Integer>> edge, int subtree[]) {
		int sum = subtree[u];

		/*
		 * loop for all neighbors except parent and aggregate sum over all
		 * subtrees
		 */
		for (int i = 0; i < edge.get(u).size(); i++) {
			int v = edge.get(u).get(i);
			if (v != parent) {
				dfs(v, u, totalSum, edge, subtree);
				sum += subtree[v];
			}
		}

		// store sum in current node's subtree index
		subtree[u] = sum;

		/*
		 * at one side subtree sum is 'sum' and other side subtree sum is
		 * 'totalSum - sum' so their difference will be totalSum - 2*sum, by
		 * which we'll update res
		 */
		if (u != 0 && Math.abs(totalSum - 2 * sum) < res)
			res = Math.abs(totalSum - 2 * sum);
	}

	private static void getMinSubtreeSumDifference(int[] vertex,
			List<List<Integer>> edges, int N) {
		int totalSum = 0;
		int[] subtree = new int[N];

		// Calculating total sum of tree and initializing
		// subtree sum's by vertex values
		for (int i = 0; i < N; i++) {
			subtree[i] = vertex[i];
			totalSum += vertex[i];
		}

		List<List<Integer>> E = new ArrayList<List<Integer>>();
		for (int i = 0; i < N - 1; i++) {
			E.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < N - 1; i++) {
			System.out.println(i);
			E.get(edges.get(i).get(0)).add(edges.get(i).get(1));
			E.get(edges.get(i).get(1)).add(edges.get(i).get(0));
		}

		dfs(0, -1, totalSum, E, subtree);
	}

}