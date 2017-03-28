package com.java.iq.core.graphs.primsalgorithm;

import java.util.*;

public class HeapMap {

	static class WeightedVertex {
		int vertex;
		int weight;

		public WeightedVertex(int vertex, int weight) {
			this.vertex = vertex;
			this.weight = weight;
		}
	}

	private static class MapComparator implements Comparator<WeightedVertex> {

		@Override
		public int compare(WeightedVertex o1, WeightedVertex o2) {
			return Integer.compare(o1.weight, o2.weight);
		}
	}

	private Map<Integer, Integer> vertexMap;
	private PriorityQueue<WeightedVertex> minHeap;
	private List<Integer> vertices;
	private static final MapComparator MAP_COMP = new MapComparator();

	public HeapMap(List<Integer> V) {

		minHeap = new PriorityQueue<WeightedVertex>(MAP_COMP);
		vertexMap = new HashMap<Integer, Integer>();
		this.vertices = V;

		minHeap.add(new WeightedVertex(vertices.get(0), 0));
		vertexMap.put(vertices.get(0), 0);

		for (int i = 1; i < vertices.size(); i++) {
			minHeap.add(new WeightedVertex(vertices.get(0), Integer.MAX_VALUE));
			vertexMap.put(vertices.get(0), Integer.MAX_VALUE);
		}
	}

	private WeightedVertex remove() {
		WeightedVertex temp = minHeap.remove();
		vertexMap.remove(temp.vertex);
		return temp;
	}
}
