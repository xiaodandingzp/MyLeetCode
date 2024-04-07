package com.example.myleetcode.ui.theme.leedcode;

import java.util.Arrays;

public class Test55 {

    boolean test(int[] nums) {
        int length = nums.length;
        if (length == 1) return true;
        int[] dp = new int[length];
        if (nums[0] > 0) {
            dp[0] = 1;
        }
        for (int i = 0; i < length; i++) {
            if (dp[i] == 1) {
                if (i + nums[i] + 1 >= length) return true;
                Arrays.fill(dp, i, i + nums[i] + 1, 1);
            }
        }
        return dp[length] == 1;
     }

    boolean test1(int[] nums) {
        int length = nums.length;
        if (length == 1) return true;
        int maxIndex = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            maxIndex = Math.max(i + nums[i], maxIndex);
            if (i == end) {
                end = maxIndex;
                if (maxIndex >= length) return true;
            }
        }
        return end >= length - 1;
    }
}
