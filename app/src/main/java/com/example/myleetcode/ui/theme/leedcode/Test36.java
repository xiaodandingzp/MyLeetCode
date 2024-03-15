package com.example.myleetcode.ui.theme.leedcode;


public class Test36 {
    public boolean isValidSudoku() {
        char[][] board = new char[][]{
                new char[]{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                new char[]{'.','.','.','.','.','.','.','.','.'},
                new char[]{'5','.','.','.','.','.','.','9','.'},
        new char[]{'.','.','.','5','6','.','.','.','.'},
        new char[]{'4','.','3','.','.','.','.','.','1'},
        new char[]{'.','.','.','7','.','.','.','.','.'},
        new char[]{'.','.','.','5','.','.','.','.','.'},
        new char[]{'.','.','.','.','.','.','.','.','.'},
        new char[]{'.','.','.','.','.','.','.','.','.'}};
        int[] row = new int[10];
        int[][] col = new int[9][10];
        int[][][] three = new int[3][3][10];
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 10; k++) {
                row[k] = 0;
            }
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int temp = board[i][j] - '0';
                row[temp]++;
                col[j][temp]++;
                three[i / 3][j / 3][temp]++;
                if (row[temp] > 1) return false;
                if (col[j][temp] > 1) return false;
                if (three[i / 3][j / 3][temp] > 1) return false;
            }
        }
        return true;
    }
}
