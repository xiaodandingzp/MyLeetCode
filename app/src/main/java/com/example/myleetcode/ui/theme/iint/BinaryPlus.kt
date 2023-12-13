package com.example.myleetcode.ui.theme.iint

import java.lang.StringBuilder

/**
 * 二进制数字的解决方案：或 与 异或
 */
class BinaryPlus {

//    两个二进制的树相加
    fun addBinary(a: String, b: String): String {
        if (a.isNullOrEmpty()) return b
        if (b.isNullOrEmpty()) return a
        var aLength = a.length - 1
        var bLength = b.length - 1
        var tempY = 0
        val result = StringBuilder()
        while (aLength >= 0 || bLength >= 0) {
            val aInt: Int = if (aLength >= 0) {
                 a[aLength--] - '0'
            } else {
                0
            }
            val bInt: Int = if (bLength >= 0) {
                b[bLength--] - '0'
            } else {
                0
            }
            val total = aInt + bInt + tempY
            if (total >= 2) {
                tempY = 1
                result.append(total - 2)
            } else {
                tempY = 0
                result.append(total)
            }
        }
        if (tempY == 1) result.append('1')
        return result.reverse().toString()
    }


//    前N个数字二进制形式中1的个数
    /*
    * (i and 1) 可以计算是偶数还是奇数
    *  (i shl 1) 左移一位
     */
    fun countBits(num: Int): IntArray {
        var result : IntArray = IntArray(num + 1)
        for (i in 1..num) {
//            计算某个二进制数字中1的个数
            var j = i
            while (j > 0) {
                result[i]++
                j = j and (j - 1)
            }
        }
        return result
    }

    fun countBits1(num: Int): IntArray {
        var result : IntArray = IntArray(num + 1)
        for (i in 1..num) {
            result[i] = result[i and (i - 1)] + 1
        }
        return result
    }

    fun countBits2(num: Int): IntArray {
        var result : IntArray = IntArray(num + 1)
        for (i in 1..num) {
            result[i] = result[i shl 1] + (i and 1)
        }
        return result
    }
}