package com.example.myleetcode.ui.theme.leedcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 151. 反转字符串中的单词
public class Test151 {
    public String reverseWords(String s) {
        s = s.trim();
        List<String> list = Arrays.asList(s.split(" "));
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
