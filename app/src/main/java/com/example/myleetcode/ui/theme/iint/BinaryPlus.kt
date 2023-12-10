package com.example.myleetcode.ui.theme.iint

import java.lang.StringBuilder

class BinaryPlus {
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
}