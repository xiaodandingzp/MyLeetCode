package com.example.myleetcode.ui.theme.leedcode;

import java.util.ArrayList;
import java.util.List;


// 46. 全排列  不包含重复元素的全排列
public class Test46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        help(nums, result, 0);
        return result;
    }

    private void help(int[] nums, List<List<Integer>> result, int index) {
        if (index == nums.length) {
            ArrayList<Integer> tempList = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                tempList.add(nums[i]);
            }
            result.add(tempList);
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            help(nums, result, index + 1);
            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
