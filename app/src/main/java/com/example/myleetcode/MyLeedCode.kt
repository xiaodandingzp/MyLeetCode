package com.example.myleetcode

import android.util.Log
import java.util.Stack
import kotlin.math.absoluteValue

/***
 * 思路
 * 动态规划
 * 递归
 * 双指针
 */

object MyLeedCode {
    const val TAG = "MyLeedCode"
    //字符串转换整数
    fun myAtoi(s: String): Int {
        if (s.isBlank()) return 0;
        var index = 0
        while (' ' == s[index]) {
            index++
        }
        if (index < s.length) {
            var result: Long = 0
            val isf = s[index] == '-'
            if (s[index] == '-' || s[index] == '+') index++
            for (i in index until s.length) {
                if (s[i] in '0'..'9') {
                    result = result * 10 + s[i].toString().toInt()
                    if (result > Int.MAX_VALUE) break
                } else {
                    break
                }
            }
            if (isf) {
                if (-result < Int.MIN_VALUE) return Int.MIN_VALUE
                return -(result.toInt())
            } else {
                if (result > Int.MAX_VALUE) return Int.MAX_VALUE
                return result.toInt()
            }
        }
        return 0
    }

    //三数之和
    fun threeSum(nums: IntArray): List<List<Int>> {
        val result: ArrayList<List<Int>> = arrayListOf()
        if (nums.size < 3) return result
        nums.sort()
        for (i in 0 until nums.size - 2) {
            if (nums[i] > 0) break
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var left = i + 1
            var right = nums.size - 1
            val target = -nums[i]
            while ( left < right) {
                if (nums[left] + nums[right] == target) {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                    while (left < right && nums[left] == nums[left - 1]) left++
                    while (left < right && nums[right] == nums[right + 1]) right--
                } else if (nums[left] + nums[right] <  target) {
                    left++
                } else {
                    right--
                }
            }
        }
        return result
    }

    //四数之和
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val result: ArrayList<List<Int>> = arrayListOf()
        if (nums.size < 4 ) return result
        if (nums.size == 4 && nums.sum() != target)  return result
        nums.sort()
        nums.forEach {
            Log.i(TAG, "$it")
        }
        for (i in 0 until nums.size - 3) {
            Log.i(TAG, "ii： $i nums[i]: ${nums[i]}   ${Int.MAX_VALUE}")
            if (nums[i] > 0 && nums[i] > target) break
            if (i > 0 && nums[i] == nums[i - 1]) continue
            val target3: Long = (target - nums[i]).toLong()
            for (j in (i + 1) until nums.size - 2) {
                Log.i(TAG, "jj： $j target3: $target3")
                if (nums[j] > 0 && nums[j] > target3) break
                if (j > (i + 1) && nums[j] == nums[j - 1]) continue
                val target2 = target3 - nums[j]
                var left = j + 1
                var right = nums.size - 1
                while (left < right) {
                    Log.i(TAG, "left： $left  right: $right  target2: $target2")
                    if ((nums[left] + nums[right]).toLong() == target2) {
                        result.add(listOf(nums[i], nums[j], nums[left], nums[right]))
                        left++
                        right--
                        while (left < right && nums[left - 1] == nums[left]) left++
                        while (left < right && nums[right + 1] == nums[right]) right--
                    } else if (nums[left] + nums[right] < target2) {
                        left++
                    } else {
                        right--
                    }
                }
            }
        }
        return result
    }

//  匹配任意字符

    fun isMatch(s: String, p: String): Boolean {
        if (s.isEmpty()) return p.isEmpty()
        return isMatch2(s, p, 0, 0)
    }

    fun isMatch2(s: String, p: String, sIndex: Int, pIndex: Int): Boolean {
        if (pIndex == p.length) return sIndex == s.length
        val firstMatch = sIndex < s.length && (s[sIndex] == p[pIndex] || p[pIndex] == '.')
        if ((pIndex + 1) < p.length && p[pIndex + 1] == '*') {
            return isMatch2(s, p, sIndex, pIndex + 2)
                    || (firstMatch && isMatch2(s, p, sIndex + 1, pIndex))
        } else return firstMatch && isMatch2(s, p, sIndex + 1, pIndex + 1)
    }

    fun romanToInt(s: String): Int {
        var result = 0
        for (i in 0 until s.length) {
            if (s[i] == 'I') {
                if ((i + 1) < s.length && (s[i + 1] == 'V' || s[i + 1] == 'X')) {
                    result -= 1
                } else {
                    result += 1
                }
            } else if (s[i] == 'V') {
                result += 5
            } else if (s[i] == 'X') {
                if ((i + 1) < s.length && (s[i + 1] == 'L' || s[i + 1] == 'C')) {
                    result -= 10
                } else {
                    result += 10
                }
            } else if (s[i] == 'L') {
                result += 50
            } else if (s[i] == 'C') {
                if ((i + 1) < s.length && (s[i + 1] == 'D' || s[i + 1] == 'M')) {
                    result -= 100
                } else {
                    result += 100
                }
            } else if (s[i] == 'D') {
                result += 500
            } else if (s[i] == 'M') {
                result += 1000
            }
        }
        return result
    }

    fun intToRoman(num: Int): String {
        var result = ""
        var numTemp = num
        while (true) {
            if (numTemp >= 1000) {
                result += "M"
                numTemp -= 1000
            } else if (numTemp >= 900) {
                result += "CM"
                numTemp -= 900
            } else if (numTemp >= 500) {
                result += "D"
                numTemp -= 500
            } else if (numTemp >= 400) {
                result += "CD"
                numTemp -= 400
            } else if (numTemp >= 100) {
                result += "C"
                numTemp -= 100
            } else if (numTemp >= 90) {
                result += "XC"
                numTemp -= 90
            } else if (numTemp >= 50) {
                result += "L"
                numTemp -= 50
            } else if (numTemp >= 40) {
                result += "XL"
                numTemp -= 40
            } else if (numTemp >= 10) {
                result += "X"
                numTemp -= 10
            } else if (numTemp >= 9) {
                result += "IX"
                numTemp -= 9
            } else if (numTemp >= 5) {
                result += "V"
                numTemp -= 5
            } else if (numTemp >= 4) {
                result += "IV"
                numTemp -= 4
            } else if (numTemp >= 1) {
                result += "I"
                numTemp -= 1
            } else {
                return result
            }
        }
    }
//    最接近的三数之和
    fun threeSumClosest(nums: IntArray, target: Int): Int {
    val numsList = nums.toList().sorted()
    var threeTotal = Int.MAX_VALUE
    for (i in numsList.indices) {
        var right = numsList.size - 1
        var left = i + 1
        while (left < right) {
            val threeTemp = numsList[i] + numsList[right] + numsList[left]
            if (threeTemp < target) {
                left++
            } else if (threeTemp > target) {
                right--
            } else {
                return threeTemp
            }
            if ((threeTemp - target).absoluteValue < (threeTotal - target).absoluteValue) {
                threeTotal = threeTemp
            }
        }
    }
    return threeTotal    }

//    17. 电话号码的字母组合
    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return arrayListOf()
        val map: HashMap<Char, List<String>> = HashMap<Char, List<String>>().apply {
            put('2', arrayListOf("a", "b", "c"))
            put('3', arrayListOf("d", "e", "f"))
            put('4', arrayListOf("g", "h", "i"))
            put('5', arrayListOf("j", "k", "l"))
            put('6', arrayListOf("m", "n", "o"))
            put('7', arrayListOf("p", "q", "r", "s"))
            put('8', arrayListOf("t", "u", "v"))
            put('9', arrayListOf("w", "x", "y", "z"))
        }
        val result: ArrayList<String> = arrayListOf()
        getString(digits, 0, map, result, "")
        return result
    }

    private fun getString(digits: String, index: Int, map: HashMap<Char, List<String>>, result: ArrayList<String>, stringBuilder: String) {
        if (index >= digits.length) {
            result.add(stringBuilder)
            return
        }
        map[digits[index]]?.forEach {
            val res = stringBuilder + it
            getString(digits, index + 1, map, result, res)
        }
    }

//    最长公共前缀
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isNullOrEmpty()) return ""
        if (strs.size == 1) return strs[0]
        var result = strs[0]
        for (i in 1 until strs.size) {
            if (result.isEmpty()) return ""
            var j = 0
            while (j < result.length && j < strs[i].length) {
                if (result[j] != strs[i][j]) break
                j++
            }
            result = result.substring(0, j)
        }
        return result
    }

//    盛最多水的容器
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0
        while (left < right) {
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left))
            if (height[left] < height[right]) {
                left++
            } else right++
        }
        return max
    }
//   20 有效的括号
    fun isValid(s: String): Boolean {
        var result = s
        if ((result.length % 2) !== 0) return false
        for (i in 0 until  (result.length / 2)) {
            result = result.replace("()", "").replace("[]", "").replace("{}", "")
        }
        return result.isEmpty()
    }

    fun generateParenthesis(n: Int): List<String> {
        val resList: ArrayList<String> = arrayListOf()
        addRes(n, n , "", resList)
        return resList
    }

    fun addRes(left: Int, right: Int, ss: String, reList: ArrayList<String>) {
        if (left == 0 && right == 0) {
            reList.add(ss)
            return
        }
        if (left > 0) {
            addRes(left - 1, right, "$ss(", reList)
        }
        if (right > left && right > 0) {
            addRes(left, right - 1, "$ss)", reList)
        }
    }

    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.size <= 0) return 0
        var result = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[result++] = nums[i]
            }
        }
        return result
    }

    fun strStr(haystack: String, needle: String): Int {
        var j = 0
        for (i in haystack.indices) {
            if (haystack[i] == needle[0]) {
                var s1 = i
                while (s1 < haystack.length && j < needle.length) {
                    if (haystack[s1] == needle[j]) {
                        s1++
                        j++
                    } else {
                        break
                    }
                }
                if (j == needle.length) return s1 - needle.length
                j = 0
            }
        }
        return -1
    }

    fun divide(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE) {
            if (divisor == 1) return Int.MIN_VALUE
            if (divisor == -1) return Int.MAX_VALUE
        }
        if (divisor == Int.MIN_VALUE) {
            return if (dividend == Int.MIN_VALUE) 1
            else 0
        }
        if (dividend < divisor) return 0
        if (dividend == 0) return 0
        if (dividend < 0) return -divide(-dividend, divisor)
        if (divisor < 0) return -divide(dividend, -divisor)
        var  res = 1
        var temp = divisor
        while ((dividend - temp) <= divisor) {
            temp += temp
            res += res
        }
        return res + divide(dividend - temp, divisor)
    }

//    整数数组的 下一个排列 是指其整数的下一个字典序更大的排列
    fun divide1(dividend: Int, divisor: Int): Int {
        if (dividend == Int.MIN_VALUE) {
            if (divisor == 1) return Int.MIN_VALUE
            if (divisor == -1) return Int.MAX_VALUE
        }
        if (divisor == Int.MIN_VALUE) {
            return if (dividend == Int.MIN_VALUE) 1
            else 0
        }
        if (dividend == 0) return 0
        if (dividend > 0) return -divide1(-dividend, divisor)
        if (divisor > 0) return -divide1(dividend, -divisor)
        if (dividend > divisor) return 0
        var temp = divisor
        var res = 1
        while ((dividend - temp) <= temp) {
            res += res
            temp += temp
        }
        return res + divide1((dividend - temp), divisor)
    }

    fun nextPermutation(nums: IntArray): Unit {
        if (nums.size > 1) {
            var j = nums.size - 2
            while (j >= 0 && nums[j] >= nums[j +1]) j--
            if (j >= 0) {
                var i = nums.size - 1
                while (i > j && nums[i] <= nums[j]) i--
                if (i > j) {
                    val tem = nums[j]
                    nums[j] = nums[i]
                    nums[i] = tem
                }
            }
            var left = j + 1
            var right = nums.size - 1
            while (left < right) {
                val temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp
                left++
                right--
            }
        }
    }

    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 1) return 0
        var max = 0
        var min = prices[0]
        for (i in 1 until prices.size) {
            if (min > prices[i]) {
                min = prices[i]
            } else {
                if (max < (prices[i] - min))  {
                    max = prices[i] - min
                }
            }
        }
        return max
    }

    fun searchInsert(nums: IntArray, target: Int): Int {
        return search(nums, 0, nums.size - 1, target)
    }

    fun search(nums: IntArray, left: Int, right: Int, target: Int): Int {
        return if (left < right) {
            val mid = (left + right) / 2
            if (nums[mid] == target) mid
            else if(nums[mid] > target) search(nums, left, mid, target)
            else if(left == mid) search(nums, mid + 1, right, target)
            else search(nums, mid, right, target)
        } else {
            if (nums[left] >= target) left
            else left + 1
        }
    }


    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result: ArrayList<ArrayList<Int>> = ArrayList()
        combinationSum1(candidates, 0, result, ArrayList<Int>(), target)
        return result
    }

    fun combinationSum1(candidates: IntArray, index: Int, result: ArrayList<ArrayList<Int>>,
                        temp: ArrayList<Int>, target: Int){
        if (temp.sum() == target && temp.size > 0) {
            result.add(temp)
            return
        }
        if (index == candidates.size || temp.sum() > target) return

        val temp2 = ArrayList<Int>().apply {
            addAll(temp)
            add(candidates[index])
        }
        combinationSum1(candidates, index, result, temp2, target, )
        val temp1 = ArrayList<Int>().apply {
            addAll(temp)
        }
        combinationSum1(candidates, index + 1, result, temp1, target)
    }


    fun longestValidParentheses(s: String): Int {
        if (s.isEmpty()) return 0
        var maxS = 0
        var left: Stack<Int> = Stack()
        left.push(-1)
        for (i in s.indices) {
            if (s[i] == '(') {
                left.push(i)
            } else {
                if (left.size == 1) {
                    left.pop()
                    left.push(i)
                } else {
                    left.pop()
                    maxS = maxS.coerceAtLeast(i - left.peek())
                }
            }
        }
        return maxS
    }
}