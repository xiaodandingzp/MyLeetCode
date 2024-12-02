package com.example.myleetcode.ui.theme.leedcode;

import java.util.HashSet;
import java.util.Set;

// 128. 最长连续序列
public class Test128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int result = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int numTemp = num;
                int numLength = 1;
                while (set.contains(numTemp + 1)) {
                    numTemp = numTemp + 1;
                    numLength = numLength + 1;
                }
                result = Math.max(result, numLength);
            }
        }
        return result;
    }
}
