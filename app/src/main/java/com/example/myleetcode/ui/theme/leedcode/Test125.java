package com.example.myleetcode.ui.theme.leedcode;

public class Test125 {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            while (!isVailChar(s.charAt(start)) && start < end) {
                start++;
            }
            while (!isVailChar(s.charAt(end)) && start < end) {
                end--;
            }
            char startC = s.charAt(start);
            char endC = s.charAt(end);
            if (startC >= 'A' && startC <= 'Z') {
                startC = (char) (startC - 'A' + 'a');
            }
            if (endC >= 'A' && endC <= 'Z') {
                endC = (char) (endC - 'A' + 'a');
            }
            if (startC != endC) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isVailChar(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
