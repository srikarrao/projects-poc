package com.java.iq.core.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JAVA program to find duplicate words and replace all of them
 * 
 * @author SrikarRao
 *
 */
public class RegexDuplicateWords {

	public static void main(String[] args) {
		String pattern = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
		Pattern r = Pattern.compile(pattern, Pattern.MULTILINE
				+ Pattern.CASE_INSENSITIVE);

		List<String> stringsList = new ArrayList<String>(Arrays.asList(
				"Goodbye bye bye world world world",
				"Swapnil went went to to to his business",
				"Rana is is the the best player in eye eye game", "in in the",
				"Hello hello Ab aB"));
		int testCases = 0;
		while (testCases < stringsList.size()) {
			String input = stringsList.get(testCases++);
			Matcher m = r.matcher(input);
			while (m.find()) {
				input = input.replaceAll(m.group(), m.group(1));
			}
			System.out.println(input);
		}
	}
}