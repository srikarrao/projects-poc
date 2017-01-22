package com.java.iq.core.regex;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * JAVA Program to validate if the given regular expression is valid
 * 
 * @author SrikarRao
 *
 */
public class RegexValidator {

	public static void main(String[] arguments) {
		String pattern = "[[a-z]";
		boolean isValid = true;
		try {
			Pattern.compile(pattern);
		} catch (PatternSyntaxException exception) {
			isValid = false;
			System.out.println(pattern + " is invalid");
			// System.err.println(exception.getDescription());
		}
		if (isValid) {
			System.out.println(pattern + " is valid");
		}
	}
}
