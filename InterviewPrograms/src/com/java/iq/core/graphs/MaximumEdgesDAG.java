package com.java.iq.core.graphs;

import java.util.*;

/**
 * <p>
 * Source: http://www.geeksforgeeks.org/maximum-edges-can-added-dag-remains-dag/
 * <br>
 * 
 * </p>
 * 
 * @author srikarrao.gandla
 *
 */
public class MaximumEdgesDAG {

	static class Graph {
		private int V;
		private List<List<Integer>> adj;
		private List<Integer> indegree;

		public Graph(int V) {
			this.V = V;
			adj = new ArrayList<List<Integer>>(V);
			indegree = new ArrayList<Integer>();
			for (int i = 0; i < V; i++) {
				indegree.add(0);
				adj.add(new ArrayList<Integer>());
			}
		}

		/**
		 * Method to add an edge
		 * 
		 * @param v
		 * @param w
		 */
		private void addEdge(int v, int w) {
			adj.get(v).add(w);
			indegree.set(w, indegree.get(w) + 1);
		}

		/**
		 * Method to topologically sort the graph
		 * 
		 * @return
		 */
		private List<Integer> topologicalSort() {
			List<Integer> topological = new ArrayList<Integer>();
			Queue<Integer> q = new LinkedList<Integer>();

			for (int i = 0; i < V; i++) {
				if (indegree.get(i) == 0) {
					q.add(i);
				}
			}

			while (!q.isEmpty()) {
				int t = q.remove();

				topological.add(t);
				for (int j = 0; j < adj.size(); j++) {
					indegree.set(j, indegree.get(j) - 1);
					if (indegree.get(j) == 0)
						q.add(j);
				}
			}
			return topological;

		}

		/**
		 * Method to add maximum edges
		 */
		private void maximumEdgeAddtion() {
			boolean[] visited = new boolean[V];
			List<Integer> topo = topologicalSort();

			for (int i = 0; i < topo.size(); i++) {
				int t = topo.get(i);
				// set all adjacent nodes to true
				for (int j = 0; j < adj.get(t).size(); j++) {
					visited[adj.get(t).get(j)] = true;
				}

				for (int j = i + 1; j < topo.size(); j++) {
					if (!visited[topo.get(j)]) {
						System.out.println(t + "-" + topo.get(j) + " ");
					}
					visited[topo.get(j)] = false;
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(6);
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		g.maximumEdgeAddtion();
	}
}