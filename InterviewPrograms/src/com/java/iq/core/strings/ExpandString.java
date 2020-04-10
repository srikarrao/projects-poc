package com.java.iq.core.strings;

/**
 * Expand String: Replace ? as 'a' or 'b', expand("a?bab") prints [aabab, abbab]
 */
public class ExpandString {

    public static void main(String[] args) {
        executeInput(null);
        executeInput("");
        executeInput("abab"); // abab
        executeInput("???"); // aaa, aab, aba, abb, baa, bab, bba, bbb
        executeInput("?abab"); // aabab, babab
        executeInput("ab?"); // aba, abb
        executeInput("?abab?"); // aababa, aababb, bababa, bababb
        executeInput("a?bab"); // aabab, abbab
        executeInput("a?b"); // aab, abb
        executeInput("a?b?"); // aaba, aabb, abba, abbb
        executeInput("?"); // a, b
        executeInput("?a"); // aa, ba
        executeInput("?a?"); // aaa, aab, baa, bab
        executeInput("a?"); // aa, ab
        executeInput("a??b"); // aaab, aabb, abab, abbb
        executeInput("ab??a?"); // abaaaa,abaaab,ababaa,ababab,abbaaa,abbaab,abbbaa,abbbab
        executeInput(
            "abaaababaaababaaababaaab?abaaababaaab"); // abaaaa,abaaab,ababaa,ababab,abbaaa,abbaab,abbbaa,abbbab
    }

    private static void executeInput(String string) {
        System.out.println("Started pattern: " + string);
        expand(string);
        System.out.println("Ended pattern: " + string + "\n");
    }

    private static void expand(String pattern) {

        if (pattern == null || pattern.length() == 0) {
            return;
        }

        expandHelper(pattern.toCharArray(), 0, new char[] { 'a', 'b' });
    }

    private static void expandHelper(char[] pattern, int index, char[] characters) {

        if (index == pattern.length) {
            System.out.println(new String(pattern));
            return;
        }

        if (pattern[index] == '?') {
            int charIndex = 0;
            while (charIndex < characters.length) {
                pattern[index] = characters[charIndex];
                expandHelper(pattern, index + 1, characters);
                pattern[index] = '?';
                charIndex++;
            }
            index++;
        } else {
            index++;
            expandHelper(pattern, index, characters);
        }
    }
}
