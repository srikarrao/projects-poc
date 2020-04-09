package com.java.iq.core.arrays;

import java.util.*;

public class MissingRanges {

    public static void main(String[] args) {
        printResults(1, findMissingRanges(null, 0, 99)); // 0-99
        printResults(2, findMissingRanges(new int[] { 0, 1 }, 100, 19)); // empty
        printResults(3, findMissingRanges(new int[] {}, 2, 2)); // 2
        printResults(4, findMissingRanges(new int[] { 2 }, 2, 2)); // empty
        printResults(5, findMissingRanges(new int[] { 1, 2, 3, 7, 9 }, 0, 10)); // 0, 4-6, 8, 10
        printResults(6, findMissingRanges(new int[] { 0, 1, 2, 3, 7, 9 }, 0, 10)); // 4-6, 8, 10
        printResults(7, findMissingRanges(new int[] { 1, 2, 3, 7, 9, 10 }, 0, 10)); // 0, 4-6, 8
        printResults(8, findMissingRanges(new int[] { 0, 1, 2 }, 0, 2)); // empty

        printResults(9, findMissingRanges(new int[] { 0, 2 }, 0, 2)); // 1

        printResults(10, findMissingRanges(new int[] { 1, 2 }, 1, 2)); // empty
        printResults(11, findMissingRanges(new int[] {}, 1, 2)); // 1-2

    }

    private static void printResults(int i, List<String> strings) {
        System.out.println("Result for: " + i);
        for (String string : strings) {
            System.out.print(string + " ");
        }
        System.out.println("");
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (lower > upper) {
            return Collections.emptyList();
        }

        /**
         set: add all nums

         iterate i: lower until upper + 1
         if exists i in set then continue
         else inner loop


         inner loop iterate i set exists i until upper + 1

         add range
         **/

        List<String> missingRanges = new ArrayList<>();
        Set<Integer> existNumbers = new HashSet<>();

        if (nums != null) {
            for (int num : nums) {
                existNumbers.add(num);
            }
        }

        int index = lower;
        while (index < upper + 1) {

            if (!existNumbers.contains(index)) {
                int start = index;
                index++;
                while (index < upper + 1 && !existNumbers.contains(index)) {
                    index++;
                }

                addRange(start, index, missingRanges);
            } else {
                index++;
            }

        }

        return missingRanges;
    }

    private static void addRange(int start, int end, List<String> missingRanges) {

        if (start == end - 1) {
            missingRanges.add("" + start);
        } else {
            missingRanges.add(start + "->" + (end - 1));
        }

    }
}
