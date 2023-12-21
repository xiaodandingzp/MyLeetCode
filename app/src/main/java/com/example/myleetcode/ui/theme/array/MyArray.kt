package com.example.myleetcode.ui.theme.array


//数组：求解方法 双指针或者求数组某个下标到0的和
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


    fun shortArraySize(nums: IntArray, target: Int): Int {
        if (nums.sum() < target) return 0
        val size = nums.size
        var minLength = size
        var i = 0
        var j = 0
        var sum = 0
        while (i <= size && j < size) {
            while (j < size && (sum + nums[j]) < target) j++
            minLength = minLength.coerceAtMost(j - i + 1)
            while (i <= j && (target - nums[i]) > target) i++
            minLength = minLength.coerceAtLeast(j - i + 1)
        }
        return minLength
    }

//  和为k的子数组的个数  数组中可能包含负数
    fun subArraySum(nums: IntArray, k: Int): Int {
        val haspMap = HashMap<Int, Int>()
        var sum = 0
        var result = 0
        for (i in nums.indices) {
            sum += nums[i]
            result += haspMap.getOrDefault(sum - k, 0)
            haspMap.put(sum, haspMap.getValue(sum) + 1)
        }
        return result
    }

//  0和1个数相等的子数组
    fun subArraySame(nums: IntArray, k: Int): Int {
        val haspMap = HashMap<Int, Int>()
        var sum = 0
        var result = 0
        for (i in nums.indices) {
            if (nums[i] == 0) sum -= 1 else sum += 1
            if (haspMap.contains(sum)) {
                result = Math.max(result, (i - haspMap[sum]!!))
            } else {
                haspMap[sum] = i
            }
        }
        return result
    }

    fun pivotIndex(nums: IntArray): Int {
        val total = nums.sum()
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            if (sum - nums[i] == total - sum) return i
        }
        return -1
    }
}