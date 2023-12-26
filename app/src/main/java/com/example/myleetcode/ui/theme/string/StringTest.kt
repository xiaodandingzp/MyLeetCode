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


//    包含所有字符的最短字符串
    fun minWindow(s: String, t: String): String {
        val hashMap = HashMap<Char, Int>()
        for (c in t) {
            hashMap[c] = hashMap.getOrDefault(c, 0) + 1
        }
        var count = hashMap.size
        var end = 0
        var start = 0
        var endIndex = 0
        var startIndex = 0
        var minLength = Int.MAX_VALUE
        while (end < s.length || (count == 0 && end == s.length)) {
            if (count > 0) {
                val cIns = s[end]
                if (hashMap.containsKey(cIns)) {
                    hashMap[cIns] = hashMap[cIns]!! - 1
                    if (hashMap[cIns] == 0) {
                        count--
                    }
                }
                end++
            } else {
                if (end - start < minLength) {
                    minLength = end - start
                    startIndex = start
                    endIndex = end
                }
                val cIns = s[start]
                if (hashMap.containsKey(cIns)) {
                    hashMap[cIns] = hashMap[cIns]!! + 1
                    if (hashMap[cIns] == 1) {
                        count++
                    }
                }
                start++
            }
        }
        return if (minLength < Int.MAX_VALUE) {
            return s.substring(startIndex, endIndex)
        } else ""
    }
}