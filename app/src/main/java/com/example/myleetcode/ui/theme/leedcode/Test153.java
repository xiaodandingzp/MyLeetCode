package com.example.myleetcode.ui.theme.leedcode;

// 153. 寻找旋转排序数组中的最小值
public class Test153 {
    public int findMin(int[] nums) {
        return findMinHelp(nums, 0, nums.length - 1);
    }

    public int findMinHelp(int[] nums, int star, int end) {
        if (star >= end) return nums[star];
        int mid = (star + end) / 2;
        if (nums[star] > nums[mid] && nums[end] > nums[mid]) {
            return findMinHelp(nums, star + 1, mid);
        } else if (nums[star] < nums[mid] && nums[end] < nums[mid]) {
            return findMinHelp(nums, star, mid - 1);
        }
        else return findMinHelp(nums, mid + 1, end);
    }
}
