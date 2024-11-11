package com.example.myleetcode.ui.theme.leedcode;



// 931. 下降路径最小和
public class Test931 {
    public int minFallingPathSum(int[][] matrix) {
        int [][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i][j]);
                }
                if (j < matrix[0].length - 1) {
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i][j]);
                }
                dp[i][j] += matrix[i][j];
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            result = Math.min(result, dp[matrix.length - 1][i]);
        }
        return result;
    }
}
