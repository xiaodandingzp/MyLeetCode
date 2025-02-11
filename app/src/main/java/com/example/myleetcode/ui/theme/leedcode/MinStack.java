package com.example.myleetcode.ui.theme.leedcode;

import java.util.ArrayDeque;


//155. 最小栈
public class MinStack {
    ArrayDeque<Long> stack = new ArrayDeque<>();
    long min = -1;

    public void pop() {
        long dif = stack.pop();
        if (dif < 0) {
            min = min - dif;
        }
    }

    public int top() {
        if (stack.peek() < 0) {
            return (int)min;
        } else return (int)(min + stack.peek());
    }

    public void push(int value) {
        if (stack.isEmpty()) {
            stack.push(0l);
            min = value;
        } else {
            long dif = value - min;
            stack.push(dif);
            if (dif < 0) {
                min = value;
            }
        }
    }

    public int getMin() {
        return (int)min;
    }
}
