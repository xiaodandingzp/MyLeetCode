package com.example.myleetcode.ui.theme.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class App {

//    排序：合并区间 时间复杂度：O(nlogn)
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> merge = new LinkedList<>();
        int i = 0;
        while (i < intervals.length) {
            int[] temp = new int[] {intervals[i][0], intervals[i][1]};
            int j = i + 1;
            while (j < intervals.length && intervals[j][0] > temp[0] && intervals[j][0] <= temp[1]) {
                temp[1] = Math.max(intervals[j][1], temp[1]);
                j++;
            }
            merge.add(temp);
            i = j;
        }
        int[][] result = new int[merge.size()][];
        return merge.toArray(result);
    }
}
