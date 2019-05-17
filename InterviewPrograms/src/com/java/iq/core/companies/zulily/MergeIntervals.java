package com.java.iq.core.companies.zulily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/merge-intervals/
 * 
 * @author srikarrao
 *
 */
public class MergeIntervals {
	public static void main(String[] args) {
		Interval test1_1 = new Interval(1, 3);
		Interval test1_2 = new Interval(7, 9);
		Interval test1_3 = new Interval(3, 5);
		Interval test1_4 = new Interval(2, 5);
		Interval test1_5 = new Interval(4, 6);
		Interval test1_6 = new Interval(2, 4);

		mergeIntervals(Arrays.asList(test1_1, test1_2, test1_3, test1_4, test1_5, test1_6))
				.forEach(System.out::println);

		System.out.println("###########");

		Interval test2_1 = new Interval(1, 3);
		Interval test2_2 = new Interval(2, 6);
		Interval test2_3 = new Interval(8, 10);
		Interval test2_4 = new Interval(15, 18);

		mergeIntervals(Arrays.asList(test2_1, test2_2, test2_3, test2_4)).forEach(System.out::println);

		System.out.println("###########");

		Interval test3_1 = new Interval(1, 4);
		Interval test3_2 = new Interval(4, 5);

		mergeIntervals(Arrays.asList(test3_1, test3_2)).forEach(System.out::println);

	}

	private static List<Interval> mergeIntervals(List<Interval> intervals) {
		List<Interval> result = new ArrayList<>();
		Collections.sort(intervals);
		Interval temp = intervals.get(0);
		int i = 1;
		while (i < intervals.size()) {
			Interval interval = intervals.get(i);
			if (temp.end >= interval.start) {
				temp.start = Math.min(interval.start, temp.start);
				temp.end = Math.max(interval.end, temp.end);
			} else {
				result.add(temp);
				temp = interval;
			}
			i++;
		}

		result.add(temp);
		return result;
	}

	static class Interval implements Comparable<Interval> {

		int start;
		int end;

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + end;
			result = prime * result + start;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Interval other = (Interval) obj;
			if (end != other.end)
				return false;
			if (start != other.start)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Interval [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Interval o) {
			if (Integer.compare(this.start, o.start) != 0) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
	}
}