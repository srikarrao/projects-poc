package com.java.iq.core.companies.uber;

/**
 * This function takes a string and an output buffer and a desired width. It
 * then copies the string to the buffer, inserting a new line character when a
 * certain line length is reached. If the end of the line is in the middle of a
 * word, it will backtrack along the string until white space is found.
 * 
 * @author SrikarRao
 *
 */
public class WordWrap {

	public static void main(String[] args) {

		System.out.println(wordWrap("hello " + "world", 13));
	}

	private static String wordWrap(String str, int line_width) {
		int i = 0;

		StringBuilder buffer = new StringBuilder();
		int strLen = str.length();
		while (i < strLen) {
			for (int counter = 1; counter <= line_width; counter++) {
				if (i == strLen) {
					buffer.append(0);
					return buffer.toString();
				}
				buffer.append(str.charAt(i));
				if (str.charAt(i) == '\n') {
					counter = 1;
				}
				i++;
			}
			if (str.charAt(i - 1) == ' ') {
				buffer.append('\n');
				i++;
			} else {
				int x = 0;
				while (x + 20 < buffer.length()
						&& (x = buffer.lastIndexOf(" ", x + 20)) != -1) {
					buffer.replace(x, x + 1, "\n");
				}
			}
		}

		buffer.append(0);
		return buffer.toString();
	}
}