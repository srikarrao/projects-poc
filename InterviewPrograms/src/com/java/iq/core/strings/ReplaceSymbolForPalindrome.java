package com.java.iq.core.strings;

public class ReplaceSymbolForPalindrome {

    public static void main(String[] args) {
        System.out.println(new ReplaceSymbolForPalindrome().solution("?ab??a"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("bab??a"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("?a?"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("???"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("??"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("?"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("??a"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("a??"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("aba"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("aaa"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("abc"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("ca?ac"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("cba?ac"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("cba??abc"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("cba?abc"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("cba???abc"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("??????a"));
        System.out.println(new ReplaceSymbolForPalindrome().solution("a??????"));
    }

    public String solution(String S) {
        if (S.length() == 0) {
            return "NO";
        } else if (S.length() == 1) {
            return S.replace('?', 'a');
        }

        return findPalindrome(S.toCharArray());
    }

    private String findPalindrome(char[] arr) {
        int i = 0;
        int j = arr.length - 1;

        //?ab??a --> aabbaa
        //bab??a
        //?a?
        // ???
        // a??
        // ??a
        //aba
        //abc
        //ca?ac
        // ca??ac
        // cba?ac
        while (i < j) {

            char x = arr[i];
            char y = arr[j];

            if (x != '?' && y != '?') {
                if (x != y) {
                    return "NO";
                }

                i++;
                j--;
            } else {
                if (x == '?' && y == '?') {
                    arr[i] = 'a';
                    arr[j] = 'a';
                } else if (x == '?' && y != '?') {
                    arr[i] = y;
                } else {
                    arr[j] = x;
                }

                i++;
                j--;

            }

        }

        if (i < arr.length && arr[i] == '?') {
            arr[i] = 'a';
        }

        return new String(arr);
    }
}
