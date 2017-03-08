package com.java.iq.core.arrays;

public class LongestPositiveSequence {

	static class Sequence {
		int index;
		int count;

		public Sequence(int index, int count) {
			this.index = index;
			this.count = count;
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 2, -3, 2, 3, 4, -6, 1, 2, 3, 4, 5, -8, 5, 6 };
		Sequence res = getSequence(A);
		System.out.println("Start Index: " + (res.index + 1) + ", Max Count: "
				+ res.count);
	}

	private static Sequence getSequence(int[] arr) {

		int count = 0;
		int index = -1;
		int max = 0;
		Sequence seq = new Sequence(index, count);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				if (count == 0) {
					index = i;
				}
				count++;
			} else {
				if (count > 0) {
					max = Math.max(seq.count, count);
					seq.count = max;
					if (max == count) {
						seq.index = index;
					}
					count = 0;
				}
			}
		}
		return seq;
	}

}
