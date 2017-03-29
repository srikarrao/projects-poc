package com.java.iq.core.graphs.primsalgorithm;

import java.util.*;

public class Graph {

	public static class Edge {
		String source;
		String destination;
		int weight;

		public Edge(String source, String destination, int weight) {
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

	private List<String> vertices;
	private List<Edge> edges;
	private Map<String, List<String>> adjVertices;

	public int getWeight(String s, String d) {
		for (Edge e : edges) {
			if (e.source.equals(s) && e.destination.equals(d)) {
				return e.weight;
			}
		}
		return Integer.MAX_VALUE;
	}

	public Edge getEdge(String s, String d) {
		for (Edge e : edges) {
			if (e.source.equals(s) && e.destination.equals(d)) {
				return e;
			}
		}
		return null;
	}

	public Graph(int V, int E) {
		vertices = new ArrayList<String>(V);
		adjVertices = new HashMap<String, List<String>>();
		edges = new ArrayList<Edge>(E);
		for (int i = 0; i < V; i++) {
			int val = 'A' + i;
			char ch = (char) val;
			StringBuilder sb = new StringBuilder(ch + "");
			vertices.add(sb.toString());
			adjVertices.put(sb.toString(), new ArrayList<String>());
		}

	}

	public void addEdge(String src, String dest, int weight) {
		edges.add(new Edge(src, dest, weight));
		adjVertices.get(src).add(dest);

	}

	public List<String> getVertices() {
		return vertices;
	}

	public void setVertices(List<String> vertices) {
		this.vertices = vertices;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	public List<String> getAdjVertices(String key) {
		return adjVertices.get(key);
	}

}
