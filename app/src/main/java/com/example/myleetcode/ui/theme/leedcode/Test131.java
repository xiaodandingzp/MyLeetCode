package com.example.myleetcode.ui.theme.leedcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 131. 分割回文串
public class Test131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int size = s.length();
        if (size == 0) return result;
        partitionHelp(s, result, new LinkedList<>(), 0);
        return  result;
    }

    private void partitionHelp(String s, List<List<String>> result, LinkedList<String> list, int index) {
        if (index == s.length()) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = index + 1; i < s.length(); i++) {
            String temps = s.substring(index, i);
            if (isPar(temps)) {
                list.addLast(temps);
                partitionHelp(s, result, list, i);
                list.removeLast();
            }
        }
    }

    private boolean isPar(String s) {
        int star = 0;
        int end = s.length();
        while (star < end) {
            if (s.charAt(star) != s.charAt(end)) {
                return false;
            }
            star++;
            end--;
        }
        return true;
    }
}
