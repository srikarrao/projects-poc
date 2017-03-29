package com.java.iq.core.graphs.primsalgorithm;

import java.util.*;

public class HeapMap {

	public static class WeightedVertex {
		public String vertexKey;
		public int weight;

		public WeightedVertex(String vertexKey, int weight) {
			this.vertexKey = vertexKey;
			this.weight = weight;
		}
	}

	public static class MapComparator implements Comparator<WeightedVertex> {

		@Override
		public int compare(WeightedVertex o1, WeightedVertex o2) {
			return Integer.compare(o1.weight, o2.weight);
		}
	}

	public Map<String, WeightedVertex> vertexMap;
	public PriorityQueue<WeightedVertex> minHeap;
	public List<String> vertices;
	public static final MapComparator MAP_COMP = new MapComparator();

	public HeapMap(List<String> V) {
		minHeap = new PriorityQueue<WeightedVertex>(16, MAP_COMP);
		vertexMap = new HashMap<String, WeightedVertex>();
		this.vertices = V;

		WeightedVertex temp = new WeightedVertex(vertices.get(0), 0);
		minHeap.add(temp);
		vertexMap.put(vertices.get(0), temp);

		for (int i = 1; i < vertices.size(); i++) {
			temp = new WeightedVertex(vertices.get(i), Integer.MAX_VALUE);
			minHeap.add(temp);
			vertexMap.put(vertices.get(i), temp);
		}
	}

	public void add(String key, WeightedVertex value) {
		vertexMap.put(key, value);
	}

	public WeightedVertex getVertex(String key) {
		return vertexMap.get(key);
	}

	public boolean containsKey(String VKey) {
		return vertexMap.containsKey(VKey);
	}

	public boolean isEmpty() {
		return minHeap.isEmpty();
	}

	public WeightedVertex getMinVertex() {
		WeightedVertex temp = minHeap.remove();
		vertexMap.remove(temp.vertexKey);
		return temp;
	}

	public static void main(String[] args) {
		List<String> vertices = new ArrayList<String>(Arrays.asList("A", "B",
				"C", "D"));
		HeapMap map = new HeapMap(vertices);
		System.out.println(map.isEmpty());
		System.out.println(map.getMinVertex().vertexKey);
		map.minHeap.add(new WeightedVertex("X", -100));
		map.minHeap.peek().weight++;
		WeightedVertex t = map.getMinVertex();
		System.out.println(t.vertexKey);
		System.out.println(t.weight);
	}
}
