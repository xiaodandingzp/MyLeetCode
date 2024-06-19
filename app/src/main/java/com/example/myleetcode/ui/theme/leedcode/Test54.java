package com.example.myleetcode.ui.theme.leedcode;

import java.util.ArrayList;
import java.util.List;


// 螺旋矩阵: 顺时针螺旋顺序
public class Test54 {
    public List<Integer> spiralOrder(int[][] array) {
        int left = 0;
        int right = array[0].length - 1;
        int top = 0;
        int bottom = array.length - 1;
        ArrayList result = new ArrayList();
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result.add(array[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(array[i][right]);
            }
            right--;
            for (int i = right; i >= left && top <= bottom; i--) {
                result.add(array[bottom][i]);
            }
            bottom--;
            for (int i = bottom; i >= top && right >= left; i--) {
                result.add(array[i][left]);
            }
            left++;
        }
        return result;
    }
}
