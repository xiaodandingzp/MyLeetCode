package com.example.myleetcode.ui.theme.leedcode;

import java.util.ArrayDeque;

// 外观数列
public class Test38 {

    public static String get(int n) {
        if (n == 1) return "1";
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        for (int i = 2; i <= n; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int temp = queue.pop();
                int count = 1;
                while (j < size - 1 && !queue.isEmpty() && queue.peek() == temp) {
                    queue.pop();
                    j++;
                    count++;
                }
                queue.add(count);
                queue.add(temp);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            result.append(queue.pop());
        }
        return result.toString();
    }
}
