package com.java.iq.core.graphs;

import java.util.*;

/**
 * Source: http://www.geeksforgeeks.org/detect-cycle-in-a-graph/ <br>
 * Time Complexity: O (V + E) <br>
 * Space Complexity: O (V) <br>
 * 
 * @author SrikarRao
 *
 */
public class CheckDirectedGraph {
	public static void main(String[] args) {
		Node<Integer> trueRoot = getSampleCyclicGraph();
		System.out.println("Graph has cycle? " + isCyclic(trueRoot));

		Node<Integer> falseRoot = getSampleAcyclicGraph();
		System.out.println("Graph has cycle? " + isCyclic(falseRoot));
	}

	/**
	 * method to validate if graph is cyclic
	 * 
	 * @param graph
	 * @return
	 */
	private static boolean isCyclic(Node<Integer> graph) {
		if (graph == null || graph.adjNodes.size() == 0) {
			return false;
		}

		Stack<Node<Integer>> recursiveStack = new Stack<Node<Integer>>();
		recursiveStack.add(graph);
		graph.isVisited = true;

		while (!recursiveStack.isEmpty()) {
			Node<Integer> temp = recursiveStack.pop();

			for (int i = 0; i < temp.adjNodes.size(); i++) {
				if (temp.adjNodes.get(i).isVisited) {
					return true;
				} else {
					recursiveStack.push(temp.adjNodes.get(i));
				}
			}
		}
		return false;
	}

	public static Node<Integer> getSampleCyclicGraph() {
		Node<Integer> N0 = new Node<Integer>(0);
		Node<Integer> N1 = new Node<Integer>(1);
		Node<Integer> N2 = new Node<Integer>(2);
		Node<Integer> N3 = new Node<Integer>(3);

		N0.adjNodes.add(N1);
		N0.adjNodes.add(N2);

		N1.adjNodes.add(N2);

		N2.adjNodes.add(N0);
		N2.adjNodes.add(N3);

		N3.adjNodes.add(N0);

		return N0;
	}

	public static Node<Integer> getSampleAcyclicGraph() {
		Node<Integer> N0 = new Node<Integer>(0);
		Node<Integer> N1 = new Node<Integer>(1);
		Node<Integer> N2 = new Node<Integer>(2);
		Node<Integer> N3 = new Node<Integer>(3);

		N0.adjNodes.add(N1);
		N0.adjNodes.add(N2);
		N1.adjNodes.add(N3);
		return N0;
	}

	static class Node<T> {

		T data;
		boolean isVisited;
		List<Node<T>> adjNodes;

		public Node(T data) {
			this.data = data;
			adjNodes = new ArrayList<Node<T>>();
		}
	}
}
