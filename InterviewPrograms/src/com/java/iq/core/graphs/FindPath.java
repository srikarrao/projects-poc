package com.java.iq.core.graphs;

import java.util.*;

/*
 * Source: http://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-a-given-graph/ <br>
 * BFS Complexity
 * 
 */
class Graph {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[];

	@SuppressWarnings("unchecked")
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	Boolean isReachable(int s, int d) {
		LinkedList<Integer> temp;

		boolean visited[] = new boolean[V];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;
		queue.add(s);

		Iterator<Integer> i;
		while (queue.size() != 0) {
			s = queue.poll();
			int n;
			i = adj[s].listIterator();

			while (i.hasNext()) {
				n = i.next();
				if (n == d)
					return true;
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
		return false;
	}
}

public class FindPath {
	public static void main(String args[]) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		int u = 1;
		int v = 3;
		if (g.isReachable(u, v))
			System.out.println("There is a path from " + u + " to " + v);
		else
			System.out.println("There is no path from " + u + " to " + v);

		u = 3;
		v = 1;
		if (g.isReachable(u, v))
			System.out.println("There is a path from " + u + " to " + v);
		else
			System.out.println("There is no path from " + u + " to " + v);
	}
}