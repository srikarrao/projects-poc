/*package com.java.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Java8MethodRef {

	public static void main(String args[]) {

		final Consumer<String> x = new Consumer<String>() {
			@Override
			public void accept(String x) {
				if (x != "M") {
					System.out.println(x);
				}
			}
		};

		List<String> names = new ArrayList<String>();

		names.add("M");
		names.add("S");
		names.add("R");
		names.add("V");
		names.add("K");
		names.forEach(x);

	}
}
*/