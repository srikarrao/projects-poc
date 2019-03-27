package com.java.iq.core.strings;

import java.util.*;

/**
 * https://leetcode.com/problems/zigzag-conversion/
 * 
 * @author srikarrao
 *
 */
public class ZigZagConversion {
	public String convert(String s, int numRows) {

		if (numRows <= 1 || s == null || s.isEmpty()) {
			return s;
		}

		if (numRows > s.length()) {
			return s;
		}
		Map<Integer, StringBuilder> zigZagRows = new HashMap<>();
		StringBuilder result = new StringBuilder();

		boolean isZigZagStarted = false;
		int rowIndex = 1;

		for (int i = 0; i < s.length(); i++) {
			char value = s.charAt(i);

			if (!isZigZagStarted) {
				StringBuilder sb = zigZagRows.get(rowIndex);
				if (sb == null) {
					zigZagRows.put(rowIndex, new StringBuilder());
				}
				zigZagRows.put(rowIndex, zigZagRows.get(rowIndex).append(value));
				rowIndex++;
				if (rowIndex == numRows + 1) {
					rowIndex = numRows - 1;
					isZigZagStarted = true;
				}
			} else {
				zigZagRows.put(rowIndex, zigZagRows.get(rowIndex).append(value));
				rowIndex--;
				if (rowIndex < 1) {
					rowIndex = 2;
					isZigZagStarted = false;
				}
			}
		}

		for (int i = 1; i <= numRows; i++) {
			result.append(zigZagRows.get(i));
		}

		return result.toString();
	}

	public static void main(String[] args) {
		System.out.println(new ZigZagConversion().convert("ABCD", 2));
		System.out.println(new ZigZagConversion().convert("ABCD", 3));
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 3));
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 4));
	}
}