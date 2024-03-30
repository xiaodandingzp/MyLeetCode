package com.example.myleetcode.ui.theme.leedcode;

public class Test70 {
    public int climbStairs(int n) {
        int first = 0;
        int second = 0;
        int three = 1;
        for (int i = 1; i <= n; i++) {
            first = second;
            second = three;
            three = first + second;
        }
        return three;
    }
}
