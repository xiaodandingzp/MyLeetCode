package com.example.myleetcode.ui.theme.leedcode;

public class Test43 {
    static String MulitTwo(String s1, String s2) {
        int size = s1.length() + s2.length();
        int[] tempArray = new int[size];
        for (int i = s2.length() - 1; i >= 0; i--) {
            int first = s2.charAt(i) - '0';
            int jin = 0;
            for (int j = s1.length() - 1; j >= 0; j--) {
                int second = s1.charAt(j) - '0';
                int value = (first * second + jin) % 10;
                jin = (first * second + jin) / 10;
                help(tempArray, value, size - i - j -2);
            }
            help(tempArray, jin, size - i -1);
        }
        StringBuilder result = new StringBuilder();
        boolean isStartZero = false;
        for (int i = size - 1; i >= 0; i--) {
            if (tempArray[i] == 0 && !isStartZero) continue;
            isStartZero = true;
            result.append(tempArray[i]);
        }
        return isStartZero ? result.toString() : "0";
    }

    static void help(int[] array, int value, int index) {
        int temp = array[index];
        array[index] = (temp + value) % 10;
        if (index + 1 < array.length) {
            array[index + 1] += (temp + value) / 10;
        }
    }
}
