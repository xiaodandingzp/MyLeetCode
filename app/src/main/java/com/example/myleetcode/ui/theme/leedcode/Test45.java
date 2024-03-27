package com.example.myleetcode.ui.theme.leedcode;

public class Test45 {

    int jump(int[] array) {
        int[] result = new int[1];
        result[0] = array.length;
        help(array, 0, 0, result);
        return result[0];
    }

    void help(int[] array, int index, int count, int[] minCount) {
        if (index >= array.length - 1) {
            minCount[0] = Math.min(count, minCount[0]);
        } else {
            int temp = array[index];
            for (int i = 1; i <= temp; i++) {
                help(array, index + i, count + 1, minCount);
            }
        }
    }


    public int jump1(int[] arrays) {
        int minCount = arrays.length;
        int maxStep = 0;
        int end = 0;
        for (int i = 0; i < arrays.length; i++) {
            maxStep = Math.max(maxStep, i + arrays[i]);
            if (i == end) {
                end = maxStep;
                minCount++;
            }
        }
        return minCount;
    }
}
