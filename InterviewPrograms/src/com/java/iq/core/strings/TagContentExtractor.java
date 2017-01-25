package com.java.iq.core.strings;

import java.util.regex.*;

/**
 * Java program to extract content in between the tags
 * 
 * @author SrikarRao
 *
 */
public class TagContentExtractor {

	public static void main(String[] args) {
		String[] input = {
				"<h1>Nayeem loves counseling</h1>",
				"<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>",
				"<Amee>safat codes like a ninja</amee>",
				"<SA premium>Srikar has a secret crush</SA premium>" };
		extractTags(input);
	}

	private static void extractTags(String[] inputs) {
		Pattern r = Pattern.compile("<(.+?)>([^<>]+)</\\1>");
		for (String ip : inputs) {
			String line = ip;
			int count = 0;
			Matcher m = r.matcher(line);
			while (m.find()) {
				if (m.group(2).length() != 0) {
					System.out.println(m.group(2));
					count++;
				}
			}
			if (count == 0)
				System.out.println("None");
		}
	}
}
