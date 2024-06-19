package com.example.myleetcode.ui.theme.leedcode;


import java.util.Stack;

// 计算"3 + (4 + (3 -2)) + 5" 的值
public class TestZp1 {
    public int complute(String s) {
        Stack<Integer> stack = new Stack<>();
        int type = 0; // 0 没有操作  1 加操作  2 减操作  3 乘操作
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ' ':
                    break;
                case '(':
                    int count = 1;
                    int end = i + 1;
                    while (end < s.length() && count > 0) {
                        if (s.charAt(end) == '(') count++;
                        if (s.charAt(end) == ')') count--;
                        end++;
                    }
                    pushNumber(stack, type, complute(s.substring(i + 1, end - 1)));
                    i = end;
                    break;
                case '+':
                    type = 1;
                    break;
                case '-':
                    type = 2;
                    break;
                case '*':
                    type = 3;
                    break;
                default:
                    if (isNumber(s.charAt(i))) {
                        int number = s.charAt(i) - '0';
                        while (i < s.length() - 1 && isNumber(s.charAt(++i))) {
                            number = number * 10 + s.charAt(i) - '0';
                        }
                        pushNumber(stack, type, number);
                    }
                    break;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }

    private void pushNumber(Stack<Integer> stack, int type, int number) {
        switch (type) {
            case 3:
                if (stack.size() > 0) {
                    int first = stack.pop();
                    stack.push(first * number);
                break;
            }
            case 2:
                stack.push(-number);
                break;
            default:
                stack.push(number);
        }
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
