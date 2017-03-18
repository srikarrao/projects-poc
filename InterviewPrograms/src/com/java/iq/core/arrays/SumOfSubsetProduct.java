package com.java.iq.core.arrays;

/**
 * Source: http://www.geeksforgeeks.org/sum-products-possible-subsets/
 * 
 * @author srikarrao.gandla
 *
 */
public class SumOfSubsetProduct {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4 };
		int n = arr.length;
		System.out.println(productOfSubsetSums(arr, n));
	}

	static int productOfSubsetSums(int arr[], int N) {
		int res = 1;
		for (int i = 0; i < N; ++i)
			res = res * (arr[i] + 1);
		return res - 1;
	}
}
