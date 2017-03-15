package com.java.iq.core.arrays;

import java.util.ArrayList;
import java.util.*;

public class SummaryRanges {

	public static void main(String[] args) {

		for (String s : displayRanges(new int[] { 0, 1, 2, 14, 15, 16, 17 })) {
			System.out.println(s);
		}

	}

	private static List<String> displayRanges(int[] nums) {
		int length = nums.length;

		List<String> result = new ArrayList<String>(length);

		for (int i = 0; i < length; i++) {
			int num = nums[i];

			while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
				i++;
			}

			if (num != nums[i]) {
				result.add(num + "->" + nums[i]);
			} else {
				result.add(num + "");
			}
		}

		return result;

	}

}
