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


//    判断s是否是回文字符串 只考虑字母和数字符号 忽略大小写

    fun isPalindrome(s: String): Boolean {
        var i = 0
        var j = s.length - 1
        var ch1 = ""
        var ch2 = ""
        while (i < j) {
            if (!s[i].isLetterOrDigit()) {
                i++
            } else if (!s[j].isLetterOrDigit()) {
                j--
            } else {
                ch1 = s[i].lowercase()
                ch2 = s[j].lowercase()
                if (ch1 != ch2) return false
                i++
                j--
            }
        }
        return true
    }

//    最多从字符串中删除一个字符能不能得到一个回文字符串
    fun validPalindrome(s: String): Boolean {
        var star = 0
        var end = s.length - 1
        while (star < end) {
            if (s[star] != s[end]) break
            star++
            end--
        }
        return star >= end || isPalindrome(s.substring(star, end - 1))
                || isPalindrome(s.substring(star + 1, end))
    }


//    计算字符串中回文子字符串的个数
    fun countPalindrome(s: String): Int {
        if (s.isNullOrEmpty()) return 0
        var count = 0
        for (i in s.indices) {
            count += countPalindrome(s, i, i)
            count += countPalindrome(s, i ,i + 1)
        }
        return count
    }

    private fun countPalindrome(s: String, star: Int, end: Int): Int {
        var i = star
        var j = end
        var count = 0
        while (i >= 0 && j < s.length) {
            if (s[i] == s[j]) {
                count++
                i--
                j++
            } else break
        }
        return count
    }
}