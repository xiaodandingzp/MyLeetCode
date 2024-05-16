package com.example.myleetcode.ui.theme.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Graph {

//    是否是二分图
    public boolean isBipartite(int[][] graph) {
        int size = graph.length;
        int[] colors = new int[size];
        Arrays.fill(colors, -1);
        for (int i = 0; i < size; i++) {
            if (colors[i] == -1) {
                if (!setColors(graph, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    boolean setColors(int[][] graph, int[] colors, int i, int color) {
        colors[i] = color;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        while (!queue.isEmpty()) {
            int t = queue.poll();
            int[] neis = graph[t];
            for (int j = 0; j < neis.length; j++) {
                int nei = neis[j];
                if (colors[nei] >= 0) {
                    if (colors[nei] == colors[t]) return false;
                } else {
                    colors[nei] = 1 - colors[t];
                    queue.add(nei);
                }
            }
        }
        return true;
    }
}
