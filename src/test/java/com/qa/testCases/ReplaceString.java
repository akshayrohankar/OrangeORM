package com.qa.testCases;

public class ReplaceString {
    public static void main(String[] args) {
        String s = "abc123";
        System.out.println(convert(s));
    }

    public static String convert(String s) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122) {
                builder.append(Integer.valueOf(s.charAt(i)) - 97);
            } else {
                builder.append(convertToWord(s.charAt(i)));
            }
        }
        return builder.toString();
    }

    public static String convertToWord(char c) {
        String s = null;
        switch (c) {
        case '0':
            s = "zero";
            break;
        case '1':
            s = "one";
            break;
        case '2':
            s = "two";
            break;
        case '3':
            s = "three";
            break;
        case '4':
            s = "four";
            break;
        case '5':
            s = "five";
            break;
        case '6':
            s = "six";
            break;
        case '7':
            s = "seven";
            break;
        case '8':
            s = "eight";
            break;
        case '9':
            s = "nine";
            break;
        }
        return s;
    }
}
