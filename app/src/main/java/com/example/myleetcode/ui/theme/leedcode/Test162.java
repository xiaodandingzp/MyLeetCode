package com.example.myleetcode.ui.theme.leedcode;

//162. 寻找峰值
public class Test162 {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (mid == 0) {
                if (nums[mid] < nums[mid + 1]) {
                    return mid + 1;
                } else return mid;
            }
            if (mid == nums.length - 1) {
                if (nums[mid - 1] < nums[mid]) {
                    return mid;
                } else return mid - 1;
            }
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid;
            if (nums[mid] < nums[mid - 1]) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
