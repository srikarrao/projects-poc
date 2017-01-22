package com.java.iq.core.arrays_strings;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Program to implement Dynamic array
 * 
 * @author SrikarRao
 *
 */
public class DynamicArray {

	public static void main(String[] args) throws NumberFormatException,
			IOException {

		// initialize the number of queries and sequences
		int[] arrayVal = { 100, 100 };

		// number of queries with x, y values
		int[][] queries = new int[100][3];

		fillQueries(queries); // method to fill the test cases
		printDynamicArrayValues(arrayVal, queries);
	}

	/**
	 * method to fill the test cases as queries
	 * 
	 * @param queries
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	public static void fillQueries(int[][] queries)
			throws NumberFormatException, IOException {
		File file = new File("input-files/dynamicarray-testcase1.txt");
		BufferedReader reader = null;

		reader = new BufferedReader(new FileReader(file));
		for (int i = 0; i < queries.length; i++) {
			String text = reader.readLine();
			int x = 0;
			int val = 0;
			int y = 0;
			while (x < text.length()) {
				if (text.charAt(x) == ' ' || x == text.length() - 1) {
					if (x == text.length() - 1) {
						queries[i][y++] = val * 10 + (text.charAt(x) - '0');
					} else {
						queries[i][y++] = val;
					}
					val = 0;
				} else {
					val = val * 10 + (text.charAt(x) - '0');
				}
				x++;
			}
		}
	}

	/**
	 * method to print the last values of the sequences
	 * 
	 * @param vals
	 * @param queries
	 */
	public static void printDynamicArrayValues(int[] vals, int[][] queries) {
		int N = vals[0];
		int queryCount = vals[1];
		int lastAnswer = 0;

		List<List<Integer>> sequenceList = new ArrayList<List<Integer>>(N);
		for (int i = 0; i < N; i++) {
			sequenceList.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < queryCount; i++) {
			if (queries[i][0] == 1) {
				int value1 = (queries[i][1] ^ lastAnswer) % N;
				sequenceList.get(value1).add(queries[i][2]);
			} else {
				int value2 = (queries[i][1] ^ lastAnswer) % N;
				lastAnswer = sequenceList.get(value2).get(
						queries[i][2] % sequenceList.get(value2).size());
				System.out.println(lastAnswer);
			}
		}
	}
}