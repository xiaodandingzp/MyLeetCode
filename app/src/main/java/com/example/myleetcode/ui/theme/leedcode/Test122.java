package com.example.myleetcode.ui.theme.leedcode;

public class Test122 {
    public int maxProfit(int[] prices) {
        int size = prices.length;
        int[][] dp = new int[size][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < size; i++) {
            dp[i][0] = Math.max(dp[i -1][0], dp[i -1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i -1][0] - prices[i], dp[i -1][1]);
        }
        return Math.max(dp[size - 1][0], dp[size - 1][1]);
    }
}
