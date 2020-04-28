package com.java.iq.core.strings;

public class LongPressedName {

    public static void main(String[] args) {
        System.out.println("6. " + isLongPressedName("srikar", "srikar")); // true
        System.out.println("7. " + isLongPressedName("alex", "aleex")); // true
        System.out.println("8. " + isLongPressedName("alex", "aalex")); // true
        System.out.println("9. " + isLongPressedName("alex", "alexx")); // true
        System.out.println("10. " + isLongPressedName("alex", "aalleexx")); // true
        System.out.println("11. " + isLongPressedName("alex", "a"));// false
        System.out.println("12. " + isLongPressedName("a", "alex")); // false
        System.out.println("13. " + isLongPressedName("saeed", "saaedd"));// false
        System.out.println("14. " + isLongPressedName("saded", "sad")); // false
        System.out.println("15. " + isLongPressedName("s", "ss")); // true
        System.out.println("16. " + isLongPressedName("s", "sos")); // false
        System.out.println("17. " + isLongPressedName("ss", "s")); //false
        System.out.println("18. " + isLongPressedName(null, null)); // false
        System.out.println("19. " + isLongPressedName(null, "srikar")); // false
        System.out.println("20. " + isLongPressedName("srikar", "")); // false
        System.out.println("21. " + isLongPressedName("", "srikar")); // false
    }

    public static boolean isLongPressedName(String name, String typed) {

        if (name == null || typed == null) {
            return false;
        }

        if (name.length() == 0) {
            return typed.length() == 0;
        }

        int i = 0;
        int j = 0;

        while (i < name.length() && j < typed.length()) {

            char nChar = name.charAt(i);
            char tyChar = typed.charAt(j);
            if (tyChar == nChar) {
                i++;
                j++;
            } else {
                if (i == 0 || tyChar != name.charAt(i - 1)) {
                    return false;
                } else {
                    j++;
                }
            }

        }

        char nameEndChar = name.charAt(name.length() - 1);

        while (j < typed.length()) {
            if (typed.charAt(j) != nameEndChar) {
                return false;
            }

            j++;
        }

        return i == name.length() && j == typed.length();
    }
}
