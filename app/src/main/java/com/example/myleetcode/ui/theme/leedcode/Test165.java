package com.example.myleetcode.ui.theme.leedcode;


// 165. 比较版本号
public class Test165 {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int index = 0;
        while (index < v1.length && index < v2.length) {
            if (stringToInt(v1[index]) > stringToInt(v2[index])) return 1;
            if (stringToInt(v1[index]) < stringToInt(v2[index])) return -1;
            index++;
        }
        while (index < v1.length) {
            if (stringToInt(v1[index++]) != 0) return 1;
        }
        while (index < v2.length) {
            if (stringToInt(v2[index++]) != 0) return -1;
        }
        return 0;
    }

    private int stringToInt(String s) {
        return Integer.parseInt(s);
    }
}
