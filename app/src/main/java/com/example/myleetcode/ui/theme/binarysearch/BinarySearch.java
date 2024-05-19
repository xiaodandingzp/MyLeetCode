package com.example.myleetcode.ui.theme.binarysearch;

public class BinarySearch {
    public int searchPos(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] >= target) {
                if (mid == 0 || numbers[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return numbers.length;
    }
}
