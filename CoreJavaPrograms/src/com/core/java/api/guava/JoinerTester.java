package com.core.java.api.guava;

import java.util.Arrays;
import com.google.common.base.Joiner;

public class JoinerTester {
	public static void main(String args[]) {
		JoinerTester tester = new JoinerTester();
		tester.testJoiner();
	}

	private void testJoiner() {
		System.out.println(Joiner.on(",").skipNulls()
				.join(Arrays.asList(1, 2, 3, 4, 5, null, 6)));
	}
}