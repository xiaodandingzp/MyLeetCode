package com.example.myleetcode.ui.theme.leedcode;

//44. 通配符匹配
public class Test44 {
    public boolean isMatch(String s1, String s2) {
        if (s1.length() == 0 && s2.length() == 0) return true;
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) == s2.charAt(index2) || s2.charAt(index2) == '?') {
                index2++;
                index1++;
            } else if (s2.charAt(index2) == '*') {
                if (index2 == s2.length() - 1) return true;
                index2++;
                while (index1 < s1.length()) {
                    if (s1.charAt(index1) == s2.charAt(index2) || s2.charAt(index2) == '?') {
                        if (isMatch(s1.substring(index1), s2.substring(index2))) return true;
                    }
                    index1++;
                }
            } else  {
                return false;
            }
        }
        while (index2 < s2.length() && s2.charAt(index2) == '*') index2++;
        return index1 == s1.length() && index2 == s2.length();
    }

// 动态规划解法
    public boolean isMatch1(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        boolean[][] dp = new boolean[l1 + 1][ l2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <= l2; i++) {
            if (s2.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else break;
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1) || s2.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(s2.charAt(j - 1) == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i -1][j];
                }
            }
        }
        return dp[l1][l2];
    }
}
