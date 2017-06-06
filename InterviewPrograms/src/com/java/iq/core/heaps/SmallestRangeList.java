package com.java.iq.core.heaps;
import java.util.*;

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
public class SmallestRangeList {

	private static class MinHeapNode {
		int element;
		int i;
		int j;
	}

	private static class MinHeap {
		MinHeapNode[] harr;
		int heap_size;

		MinHeap(MinHeapNode a[], int size) {
			heap_size = size;
			harr = a;
			int i = (heap_size - 1) / 2;
			while (i >= 0) {
				minHeapify(i);
				i--;
			}

		}

		private void minHeapify(int i) {
			int l = left(i);
			int r = right(i);
			int smallest = i;
			if (l < heap_size && harr[l].element < harr[i].element)
				smallest = l;
			if (r < heap_size && harr[r].element < harr[smallest].element)
				smallest = r;
			if (smallest != i) {
				swap(harr, i, smallest);
				minHeapify(smallest);
			}
		}

		private void swap(MinHeapNode[] harr, int i, int smallest) {
			MinHeapNode temp = harr[i];
			harr[i] = harr[smallest];
			harr[smallest] = temp;
		}

		private int left(int i) {
			return (2 * i + 1);
		}

		private int right(int i) {
			return (2 * i + 2);
		}

		private MinHeapNode getMin() {
			return harr[0];
		}

		private void replaceMin(MinHeapNode x) {
			harr[0] = x;
			minHeapify(0);
		}
	}

	private static void findSmallestRange(List<List<Integer>> arr, int k) {
		int range = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		int start = -1, end = -1;

		MinHeapNode[] harr = new MinHeapNode[k];
		for (int i = 0; i < k; i++) {

			if (harr[i] == null) {
				harr[i] = new MinHeapNode();
			}
			harr[i].element = arr.get(i).get(0);
			harr[i].i = i;
			harr[i].j = 1;

			if (harr[i].element > max)
				max = harr[i].element;
		}

		MinHeap hp = new MinHeap(harr, k);
		harr = hp.harr;

		while (true) {
			MinHeapNode root = hp.getMin();
			min = hp.getMin().element;

			if (range > max - min + 1) {
				range = max - min + 1;
				start = min;
				end = max;
			}

			if (root.j < arr.get(root.i).size()) {
				root.element = arr.get(root.i).get(root.j);
				root.j += 1;

				if (root.element > max)
					max = root.element;
			} else {
				break;
			}

			hp.replaceMin(root);
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
