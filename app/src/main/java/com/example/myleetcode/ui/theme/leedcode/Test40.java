package com.example.myleetcode.ui.theme.leedcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList();
        Arrays.sort(candidates);
        help(candidates, 0, target, new LinkedList<>(), result);
        return result;
    }

    void help(int[] candidates, int index, int target, LinkedList<Integer> temp, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new LinkedList<>(temp));
        } else if(target > 0 && index < candidates.length) {
            int valAtIndex = candidates[index];
            temp.add(valAtIndex);
            help(candidates, index + 1, target - valAtIndex, temp, result);
            temp.removeLast();
            index++;
            while (index < candidates.length) {
                if (candidates[index] > valAtIndex) break;
                index++;
            }
            help(candidates, index, target, temp, result);
        }
    }
}
