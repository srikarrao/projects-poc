package com.java.iq.core.graphs;

import java.util.*;

public class KruskalsAlgorithm {

	static class Subset {
		int parent;
		int rank;

		public Subset(int parent, int rank) {
			this.parent = parent;
			this.rank = rank;
		}
	}

	static class DisjointSet {
		Subset[] roots;

		public DisjointSet(int V) {
			roots = new Subset[V];
			for (int i = 0; i < roots.length; i++) {
				roots[i] = new Subset(i, 0);
			}
		}

		void union(int x, int y) {
			int x1 = findParent(x);
			int y1 = findParent(y);

			if (roots[x1].rank <= roots[y1].rank) {
				roots[x1].parent = y1;
			} else if (roots[x1].rank == roots[y1].rank) {
				roots[x1].rank++;
			} else {
				roots[y1].parent = x1;
			}
		}

		int findParent(int child) {
			if (roots[child].parent != child) {
				roots[child].parent = findParent(roots[child].parent);
			}
			return roots[child].parent;
		}
	}

	static class Edge implements Comparable<Edge> {
		int source;
		int destination;
		int weight;

		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}

	static class Graph {
		int V;
		int E;
		List<Edge> edges;

		public Graph(int V, int E) {
			this.V = V;
			this.E = E;
			edges = new ArrayList<Edge>(E);
		}

		void addEdge(int src, int dest, int weight) {
			edges.add(new Edge(src, dest, weight));
		}

		private List<Edge> getMST() {
			List<Edge> result = new ArrayList<Edge>();
			List<Edge> edges = this.edges;
			DisjointSet disjoint = new DisjointSet(this.V);
			Collections.sort(edges);

			for (Edge e : edges) {
				int src = e.source;
				int dest = e.destination;

				int srcParent = disjoint.findParent(src);
				int destParent = disjoint.findParent(dest);
				if (srcParent != destParent) {
					result.add(e);
					disjoint.union(srcParent, destParent);
				}
			}

			return result;
		}
	}

	public static void main(String[] args) {

		int V = 4;
		int E = 5;
		Graph graph = new Graph(V, E);

		graph.addEdge(0, 1, 10);
		graph.addEdge(0, 2, 6);
		graph.addEdge(0, 3, 5);
		graph.addEdge(1, 3, 15);
		graph.addEdge(2, 3, 4);

		List<Edge> res = graph.getMST();
		System.out.println("Edges in the constructed MST!");
		for (Edge e : res) {
			System.out.println(e.source + " -- " + e.destination + " == "
					+ e.weight);
		}
	}
}
