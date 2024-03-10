package com.example.myleetcode.ui.theme.leedcode;


public class Test34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[] {-1, -1};
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                result[0] = mid;
                result[1] = mid;
                int temp = mid - 1;
                while (temp >= 0) {
                    if (nums[temp] == target) {
                        result[0] = temp--;
                    } else break;
                }
                temp = mid + 1;
                while (temp < nums.length) {
                    if (nums[temp] == target) {
                        result[1] = temp++;
                    } else break;
                }
                break;
            }
        }
        return result;
    }
}
