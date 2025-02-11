package com.example.myleetcode.ui.theme.leedcode;

import java.util.ArrayDeque;

public class MinStack {
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    int min = -1;

    public int pop() {
        int dif = stack.pop();
        if (dif < 0) {
            min = min - dif;
            return min;
        }
        return min + dif;
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(0);
            min = value;
        } else {
            int dif = value - min;
            stack.push(dif);
            if (dif < 0) {
                min = value;
            }
        }
    }

    public int getMin() {
        return min;
    }
}
