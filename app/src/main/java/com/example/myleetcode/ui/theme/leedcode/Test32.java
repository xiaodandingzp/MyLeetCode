package com.example.myleetcode.ui.theme.leedcode;


import java.util.Stack;

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


    public int longestValidParentheses1(String s) {
        int result = 0;
        Stack<Integer> temp = new Stack();
        temp.add(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                temp.add(i);
            } else {
                temp.pop();
                if (temp.isEmpty()) {
                    temp.add(i);
                } else {
                    result = Math.max(result, i - temp.peek());
                }
            }
        }
        return result;
    }


//    动态规划
    public int longestValidParentheses3(String s) {
        int max = 0;
        s = " " + s;
        int dp[] = new int[s.length()];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }


//    动态规划 --自己写一遍
    public int longestValidParentheses4(String s) {
        int result = 0;
        s = " " + s;
        int[] dp = new int[s.length()];
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2] + 2;
                } else if (s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
