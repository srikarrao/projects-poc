package com.core.java.api.guava;

import com.google.common.base.CharMatcher;

public class CharMatcherTester {
	public static void main(String args[]) {
		CharMatcherTester tester = new CharMatcherTester();
		tester.testCharMatcher();
	}

	private void testCharMatcher() {
		System.out.println(CharMatcher.DIGIT.retainFrom("srikar1221")); // only
																		// the
																		// digits
		System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom(
				"     Srikar     Rao ", ' '));

		// trim whitespace at ends, and replace/collapse whitespace into single
		// spaces
		System.out.println(CharMatcher.JAVA_DIGIT
				.replaceFrom("srikar1221", "*")); // star
													// out
													// all
													// digits
		System.out.println(CharMatcher.JAVA_DIGIT.or(
				CharMatcher.JAVA_LOWER_CASE).retainFrom("Gsrikar1221"));

		// eliminate all characters that aren't digits or lowercase
	}
}