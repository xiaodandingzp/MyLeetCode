package com.example.myleetcode.ui.theme.leedcode;

//172. 阶乘后的零
public class Test172 {
    public int trailingZeroes(int n) {
        int ans = 0;
        for (int i =5; i <= n; i = i + 5) {
            for (int j = i; j % 5 == 0; j = j /5) {
                ++ans;
            }
        }
        return ans;
    }

    public int trailingZeroes1(int n) {
        int ans = 0;
        while (n > 0) {
            n = n / 5;
            ans += n;
        }
        return ans;
    }
}
