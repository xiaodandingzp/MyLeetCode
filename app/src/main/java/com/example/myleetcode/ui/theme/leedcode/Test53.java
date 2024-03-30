package com.example.myleetcode.ui.theme.leedcode;

public class Test53 {
    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int maxResult = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp = Math.max(dp + nums[i], nums[i]);
            maxResult = Math.max(maxResult, dp);
        }
        return maxResult;
    }
}
