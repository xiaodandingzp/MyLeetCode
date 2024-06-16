package com.example.myleetcode.ui.theme.sort;

import java.util.Random;

public class Sort {
    private void sort(int [] nums) {
        sortHelp(nums, 0, nums.length - 1);
    }

    private void sortHelp(int[] nums, int start, int end) {
        if (start >= end) return;
        int tempIndex = findIndexRand(nums, start, end);
        sortHelp(nums, start, tempIndex);
        sortHelp(nums, tempIndex + 1, end);
    }

    private int findIndexRand(int[] nums, int start, int end){
        int index = new Random().nextInt(end - start + 1) + start;
        swap(nums, index, end);
        int small = start - 1;
        for (int i = start; i < end; ++i) {
            if (nums[i] < nums[end]) {
                small++;
                swap(nums, small, i);
            }
        }
        small++;
        swap(nums, small, end);
        return small;
    }

    private void swap(int[] nums, int pre, int des) {
        int temp = nums[des];
        nums[des] = nums[pre];
        nums[pre] = temp;
    }
}
