package com.java.iq.core.companies.bloomberg;

/**
 * JAVA program to perform sparse matrix multiplication
 * 
 * @author SrikarRao
 *
 */
public class SparseMatrixMultiplication {

	/**
	 * brute force way of multiplying a sparse matrix
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] multiply_naive(int[][] A, int[][] B) {

		int[][] C = new int[A.length][B[0].length];
		for (int i = 0; i < C.length; i++) {
			for (int j = 0; j < C[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < A[0].length; k++) {
					sum += A[i][k] * B[k][j];
				}
				C[i][j] = sum;
			}
		}
		return C;
	}

	/**
	 * optimized way of multiplying a sparse matrix
	 * 
	 * @param A
	 * @param B
	 * @return
	 */
	public int[][] multiply(int[][] A, int[][] B) {

		int[][] C = new int[A.length][B[0].length];
		for (int i = 0; i < C.length; i++) {
			for (int k = 0; k < A[0].length; k++) {
				if (A[i][k] != 0) {
					for (int j = 0; j < C[0].length; j++) {
						C[i][j] += A[i][k] * B[k][j];
					}
				}
			}
		}
		return C;
	}
}
