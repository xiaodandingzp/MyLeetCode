package com.example.myleetcode.ui.theme.zuhe13;


import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class Zuhe13 {

    public List<List<Integer>> combinationSum(List<Integer> array, int target) {
        array.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum(array, target, result, temp, 0);
        return result;
    }

    public void combinationSum(List<Integer> array, int target, List<List<Integer>> result,
                     List<Integer> temp, int index) {
        if (target == 0) {
            result.add(temp);
        } else if (target > 0 && index < array.size()) {
            combinationSum(array, target, result, temp, getNext(index, array));
            temp.add(array.get(index));
            combinationSum(array, target, result, temp, index + 1);
            temp.remove(temp.size() - 1);

        }
    }

    int getNext(int index, List<Integer> array) {
        int cur = array.get(index);
        index++;
        while (index < array.size() && cur == array.get(index)) {
            index++;
        }
        return index;

    }
}
