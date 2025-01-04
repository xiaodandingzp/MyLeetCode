package com.example.myleetcode.ui.theme.leedcode;


// 134. 加油站
public class Test134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int i = 0;
        while (i < length) {
            int j = 0;
            int sum = 0;
            while (j < length) {
                int index = (i + j) % length;
                sum += gas[index] - cost[index];
                if (sum < 0) break;
                j++;
            }
            if (sum >= 0) return i;
            i = i + j + 1;
        }
        return -1;
    }
}
