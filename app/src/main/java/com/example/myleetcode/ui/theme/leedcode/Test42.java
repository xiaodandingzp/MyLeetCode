package com.example.myleetcode.ui.theme.leedcode;

import java.util.Stack;

// 接雨水
public class Test42 {

//    单调栈
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
                int height = Math.min(heights[left] - heights[top], heights[i] - heights[top]);
                maxResult += height * width;
            }
            stack.push(i);
        }
        return maxResult;
    }


    public int trap1(int[] heights) {
        if (heights.length < 1) return 0;
        int maxResult = 0;
        int[] leftMax = new int[heights.length];
        leftMax[0] = heights[0];
        for (int i = 1; i < heights.length; i++) {
            leftMax[i] = Math.max(heights[i], leftMax[i - 1]);
        }
        int[] rightMax = new int[heights.length];
        rightMax[heights.length - 1] = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(heights[i], rightMax[i + 1]);
        }

        for (int i = 0; i < heights.length; i++) {
            maxResult += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }
        return maxResult;
    }
}
