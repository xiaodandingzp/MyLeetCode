package com.example.myleetcode.ui.theme.iint

import java.lang.StringBuilder

/**
 * 二进制数字的解决方案：或 与 异或
 * eg:输入数组中除了一个数组出现一次之外，其他的数字都出现了两次，请找出只出现一次的数字
 * 解：将数组中所有的数字进行异或运算
 *
 * int类型是有32个0或者1组成的，可以按位运算
 * eg:输入数组中除了一个数组出现一次之外，其他的数字都出现了三次，请找出只出现一次的数组
 * 解：按位加 然后按位除以3
 */
class BinaryPlus {

//    两个二进制的数相加
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


//    输入数组中除了一个数组出现一次之外，其他的数字都出现了三次，请找出只出现一次的数组
    fun singleNumber(nums: IntArray): Int {
        val resultTemp = IntArray(32)
        for (num in nums) {
            for (i in 0 until 32) {
                resultTemp[i] += (num shr (31 - i)) and 1
            }
        }
        var result = 0
        for (i in 0 until 32) {
            result = (result shl 1) + resultTemp[i] % 3
        }
        return result
    }


//    假设两个字符串的长度分别为p和q, 比较两个字符串是否相等时，hash算法将时间复杂度从O（pq）降到了O（1）
//    字符串可以转换成一个固定长度的数组（因为字母的个数固定26），也可以转换成一个Int数字。
//    转换成数组后，for循环旧变成了固定的26。
//    转换成Int后就可以进行位运算(与 或 异或 左移 右移 )
    fun maxProduct(words: List<String>): Int {
        val list: ArrayList<IntArray> = ArrayList()
        for (word in words) {
            val temp = IntArray(26)
            word.forEach {
                temp[it - 'a'] = 1
            }
            list.add(temp)
        }
        var result = 0
        for (i in words.indices) {
            for (j in (i + 1) until words.size) {
                var isSame = false
                for (k in 0 until 26) {
                    if (list[i][k] == 1 && list[j][k] == 1) {
                        isSame = true
                        break
                    }
                }
                if (!isSame) {
                    result = result.coerceAtLeast(words[i].length * words[j].length)
                }
            }
        }
        return result
    }


    fun maxProduct1(words: List<String>): Int {
        val binArray = IntArray(26)
        for (i in words.indices) {
            words[i].forEach {
                binArray[i] = (1 shl (it - 'a')) or binArray[i]
            }
        }
        var result = 0
        for (i in words.indices) {
            for (j in (i +1) until words.size) {
                if ((binArray[i] and  binArray[j]) == 0) {
                    result = result.coerceAtLeast(words[i].length * words[j].length)
                }
            }
        }
        return result
    }
}