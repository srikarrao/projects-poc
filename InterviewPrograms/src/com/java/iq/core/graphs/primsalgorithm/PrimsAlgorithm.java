package com.temp.graphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.temp.graphs.Graph.Edge;
import com.temp.graphs.HeapMap.WeightedVertex;

public class PrimsAlgorithm {

	public static void main(String[] args) {

		Graph graph = new Graph(6, 9);

		graph.addEdge(0, 1, 3);
		graph.addEdge(0, 3, 1);

		graph.addEdge(1, 0, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 3);

		graph.addEdge(2, 1, 1);
		graph.addEdge(2, 3, 1);
		graph.addEdge(2, 4, 5);
		graph.addEdge(2, 5, 4);

		graph.addEdge(3, 0, 1);
		graph.addEdge(3, 1, 3);
		graph.addEdge(3, 2, 1);
		graph.addEdge(3, 4, 6);

		graph.addEdge(4, 2, 5);
		graph.addEdge(4, 3, 6);
		graph.addEdge(4, 5, 2);

		graph.addEdge(5, 2, 4);
		graph.addEdge(5, 4, 2);

		Map<Integer, Edge> result = new PrimsAlgorithm().prismImpl(graph);
		Set<Integer> set = result.keySet();
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			int key = iter.next();
			System.out.println("Vertex: " + key + " --> Edge: "
					+ result.get(key));
		}
	}

	private Map<Integer, Edge> prismImpl(Graph graph) {
		Map<Integer, Edge> result = new HashMap<Integer, Edge>();

		HeapMap heapMap = new HeapMap(graph.getVertices());
		List<List<Integer>> neighbors = graph.getAdjVertices();

		while (!heapMap.isEmpty()) {
			WeightedVertex src = heapMap.getMinVertex();
			List<Integer> tempAdj = neighbors.get(src.vertexKey);

			for (Integer i : tempAdj) {
				if (heapMap.containsKey(i)) {
					WeightedVertex dest = heapMap.getVertex(i);
					Edge edge = graph.getEdge(src.vertexKey, dest.vertexKey);
					dest.weight = Math.min(dest.weight, edge.weight);

					if (dest.weight == edge.weight) {
						result.put(dest.vertexKey, edge);
					}
				}
			}

		}

		return result;
	}
}
