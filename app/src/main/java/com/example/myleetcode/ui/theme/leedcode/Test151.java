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
//        list转成array
//        Arrays.sort(list.toArray(new String[list.size()]), new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return 0;
//            }
//        });
        return String.join(" ", list);
    }
}
