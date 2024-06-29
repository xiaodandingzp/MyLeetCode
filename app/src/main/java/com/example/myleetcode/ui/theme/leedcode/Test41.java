package com.example.myleetcode.ui.theme.leedcode;

// 41. 缺失的第一个正数
public class Test41 {
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] <= 0) {
                nums[i] = size + 1;
            }
        }

        for (int i = 0; i < size; i++) {
            int temp = Math.abs(nums[i]);
            if (temp > 0 && temp <= size) {
                nums[temp - 1] = -Math.abs(nums[temp - 1]);
            }
        }

        for (int i = 0; i < size; i ++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return size + 1;
    }
}
