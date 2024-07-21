package com.example.myleetcode.ui.theme.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

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



    public int[][] updateMatrix(int [][] graph) {
        int row = graph.length;
        int col = graph[0].length;
        int[][] dis = new int[row][col];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    dis[i][j] = 0;
                } else {
                    dis[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] nei = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] index = queue.poll();
            for (int i = 0; i < 4; i++) {
                int[] offset = nei[i];
                int r = index[0] + offset[0];
                int c = index[1] + offset[1];
                if (r >= 0 && r < row && c >= 0 && c < col) {
                    if (dis[r][c] > dis[index[0]][index[1]] + 1) {
                        dis[r][c] = dis[index[0]][index[1]] + 1;
                        queue.add(new int[]{r, c});
                    }
                }
            }
        }
        return dis;
    }

    public String alienOrder(String[] words) {
        if (words.length == 0) return "";
        HashMap<Character, Set<Character>> wordMap = new HashMap<>();
        HashMap<Character, Integer> deeps = new HashMap<>();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                wordMap.putIfAbsent(word.charAt(i), new HashSet<>());
                deeps.putIfAbsent(word.charAt(i), 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            if (word1.startsWith(word2) && !word1.equals(word2)) {
                break;
            }
            for (int j = 0; j < word1.length() && j < word2.length(); j++ ) {
                if (word1.charAt(j) != word2.charAt(2)) {
                    Set<Character> set = wordMap.get(word1.charAt(j));
                    set.add(word2.charAt(j));
                    wordMap.putIfAbsent(word1.charAt(j), set);
                    int count = deeps.get(word2.charAt(j));
                    deeps.putIfAbsent(word2.charAt(j),  count + 1);
                    break;
                }
            }
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (char c : deeps.keySet()) {
            if (deeps.get(c) != 0) {
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            char temp = stack.pop();
            result.append(temp);
            for (char c : wordMap.get(temp)) {
                deeps.putIfAbsent(c, deeps.get(c) - 1);
                if (deeps.get(c) == 0) {
                    stack.add(c);
                }
            }
        }
        if (result.length() == words.length) return result.toString();
        return "";
    }
}
