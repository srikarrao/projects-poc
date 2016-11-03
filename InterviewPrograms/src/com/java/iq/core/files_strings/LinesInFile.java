package com.java.iq.core.files_strings;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JAVA program to display lines in a file
 * 
 * @author SrikarRao
 *
 */
public class LinesInFile {
	public static void main(String[] args) {
		File file = new File("input-files/robots.txt");
		List<String> result = readLines(file);
		for (String s : result) {
			System.out.println("Line-->" + s + "::Length-->" + s.length());
		}
	}

	/**
	 * method to read lines from the file
	 * 
	 * @param file
	 * @return
	 */
	private static List<String> readLines(File file) {

		List<String> disimilarLines = new ArrayList<String>();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			StringBuilder sb = new StringBuilder();
			int content = 0;
			while ((content = fis.read()) != -1) {
				char c = (char) content;
				if (c == '\n' || c == '\r') {
					if (sb.length() > 0 && sb.length() != 2134) {
						disimilarLines.add(sb.toString());
					}
					sb = new StringBuilder();
				} else {
					sb.append(c);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return disimilarLines;
	}
}