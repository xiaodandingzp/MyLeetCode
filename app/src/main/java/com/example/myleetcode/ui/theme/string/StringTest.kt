package com.example.myleetcode.ui.theme.string

class StringTest {

//    s2中是否包含s1的变位词
    fun checkInclusion(s1: String, s2: String): Boolean {
        if (s1.length > s2.length) return false
        val hashTab = IntArray(26)
        for (i in s1.indices) {
            hashTab[s1[i] - 'a']++
            hashTab[s2[i] - 'a']--
        }
        if(checkAllZero(hashTab)) {
            return true
        }

        for (i in s1.length until  s2.length) {
            hashTab[s2[i] - 'a']--
            hashTab[s2[i - s1.length] - 'a']++
            if (checkAllZero(hashTab)) return true
        }
        return false
    }

    private fun checkAllZero(hashTab: IntArray): Boolean {
        for (i in 0 until 26) {
            if (hashTab[i] != 0) return false
        }
        return true
    }


    fun maxLengthNoSame(s: String): Int {
        var maxLength = 1
        val hashString = IntArray(26)
        var i = 0
        var j = 0
        while (j < s.length) {
            if (hashString[s[j] - 'a'] == 0) {
                hashString[s[j] - 'a']++
                j++
            } else {
                maxLength = maxLength.coerceAtLeast(j - i)
                hashString[s[i] - 'a']--
                i++
            }
        }
        maxLength = maxLength.coerceAtLeast(j - i)
        return maxLength
    }
}