package com.java.iq.core.stacks;

import java.util.*;

/**
 * Source: https://www.hackerrank.com/challenges/poisonous-plants <br>
 * 
 * @author srikarrao
 *
 */
public class PoisonousPlants {

	public static void main(String[] args) {

		int n = 7;
		int[] p = { 6, 5, 8, 4, 7, 10, 9 };

		int[] days = new int[n];
		int min = p[0];
		int max = 0;
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);

		for (int i = 1; i < n; i++) {
			if (p[i] > p[i - 1])
				days[i] = 1;

			min = min < p[i] ? min : p[i];

			while (!s.empty() && p[s.peek()] >= p[i]) {
				if (p[i] > min)
					days[i] = days[i] > days[s.peek()] + 1 ? days[i] : days[s.peek()] + 1;
				s.pop();
			}

			max = max > days[i] ? max : days[i];
			s.push(i);
		}
		System.out.println(max);
	}
}