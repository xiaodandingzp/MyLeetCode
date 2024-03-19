package com.example.myleetcode.ui.theme.leedcode;

import java.util.Stack;

public class Test42 {

    public int trap(int[] heights) {
        if (heights.length < 1) return 0;
        int maxResult = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(-1);
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] > heights[stack.peek()]) {
                int top = stack.pop();
                int left = stack.peek();
                if (left == -1) break;
                int width = i - left - 1;
                int height = Math.min(heights[left], heights[i] - heights[top]);
                maxResult += height * width;
            }
            stack.push(i);
        }
        return maxResult;
    }
}
