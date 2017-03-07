package com.java.iq.core.companies.amazon;

public class SortAString {

	public static String sortAString_method3(String S) {

		char[] sortedArray = S.toCharArray();
		int smaller = 0;
		int equal = 0;
		int larger = sortedArray.length;
		int pivot = 32;

		while (equal < larger) {
			if (isSmaller((sortedArray[equal]), pivot)) {
				swap(sortedArray, smaller++, equal++);
			} else if (isEqual((sortedArray[equal]), pivot)) {
				++equal;
			} else {
				swap(sortedArray, equal, --larger);
			}
		}
		return new String(sortedArray);
	}

	private static void swap(char[] A, int x, int y) {
		char temp = A[x];
		A[x] = A[y];
		A[y] = temp;
	}

	private static boolean isSmaller(int x, int y) {
		if ((x >= 97 && x <= 122) && y == 32) {
			return true;
		}
		return false;
	}

	private static boolean isEqual(int x, int y) {
		if ((x == 32) && y == 32) {
			return true;
		}
		return false;
	}

	public static String sortAString_method2(String S) {

		char[] sortedString = new char[S.length()];
		int lower = 0;
		int spaces = 0;

		for (int i = 0; i < S.length(); i++) {
			int ascii = (int) S.charAt(i);
			if (ascii >= 97 && ascii <= 122) {
				lower++;
			} else if (ascii == 32) {
				spaces++;
			}
		}

		int x = 0;
		int a = 0;
		int b = 0;
		int c = 0;
		while (x < sortedString.length) {
			int ascii = S.charAt(x);
			if (ascii >= 97 && ascii <= 122) {
				sortedString[a++] = (char) ascii;
			} else if (ascii == 32) {
				sortedString[lower + b] = (char) ascii;
				b++;
			} else if (ascii >= 65 && ascii <= 90) {
				sortedString[lower + spaces + c] = (char) ascii;
				c++;
			}
			x++;
		}

		return new String(sortedString);
	}

	public static String sortAString_method1(String S) {

		char[] sortedString = new char[S.length()];

		int i = 0;
		int j = 0;
		while (j < S.length()) {
			int x = (int) S.charAt(j);
			if (x >= 97 && x <= 122) {
				sortedString[i] = (char) x;
				i++;
			}
			j++;
		}

		j = 0;
		while (j < S.length()) {
			int x = (int) S.charAt(j);
			if (x == 32) {
				sortedString[i] = (char) x;
				i++;
			}
			j++;
		}

		j = 0;
		while (j < S.length()) {
			int x = (int) S.charAt(j);
			if (x >= 65 && x <= 90) {
				sortedString[i] = (char) x;
				i++;
			}
			j++;
		}
		return new String(sortedString);
	}

	public static void main(String[] args) {

		System.out.println(sortAString_method1("a cBd LkmY"));
		System.out.println(sortAString_method2("a cBd LkmY"));
		System.out.println(sortAString_method3("a CBd Lkm Y"));

	}
}
