package com.java.iq.core.arrays;

/**
 * Source: http://www.geeksforgeeks.org/count-passing-car-pairs/
 * 
 * @author srikarrao.gandla
 *
 */
public class CarPairsCount {

	/**
	 * Time Complexity: O(n^2)
	 * 
	 * Space Complexity: O(1)
	 * 
	 * @param A
	 * @param n
	 * @return
	 */
	public static int getPassingCars(int A[], int n) {
		int result = 0;
		for (int i = 0; i < n - 1; i++) {
			if (A[i] == 0) {
				for (int j = i + 1; j < n; j++)
					if (A[j] == 1)
						result++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int A[] = { 0, 1, 0, 1, 1 };
		int n = A.length;
		System.out.println(getPassingCars(A, n));
	}

}