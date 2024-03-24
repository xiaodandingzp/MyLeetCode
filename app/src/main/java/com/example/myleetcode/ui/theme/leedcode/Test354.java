package com.example.myleetcode.ui.theme.leedcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o2[1] - o1[1];
            }
        });

        List<Integer> f = new ArrayList<Integer>();
        f.add(envelopes[0][1]);
        for (int i = 1; i < n; ++i) {
            int num = envelopes[i][1];
            if (num > f.get(f.size() - 1)) {
                f.add(num);
            } else {
                int index = help(f, num);
                f.set(index, num);
            }
        }
        return f.size();
    }

    private int help(List<Integer> f, int target) {
        int left = 0;
        int right = f.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (f.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }


    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes.length <= 1) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o2[0] - o1[0];
            }
        });
        int[] f = new int[envelopes.length];
        int maxResult = 1;
        Arrays.fill(f, 1);
        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            maxResult = Math.max(maxResult, f[i]);
        }
        return maxResult;
    }














}
