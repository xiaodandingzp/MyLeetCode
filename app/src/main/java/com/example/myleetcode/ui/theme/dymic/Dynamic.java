package com.example.myleetcode.ui.theme.dymic;

public class Dynamic {
    public int minCost(int[][] cost) {
        if (cost.length < 1) return 0;
        int result;
        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][1] = cost[0][i];
        }
        for (int i = 1; i < cost.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i % 2][j] = Math.min(dp[i % 2][(j + 1) % 3], dp[(i - 1) % 2][(j + 2) % 3]) + cost[(i - 1)][j];
            }
        }
        int last = (cost.length - 1) % 2;
        result = Math.min(dp[last][0], Math.min(dp[last][1], dp[last][2]));
        return result;
    }


//    回文串 最少分割次数
    public int minCut(String s) {
        int length = s.length();
        if (length <= 1) return length;
        boolean[][] isH = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 >= i || isH[j + 1][i - 1])) {
                    isH[j][i] = true;
                }
            }
        }

        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            if (isH[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 1;
                for (int j = 0; j < i; j++) {
                    if (isH[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[length - 1];
    }

    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[i + 1][0] = 1;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }

        return dp[s.length()][t.length()];
    }


    public int numDistinct1(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[] dp = new int[t.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            dp[0] = 1;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }
}
