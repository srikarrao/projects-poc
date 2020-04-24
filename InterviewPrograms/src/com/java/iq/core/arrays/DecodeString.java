package com.java.iq.core.arrays;

public class DecodeString {

    public static void main(String[] args) {
        System.out.println(decode("3[ab]10[cd]ef"));
        System.out.println(decode("3[ab][cd]"));
        System.out.println(decode("[ab]10[cd]ef"));
        System.out.println(decode("[ab]10[cd]"));
        System.out.println(decode("[ab][cd]"));
        System.out.println(decode("abcdef"));
        System.out.println(decode("[abcdef]"));
        System.out.println(decode("3[abcdef]"));
        System.out.println(decode("10[ab]"));
        System.out.println(decode("[ab]10"));
        System.out.println(decode("2[23]3[?*]"));
        System.out.println(decode("ef1[ab]xy1[d]"));
        System.out.println(decode("1ef[ab]1xy[d]"));
        System.out.println(decode("ef10[ab]xy10[d]"));
        System.out.println(decode("10ef[ab]10xy[d]"));
        System.out.println(decode("2[a] [b]"));
        System.out.println(decode("2[a]0[b]"));
        System.out.println(decode("2[]"));
        System.out.println(decode("2[[a]"));
        System.out.println(decode("[[a]"));
        System.out.println(decode("2[a]]"));
    }

    private static String decode(String word) {

        int leftBracketCount = 0;
        StringBuilder result = new StringBuilder();
        int start = 0;
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (c == '[') {
                if (count != 0 || leftBracketCount == 1) {
                    return "Invalid";
                }
                leftBracketCount++;
                String subStr = word.substring(start, i);
                count = getCountAndAddResult(subStr, result);

                if (count == 0) {
                    result.append(subStr);
                }
                start = i + 1;
            } else {
                if (c == ']') {
                    String subStr = word.substring(start, i);

                    if (count != -1) {
                        addToResult(count, subStr, result);
                    }
                    count = 0;
                    start = i + 1;
                }
                leftBracketCount--;
            }
        }

        if (start < word.length()) {
            result.append(word.substring(start));
        }

        return result.toString();
    }

    private static int getCountAndAddResult(String subStr, StringBuilder sb) {
        boolean hasDigitComputed = false;
        if (subStr.length() == 0) {
            return 0;
        }

        int count = 0;
        int i = 0;

        if (Character.isDigit(subStr.charAt(0))) {
            hasDigitComputed = true;
            while (i < subStr.length() && Character.isDigit(subStr.charAt(i))) {
                count = count * 10 + subStr.charAt(i) - '0';
                i++;
            }
            if (i < subStr.length()) {
                sb.append(subStr.substring(i));
            }
        } else {
            while (i < subStr.length() && !Character.isDigit(subStr.charAt(i))) {
                i++;
            }

            if (i < subStr.length()) {
                sb.append(subStr.substring(0, i));
            }

            while (i < subStr.length() && Character.isDigit(subStr.charAt(i))) {
                count = count * 10 + subStr.charAt(i) - '0';
                i++;
            }
        }

        return count == 0 && hasDigitComputed ? -1 : count;
    }

    private static void addToResult(int count, String str, StringBuilder sb) {
        if (count == 0) {
            sb.append(str);
        } else {
            while (count-- > 0) {
                sb.append(str);
            }
        }
    }
}

