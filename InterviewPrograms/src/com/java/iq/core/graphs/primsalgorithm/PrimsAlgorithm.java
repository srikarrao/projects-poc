package com.java.iq.core.graphs.primsalgorithm;

import java.util.*;
import com.java.iq.core.graphs.primsalgorithm.Graph.Edge;
import com.java.iq.core.graphs.primsalgorithm.HeapMap.WeightedVertex;

public class PrimsAlgorithm {

	public static void main(String[] args) {

		Graph graph = new Graph(6, 9);

		graph.addEdge("A", "D", 1);
		graph.addEdge("A", "B", 3);

		graph.addEdge("B", "C", 1);
		graph.addEdge("B", "D", 3);

		graph.addEdge("C", "D", 1);
		graph.addEdge("C", "E", 5);
		graph.addEdge("C", "F", 4);

		graph.addEdge("D", "E", 6);

		graph.addEdge("E", "F", 2);

		Map<String, Edge> result = new PrimsAlgorithm().prismImpl(graph);
		Set<String> set = result.keySet();
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println("Vertex: " + key + " --> Edge: "
					+ result.get(key));
		}
	}

	private Map<String, Edge> prismImpl(Graph graph) {
		Map<String, Edge> result = new HashMap<String, Edge>();
		Map<String, Edge> cache = new HashMap<String, Edge>();

		HeapMap heapMap = new HeapMap(graph.getVertices());

		while (!heapMap.isEmpty()) {
			System.out.println(heapMap.minHeap.peek().vertexKey + " "
					+ heapMap.minHeap.peek().weight);
			WeightedVertex src = heapMap.getMinVertex(); // A
			List<String> tempAdj = graph.getAdjVertices(src.vertexKey); // D,B,C

			if (!src.vertexKey.equals("A")) {
				result.put(src.vertexKey, cache.remove(src.vertexKey));
			}
			for (String st : tempAdj) {
				if (st != null && heapMap.containsKey(st)) {
					WeightedVertex dest = heapMap.getVertex(st);
					Edge edge = graph.getEdge(src.vertexKey, dest.vertexKey);
					dest.weight = Math.min(dest.weight, edge.weight);

					if (dest.weight == edge.weight) {
						cache.put(dest.vertexKey, edge);
					}
				}
			}
		}
		return result;
	}
}