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


    // 基数排序
//    如果有负数 要单独处理
    private void jishuSort(int [] nums) {
        int size = nums.length;
        if (size <= 1) return;
        int maxNum = nums[0];
        for (int i = 1; i < size; i++) {
            maxNum = Math.max(maxNum, nums[i]);
        }
        int count = (maxNum + "").length();

        int temp = 10;
        int[][] duck = new int[10][size];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < size; j++) {
                int position = nums[j] % temp / (temp / 10);
                duck[position][j] = nums[j];
            }
            int index = 0;
            for (int p = 0; p < 10; p++) {
                for (int j = 0; j < size; j++) {
                    if (duck[p][j] > 0) {
                        nums[index++] = duck[p][j];
                        duck[p][j] = 0;
                    }
                }
            }
            temp = temp * 10;
        }
    }
}
