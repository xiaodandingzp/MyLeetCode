package com.example.myleetcode.ui.theme.zuhe13;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Comparator;

/**
 * 可以用于解决组合和排列相关的问题
 * 回溯法：如果一个问题需要若干步骤，并且在每一个步都面临若干选选项，那么可以用回溯法来解决。
 * 回溯法解决的问题有一个特点，就是这个问题存在多个解，而题目往往需要列出所有的解法
 */
public class Zuhe13 {

//    82 由于每个元素都有两种选择，所以时间复杂度是2的n次方
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
            ////////   注意这里要新建一个LinkedList  而不是直接传递temp
            result.add(new LinkedList<>(temp));
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



//    83 没有重复元素组合的全排列  时间复杂度：n!
    List<List<Integer>> test2(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();
        test2(array, 0, result);
        return result;
    }

    void test2(List<Integer> array, int index, List<List<Integer>> result) {
        if (index == array.size()) {
            result.add(new ArrayList<>(array));
        } else {
            for (int j = index; j < array.size(); j++) {
                swap(array, j, index);
                test2(array, index + 1, result);
                swap(array, j, index);
            }
        }
    }

    void swap(List<Integer> array, int first, int second) {
        if (first != second) {
            int temp = array.get(first);
            array.set(first, array.get(second));
            array.set(second, temp);
        }
    }


//   84 生成匹配的括号
    List<String> test3(int n) {
        List<String> result = new ArrayList<>();
        help3(n, n, "", result);
        return result;
    }

    void help3(int left, int right, String temp, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(temp);
        } else {
            help3(left - 1, right, temp + "(", result);
            if (left < right) {
                help3(left, right - 1, temp + ")", result);
            }
        }
    }


//    86 回文字符串
    List<List<String>> test4(String s) {
        List<List<String>> result = new ArrayList<>();
        help4(s, result, 0, new LinkedList<>());
        return result;
    }

    void help4(String s, List<List<String>> result, int index, LinkedList<String> temp) {
        if (index == s.length()) {
            result.add(new LinkedList<>(temp));
        } else {
            for (int j = index + 1; j <= s.length(); j++) {
                String tempS = s.substring(index, j);
                if (isPalindrome(tempS, index, j)) {
                    temp.add(tempS);
                    help4(s, result, j, temp);
                    temp.removeLast();
                }
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
        }
        return true;
    }
}
