package com.example.myleetcode.ui.theme.sort

object MySort {
//    快速排序
    fun quickSort(arr: ArrayList<Int>) {
        quickSort(arr, 0, arr.size - 1)
    }
    private fun quickSort(arr: ArrayList<Int>, start: Int, endPre: Int) {
        if (start < endPre) return
        val key = arr[start]
        var begin = start
        var end = endPre
        while (begin < end) {
            while (begin < end && arr[end] > key) end--
            arr[begin] = arr[end]
            while (begin < end && arr[begin] < key) begin++
            arr[end] = arr[begin]
        }
        arr[begin] = key
        quickSort(arr, start, begin - 1)
        quickSort(arr, begin + 1, endPre)
    }

    fun fastSort(arr: ArrayList<Int>) {
        fastSort(arr, 0, arr.size - 1)
    }

    private fun fastSort(arr: ArrayList<Int>, start: Int, end: Int) {
        if (start >= end) return
        var key = arr[start]
        var startTemp = start
        var endTemp = end
        while (startTemp < endTemp) {
            while (startTemp < endTemp && arr[endTemp] > key) endTemp--
            arr[startTemp] = arr[endTemp]
            while (startTemp < endTemp && arr[startTemp] < key) startTemp++
            arr[endTemp] = arr[startTemp]
        }
        arr[startTemp] = key
        fastSort(arr, 0, startTemp - 1)
        fastSort(arr, endTemp + 1, 0)
    }

    /***
     * 计数排序
     * 如果数组的长度为n, 蒸熟范围为K 时间复杂度为O(n + k)   空间复杂度为：O(k).
     * 计数排序适用于k远小于n的场景
     * 基本思想：
     *  1，先统计数组中每个整数在数组中出现的次数。
     *  2，然后按照从小到大的顺序将每个整数按照它出现的次数填充到数组中。
     */
    fun arraySortByCount(nums: Array<Int>): Array<Int> {
        var max = Int.MAX_VALUE
        var min = Int.MIN_VALUE
        for (i in nums.indices) {
            if (nums[i] > max) max = nums[i]
            if (nums[i] < min) min = nums[i]
        }

        val tempArray = Array<Int>(max - min + 1) { 0 }
        for (num in nums) {
            tempArray[num - min]++
        }
        var index = 0
        for (i in min..max) {
            while (tempArray[i - min] > 0) {
                nums[index++] = i
                tempArray[i - min]--
            }
        }
        return nums
    }
}