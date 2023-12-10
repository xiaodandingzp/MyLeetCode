package com.example.myleetcode.ui.theme.array

object MyArray {
//    75. 颜色分类
//    单指针解法
    fun sortColors(nums: IntArray) {
        val size = nums.size
        var index = 0
        for (i in 1 until size) {
            if (nums[i] == 0) {
                swap(nums, index++, i)
            }
        }

        for (i in index until size) {
            if (nums[i] == 1) {
                swap(nums, index++, i)
            }
        }
    }

    fun sortColors2(nums: IntArray) {
        val size = nums.size
        var index1 = 0
        var index2 = 0
        for (i in 0 until size) {
            if (nums[i] == 1) {
                swap(nums, index2, i)
                index2++
            } else if (nums[i] == 0) {
                swap(nums, index1, i)
                if (index1 < index2) {
                    swap(nums, index2, i)
                }
                index1++
                index2++
            }
        }
    }

    private fun swap(nums: IntArray, index1: Int, index2: Int) {
        val temp = nums[index1]
        nums[index1] = nums[index2]
        nums[index2] = temp
    }
}