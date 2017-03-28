package com.temp.graphs;

import java.util.*;

public class Graph {

	public static class Edge {
		int source;
		int destination;
		int weight;

		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "(Source: " + this.source + ", Destination: "
					+ this.destination + ", Weight: " + this.weight + ")";
		}
	}

	private List<Integer> vertices;
	private List<Edge> edges;
	private List<List<Integer>> adjVertices;

	public int getWeight(int s, int d) {
		for (Edge e : edges) {
			if (e.source == s && e.destination == d) {
				return e.weight;
			}
		}
		return Integer.MAX_VALUE;
	}

	public Edge getEdge(int s, int d) {
		for (Edge e : edges) {
			if (e.source == s && e.destination == d) {
				return e;
			}
		}
		return null;
	}

	public Graph(int V, int E) {
		vertices = new ArrayList<Integer>(V);
		adjVertices = new ArrayList<List<Integer>>(V);
		edges = new ArrayList<Edge>(E);

		for (int i = 0; i < V; i++) {
			vertices.add(i);
			adjVertices.add(new ArrayList<Integer>());
		}

	}

	public void addEdge(int src, int dest, int weight) {
		edges.add(new Edge(src, dest, weight));
		adjVertices.get(src).add(dest);
	}

	public List<Integer> getVertices() {
		return vertices;
	}

	public void setVertices(List<Integer> vertices) {
		this.vertices = vertices;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public List<List<Integer>> getAdjVertices() {
		return adjVertices;
	}

	public void setAdjVertices(List<List<Integer>> adjVertices) {
		this.adjVertices = adjVertices;
	}
}
