package com.example.myleetcode.ui.theme.leedcode;

public class Test32 {
    public int longestValidParentheses(String s) {
        int result = 0;
        int temp = 0;
        int leftCount = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.length() - j < result) break;
            temp = 0;
            leftCount = 0;
            for (int i = j; i < s.length(); i++) {
                if (leftCount == 0 && temp != 0) {
                    result = Math.max(result, temp);
                }
                if (s.charAt(i) == '(') {
                    leftCount++;
                    temp++;
                }
                if (s.charAt(i) == ')') {
                    if (leftCount > 0) {
                        leftCount--;
                        temp++;
                    } else {
                        result = Math.max(result, temp);
                        break;
                    }
                }
            }
            if (leftCount == 0) {
                result = Math.max(result, temp);
            }
        }
        return result;
    }
}
