package com.example.myleetcode.ui.theme.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * 给定字符串 s 和字符串数组 words, 返回  words[i] 中是 s 的子序列的单词个数。
 * 字符串的子序列是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是"")，而不改变其余字符的相对顺序。
 * 例如，“ace” 是 “abcde” 的子序列。
 */

public class Test1 {

    public int numMatchingSubseq(String s, String[] words) {
        int ans = 0;
        Map<Character, List<Integer>> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = map.getOrDefault(s.charAt(i), new ArrayList<Integer>());
            list.add(i);
            map.put(s.charAt(i), list);
        }
        for (String word : words) {
            boolean ok = true;
            int index = -1;
            for (int i =0; i < word.length(); i++) {
                Character c = word.charAt(i);
                List<Integer> list = map.get(c);
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = (l + r) /2;
                    if (list.get(mid) > index) {
                        r = mid;
                    } else  l = mid + 1;
                }
                if (r < 0 || list.get(r) <= index) {
                    ok = false;
                    break;
                } else index = list.get(r);
            }
            if (ok) ans +=1;
        }
        return ans;
    }
}
