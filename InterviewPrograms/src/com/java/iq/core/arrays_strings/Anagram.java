package com.java.iq.core.arrays_strings;

/**
 * JAVA program to find the anagram. Sid is obsessed with reading short stories.
 * Being a CS student, he is doing some interesting frequency analysis with the
 * books. He chooses strings S1 and S2 in such a way that |len(S1)-len(S2)|<=1.
 * 
 * Your task is to help him find the minimum number of characters of the first
 * string he needs to change to enable him to make it an anagram of the second
 * string. Note: A word x is an anagram of another word y if we can produce y by
 * rearranging the letters of x.
 * 
 * @author SrikarRao
 *
 */
public class Anagram {

	public static void main(String[] args) {
		System.out.println(findNumOfAnagramChanges("gqdvlchavotcykafyjzbbgmnlajiqlnwctrnvznspiwquxxsiwuldizqkkaawpyyisnftdzklwagv"));
	}

	public static int findNumOfAnagramChanges(String S) {

		char[] S1 = S.substring(0, S.length() / 2).toCharArray();
		String S2 = S.substring(S.length() / 2, S.length());

		if (S1.length != S2.length()) {
			return -1;
		}
		int[] characters = new int[26];
		for (int i = 0; i < S2.length(); i++) {
			characters[S2.charAt(i) - 'a']++;
		}

		int count = 0;
		for (int i = 0; i < S1.length; i++) {
			if (characters[S1[i] - 'a'] > 0) {
				characters[S1[i] - 'a']--;
			} else {
				count++;
			}
		}
		return count;
	}
}
