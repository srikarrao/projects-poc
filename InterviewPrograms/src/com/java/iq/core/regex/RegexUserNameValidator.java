package com.java.iq.core.regex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * JAVA program to validate username
 * 
 * @author SrikarRao
 *
 */
public class RegexUserNameValidator {
	public static void main(String[] args) {

		List<String> inputsList = new ArrayList<String>(Arrays.asList(
				"alpha_naheed", "xahidbuffon", "nagib@007", "123Swakkhar"));
		int testCases = 0;
		while (testCases < inputsList.size()) {
			String username = inputsList.get(testCases++);
			String pattern = "^[A-Za-z][A-Za-z0-9_]{7,29}$";
			Pattern r = Pattern.compile(pattern);
			Matcher m = r.matcher(username);
			if (m.find()) {
				System.out.println("String: " + username + " is valid");
			} else {
				System.out.println("String: " + username + " is invalid");
			}
		}
	}
}