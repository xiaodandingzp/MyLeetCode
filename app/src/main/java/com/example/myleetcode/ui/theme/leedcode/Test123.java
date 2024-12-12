package com.example.myleetcode.ui.theme.leedcode;


//    123. 买卖股票的最佳时机 III
public class Test123 {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        dp[0][0] = -prices[0]; // buy1
        dp[0][1] = 0;   // sell1
        dp[0][2] = -prices[0];  // buy2
        dp[0][3] = 0;    // sell2
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i -1][0], -prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] + prices[i], dp[i -1][1]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] - prices[i]);
            dp[i][3] = Math.max(dp[i - 1][2] + prices[i], dp[i -1][3]);
        }
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result = Math.max(result, dp[prices.length - 1][i]);
        }
        return result;
    }
}
