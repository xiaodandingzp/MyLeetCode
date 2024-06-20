package com.example.myleetcode.ui.theme.leedcode;


//48. 旋转图像
public class Test48 {
    public void rotate(int[][] matrix) {
        if (matrix.length < 1 && matrix.length != matrix[0].length) return;
        int size = matrix.length;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - j - 1][size - i - 1];
                matrix[size - j - 1][size - i - 1] = temp;
            }
        }

        for (int i = 0; i < size / 2; i++) {
            for (int j = 0; j < size; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[size - i - 1][j];
                matrix[size - i - 1][j] = temp;
            }
        }
    }
}
