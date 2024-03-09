package com.example.myleetcode.ui.theme.leedcode;

import android.util.Log;

public class Test33 {
    public static int findIndex(int[] array, int target) {
        return help(array, target, 0, array.length - 1);
    }

    static int help(int[] array, int target, int start, int end) {
        Log.i("zpppp", "start: " + start + "   end: " + end);
        if (start >= end) return array[start] == target ? start : -1;
        if (array[start] == target) return start;
        if (array[end] == target) return end;
        int mid = (start + end) / 2;
        if (array[mid] == target) return mid;
        else if (array[mid] > target) {
            if (target < array[start] && array[mid] > array[end]) return help(array, target, mid + 1, end);
            return help(array, target, start, mid - 1);
        } else {
            if (array[mid] < array[start] && target > array[end])
                return help(array, target, start, mid - 1);
            return help(array, target, mid + 1, end);
        }
    }
}
