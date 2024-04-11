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
}
