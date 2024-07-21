package com.example.myleetcode.ui.theme.leedcode;


// 45 跳跃游戏 II
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


    public int jump1(int[] nums) {
        int result = 0;
        int nextMax = 0;
        int curNext = 0;
        for (int i = 0; i < nums.length; i++) {
            nextMax = Math.max(nextMax, i + nums[i]);
            if (i < nums.length - 1 && i == curNext) {
                curNext = nextMax;
                result++;
            }
            String[] rr = new String[44];
            String.join(" ", rr);
        }
        return result;
    }
}
