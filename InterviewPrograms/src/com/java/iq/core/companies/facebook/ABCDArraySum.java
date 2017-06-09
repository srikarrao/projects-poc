package com.java.iq.core.companies.facebook;

import java.util.*;
import java.util.Map.Entry;

/**
 * Source: https://www.careercup.com/question?id=5652354158297088 <br>
 * 
 * @author srikarrao
 *
 */
public class ABCDArraySum {

	static class Indices {
		int x;
		int y;

		public Indices(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Result {
		Indices AB;
		Indices CD;
		int sum;

		public Result(Indices AB, Indices CD, int sum) {
			this.AB = AB;
			this.CD = CD;
			this.sum = sum;
		}
	}

	public static void main(String[] args) {
		Result res = getIndices(new int[] { 3, 4, 7, 1, 2, 9, 8 });
		System.out.println("Sum Obtained: " + res.sum);
		System.out.println("Indices: (" + res.AB.x + "," + res.AB.y + ")(" + res.CD.x + "," + res.CD.y + ")");

	}

	private static Result getIndices(int[] arr) {
		Result res = null;
		Map<Integer, List<Indices>> resultMap = new HashMap<Integer, List<Indices>>();

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				sum = arr[i] + arr[j];
				if (!resultMap.containsKey(sum)) {
					resultMap.put(sum, new ArrayList<Indices>());
				}

				List<Indices> temp = resultMap.get(sum);
				Indices ind = new Indices(i, j);
				temp.add(temp.size(), ind);
			}
		}

		Set<Entry<Integer, List<Indices>>> set = resultMap.entrySet();
		Iterator<Entry<Integer, List<Indices>>> iter = set.iterator();

		while (iter.hasNext()) {
			Entry<Integer, List<Indices>> val = iter.next();
			if (val.getValue().size() >= 2) {
				res = new Result(val.getValue().get(0), val.getValue().get(1),
						arr[val.getValue().get(0).x] + arr[val.getValue().get(0).y]);
				break;
			}
		}
		return res;
	}
}
