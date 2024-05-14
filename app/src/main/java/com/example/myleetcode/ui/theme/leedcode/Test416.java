package com.example.myleetcode.ui.theme.leedcode;

import java.util.Arrays;

//416. 分割等和子集
public class Test416 {
//     1,2,5
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -target);
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i -1]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i - 1]] + 1);
            }
        }
        return dp[target] > 0;
    }

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = target; j >= nums[i -1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i -1]];
            }
        }
        return dp[target];
    }
}
