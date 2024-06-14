package com.example.myleetcode.ui.theme.leedcode;

import java.util.Arrays;

public class Test16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sumTemp = nums[start] + nums[end] + nums[i];
                if (Math.abs(target - result) > Math.abs(target - sumTemp)) {
                    result = sumTemp;
                }
                if (sumTemp > target) {
                    end--;
                } else start++;
            }
        }
        return result;
    }
}
