package com.java.iq.core.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KDistinctCharacterSubstrings {
    public static void main(String[] args) {
        System.out.println(KDistinctCharacterSubstrings("pqpqs", 2));
        System.out.println(SubstringWithKuniqueCountChars("pqpqs", 2));
    }

    public static int KDistinctCharacterSubstrings(String string, int k) {

        int result = 0;
        int length = string.length();

        int characterCount[] = new int[26];
        for (int i = 0; i < length; i++) {
            int uniqueCount = 0;

            Arrays.fill(characterCount, 0);

            for (int j = i; j < length && uniqueCount <= k; j++) {
                if (characterCount[string.charAt(j) - 'a'] == 0) {
                    uniqueCount++;
                }

                characterCount[string.charAt(j) - 'a']++;

                if (uniqueCount == k) {
                    result++;
                }
            }
        }

        return result;
    }

    public static int SubstringWithKuniqueCountChars(String s, int K) {
        char[] charArray = s.toCharArray();
        int left = 0, right = 0;
        Map<Character, Integer> characterCount = new HashMap<>();
        int uniqueCount = 0;
        int result = 0;
        int prefix = 0;

        while (right < charArray.length) {
            if (!characterCount.containsKey(charArray[right])) {
                characterCount.put(charArray[right], 0);
                uniqueCount++;
            }

            characterCount.put(charArray[right], characterCount.get(charArray[right]) + 1);

            if (uniqueCount > K) {
                characterCount.put(charArray[left], characterCount.get(charArray[left]) - 1);
                prefix = 0;
                uniqueCount--;
                left++;
            }

            while (characterCount.get(charArray[left]) > 1) {
                characterCount.put(charArray[left], characterCount.get(charArray[left]) - 1);
                left++;
                prefix++;
            }

            if (uniqueCount == K) {
                result += 1 + prefix;
            }

            right++;
        }
        return result;
    }
}
