package com.java.iq.core.heaps;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * <p>
 * Find smallest range containing elements from k lists Given k sorted lists of
 * integers of size n each, find the smallest range that includes at least
 * element from each of the k lists. If more than one smallest ranges are found,
 * print any one of them.
 * </p>
 * 
 * @see <a href="http
 *      ://www.geeksforgeeks.org/find-smallest-range-containing-elements-from
 *      -k-lists/">Source_Reference</a>
 * 
 * @author srikarrao.gandla
 *
 */
public class SmallestRangeList_Solution2 {

	private static final MinHeapSort COMPARATOR = new MinHeapSort();
	private static final int CAPACITY = 16;

	private static class MinHeapNode {
		int element;
		int i;
		int j;
	}

	private static class MinHeapSort implements Comparator<MinHeapNode> {

		@Override
		public int compare(MinHeapNode o1, MinHeapNode o2) {
			int x = o1.element;
			int y = o2.element;

			return x - y;
		}

	}

	private static void findSmallestRange(List<List<Integer>> arr, int k) {
		int range = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int start = -1, end = -1;

		PriorityQueue<MinHeapNode> heap = new PriorityQueue<MinHeapNode>(
				CAPACITY, COMPARATOR);

		for (int i = 0; i < k; i++) {

			MinHeapNode heapNode = new MinHeapNode();
			heapNode.element = arr.get(i).get(0);
			heapNode.i = i;
			heapNode.j = 1;

			heap.add(heapNode);

			if (heapNode.element > max) {
				max = heapNode.element;
			}

		}

		while (heap.size() == k) {
			MinHeapNode root = heap.peek();
			min = root.element;

			if (range > max - min + 1) {
				range = max - min + 1;
				start = min;
				end = max;
			}

			heap.remove();
			if (root.j < arr.get(root.i).size()) {
				root.element = arr.get(root.i).get(root.j);
				root.j += 1;
				heap.add(root);
				if (root.element > max)
					max = root.element;
			}

		}

		System.out.println("The smallest range is [" + start + " " + end + "]");
	}

	public static void main(String[] args) {

		List<List<Integer>> arr = new ArrayList<List<Integer>>();
		arr.add(new ArrayList<Integer>(Arrays.asList(4, 7, 9, 12, 15)));
		arr.add(new ArrayList<Integer>(Arrays.asList(0, 8, 10, 14, 20)));
		arr.add(new ArrayList<Integer>(Arrays.asList(6, 12, 16, 30, 50)));
		int k = arr.size();

		findSmallestRange(arr, k);

	}

}
