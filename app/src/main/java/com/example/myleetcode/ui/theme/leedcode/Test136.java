package com.example.myleetcode.ui.theme.leedcode;

// 136. 只出现一次的数字

/**
 * 任何数和 0 做异或运算，结果仍然是原来的数，即 a⊕0=a。
 * 任何数和其自身做异或运算，结果是 0，即 a⊕a=0。
 * 异或运算满足交换律和结合律，即 a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。
 * 与&    或｜   异或^   非～
 */
public class Test136 {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
