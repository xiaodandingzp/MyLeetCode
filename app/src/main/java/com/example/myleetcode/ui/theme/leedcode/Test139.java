package com.example.myleetcode.ui.theme.leedcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//  139. 单词拆分
public class Test139 {

//    递归
    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreakHelp(s, wordDict, 0);
    }

    public boolean wordBreakHelp(String s, List<String> wordDict, int startIndex) {
        if (startIndex >= s.length()) return true;
        String tempS = s.substring(startIndex);
        boolean result = false;
        for (String word : wordDict) {
            if (tempS.startsWith(word)) {
                result = result | wordBreakHelp(s, wordDict, startIndex + word.length());
            }
        }
        return result;
    }


//    动态规划
    public boolean wordBreak1(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String ss : wordDict) {
            set.add(ss);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
