package com.example.myleetcode.ui.theme.leedcode;


// 152. 乘积最大子数组
public class Test152 {
    public int maxProduct(int[] nums) {
        int size = nums.length;
        if (size == 1) return nums[0];
        int result = Integer.MIN_VALUE;
        int[][] dp = new int[size][size];
        for (int i = 0; i < size; i++) {
            dp[i][i] = nums[i];
            result = Math.max(dp[i][i], result);
            for (int j = i + 1; j < size; j++) {
                dp[i][j] = dp[i][j - 1] * nums[j];
                result = Math.max(dp[i][j], result);
            }
        }
        return result;
    }

    public int maxProduct1(int[] nums) {
        int size = nums.length;
        int[] dpMax = new int[size];
        int[] dpMin = new int[size];
        dpMin[0] = nums[0];
        dpMax[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < size; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            if (dpMin[i] < (-1 << 31)) {
                dpMin[i] = nums[i];
            }
            result = Math.max(dpMax[i], result);
        }
        return result;
    }

}
