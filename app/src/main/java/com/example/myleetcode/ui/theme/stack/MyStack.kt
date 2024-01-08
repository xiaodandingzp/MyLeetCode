package com.example.myleetcode.ui.theme.stack

import java.util.Stack

class MyStack {
// 每日温度
    fun dailyTemperatures(arrs: IntArray): IntArray {
        val stack: Stack<Int> = Stack()
        val result = IntArray(arrs.size)
        for (i in arrs.indices) {
            while (!stack.isEmpty()  && arrs[i] > arrs[stack.peek()]) {
                val lastIndex = stack.pop()
                result[lastIndex] = i - lastIndex
            }
            stack.push(i)
        }
        return result
    }

//    直方图最大矩形面积
    fun largestRectangleArea(arrs: IntArray): Int {
        val stack: Stack<Int> = Stack()
        stack.push(-1)
        var maxResult = 0
        for (i in arrs.indices) {
            while (stack.peek() != -1  && arrs[i] <= arrs[stack.peek()]) {
                val height = arrs[stack.pop()]
                val with = i - stack.peek() - 1
                maxResult = Math.max(maxResult, height * with)
            }
            stack.push(i)
        }
        while (stack.peek() != -1) {
            val height = arrs[stack.pop()]
            val with = arrs.size - stack.peek() - 1
            maxResult = Math.max(maxResult, height * with)
        }
        return maxResult
    }


//    直方图最大矩形面积-分治法
    fun largestRectangleArea2(arrs: IntArray): Int {
        return largestRectangleArea2(arrs, 0, arrs.size)
    }

    fun largestRectangleArea2(arrs: IntArray, start: Int, end: Int): Int {
        if (start <= end) return 0
        var minIndex = 0
        for (i in start until end) {
            if (arrs[i] < arrs[minIndex]) {
                minIndex = i
            }
        }
        var area = arrs[minIndex] * (end - start)
        val left = largestRectangleArea2(arrs, 0, minIndex)
        val right = largestRectangleArea2(arrs, minIndex + 1, arrs.size)
        area = Math.max(area, left)
        return Math.max(area, right)
    }


//    矩阵中最大面积的矩形
    fun maxRectangle(arrs: Array<IntArray>): Int {
        if (arrs.isEmpty() || arrs[0].isEmpty()) return 0
        val h = arrs[0].size
        val w = arrs.size
        val tempArray = arrs[0]
        var maxResult = 0
        maxResult = Math.max(maxResult, largestRectangleArea(tempArray))
        for (i in 0 until w) {
            for (j in 0 until h) {
                if (arrs[i][j] == 0) tempArray[j] = 0
                else tempArray[j]++
            }
            maxResult = Math.max(maxResult, largestRectangleArea(tempArray))
        }
        return maxResult
    }
}