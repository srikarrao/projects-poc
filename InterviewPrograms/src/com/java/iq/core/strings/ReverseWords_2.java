package com.java.iq.core.strings;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * 
 * @author srikarrao
 *
 */
public class ReverseWords_2 {

	public static String reverseWords(String str) {

		if (str == null || str.isEmpty()) {
			return str;
		}
		int start = 0;
		int end = str.length() - 1;
		// trim beginning
		while (start < str.length() && str.charAt(start) == ' ') {
			start++;
		}

		// trim ending
		while (end > start && str.charAt(end) == ' ') {
			end--;
		}

		// convert substring to array
		char[] arr = null;
		if (start < end) {
			arr = str.substring(start, end + 1).toCharArray();
		} else if (start == end) {
			arr = str.substring(start).toCharArray();
		} else {
			arr = new char[] { ' ' };
		}

		start = 0;
		end = arr.length - 1;

		// reverse the char array
		reverse(arr, start, end);

		int i = 0;
		while (i < arr.length && start <= end) {
			if (arr[i] == ' ') {
				reverse(arr, start, i - 1);
				while (i < arr.length - 1 && arr[i] == ' ') {
					i++;
				}
				start = i;
			}
			i++;
		}
		//reverse the last part of string
		reverse(arr, start, arr.length - 1);
		// add clearing spaces and convert to string
		return new String(clearSpaces(arr)).trim();
	}

	private static void reverse(char[] arr, int start, int end) {

		while (start <= end) {
			char temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}

	private static char[] clearSpaces(char[] arr) {
		int start = 1;
		int iter = 1;
		int end = arr.length;
		int foundOneSpace = 0;
		while (start < end) {
			if (arr[start] != ' ') {
				arr[iter++] = arr[start];
				foundOneSpace = 0;
			} else if (foundOneSpace == 0) {
				arr[iter++] = arr[start];
				foundOneSpace++;
			} else {
				foundOneSpace++;
			}
			start++;
		}
		return Arrays.copyOf(arr, iter);
	}

	public static void main(String[] args) {
		System.out.println(reverseWords("a"));
		System.out.println(reverseWords(" "));
		System.out.println(reverseWords("abc"));
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords(" hello world! "));
		System.out.println(reverseWords("a good   expl"));
	}
}