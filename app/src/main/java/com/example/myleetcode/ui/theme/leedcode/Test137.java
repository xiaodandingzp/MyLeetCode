package com.example.myleetcode.ui.theme.leedcode;

//  137. 只出现一次的数字 II
public class Test137 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int temp = 0;
            for (int num : nums) {
                temp = (temp + (num >> i & 1)) % 3;
            }
            result |= temp << i;
        }
        return  result;
    }
}
