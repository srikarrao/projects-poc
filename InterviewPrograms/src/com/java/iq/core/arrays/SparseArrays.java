package com.java.iq.core.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find string occurrence in arrays 
 * @author SrikarRao
 *
 */
public class SparseArrays {

	public static void main(String[] args) {
		List<String> inputList = new ArrayList<String>(Arrays.asList("aba",
				"baba", "xzxb", "aba"));
		List<String> queriesList = new ArrayList<String>(Arrays.asList("aba",
				"xzxb", "ab"));
		processOccurence(inputList, queriesList);
	}

	/**
	 * process the occurrence
	 * @param stringsList
	 * @param queriesList
	 */
	public static void processOccurence(List<String> stringsList,
			List<String> queriesList) {
		for (int i = 0; i < queriesList.size(); i++) {
			System.out.println(findStringOccurences(stringsList,
					queriesList.get(i)));
		}
	}

	/**
	 * returns the occurrence count
	 * @param stringsList
	 * @param query
	 * @return
	 */
	public static int findStringOccurences(List<String> stringsList,
			String query) {

		int count = 0;
		for (int i = 0; i < stringsList.size(); i++) {
			if (stringsList.get(i).equals(query)) {
				count++;
			}
		}
		return count;
	}
}