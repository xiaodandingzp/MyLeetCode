package com.example.myleetcode.ui.theme.dymic;

public class Dynamic {
    public int minCost(int[][] cost) {
        if (cost.length < 1) return 0;
        int result;
        int[][] dp = new int[2][3];
        for (int i = 0; i < 3; i++) {
            dp[0][1] = cost[0][i];
        }
        for (int i = 1; i < cost.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i % 2][j] = Math.min(dp[i % 2][(j + 1) % 3], dp[(i - 1) % 2][(j + 2) % 3]) + cost[(i - 1)][j];
            }
        }
        int last = (cost.length - 1) % 2;
        result = Math.min(dp[last][0], Math.min(dp[last][1], dp[last][2]));
        return result;
    }


//    回文串 最少分割次数
    public int minCut(String s) {
        int length = s.length();
        if (length <= 1) return length;
        boolean[][] isH = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (j + 1 >= i || isH[j + 1][i - 1])) {
                    isH[j][i] = true;
                }
            }
        }

        int[] dp = new int[length];
        for (int i = 1; i < length; i++) {
            if (isH[0][i]) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + 1;
                for (int j = 0; j < i; j++) {
                    if (isH[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j] + 1);
                    }
                }
            }
        }
        return dp[length - 1];
    }

    public int numDistinct(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        dp[0][0] = 1;

        for (int i = 0; i < s.length(); i++) {
            dp[i + 1][0] = 1;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                } else {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
            }
        }

        return dp[s.length()][t.length()];
    }


    public int numDistinct1(String s, String t) {
        if (s.length() < t.length()) return 0;
        int[] dp = new int[t.length() + 1];

        for (int i = 0; i < s.length(); i++) {
            dp[0] = 1;
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[j + 1] += dp[j];
                }
            }
        }
        return dp[t.length()];
    }

    public boolean test(String s1, String s2, String s3) {
        if (s1.length() != (s2.length() + s3.length())) return false;
        boolean[][] dp = new boolean[s2.length() + 1][s3.length() + 1];
        dp[0][0] = true;

        for (int i = 0; i < s2.length(); i++) {
            dp[i + 1][0] = s1.charAt(i) == s2.charAt(i);
        }
        for (int i = 0; i < s3.length(); i++) {
            dp[0][i + 1] = s1.charAt(i) == s2.charAt(i);;
        }

        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < s3.length(); j++) {
                char cTempForS1 = s1.charAt(i + j);
                if (cTempForS1 == s2.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j + 1];
                }
                 if (cTempForS1 == s3.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }
        return dp[s2.length()][s3.length()];
    }


    public boolean test1(String s1, String s2, String s3) {
        if (s1.length() != (s2.length() + s3.length())) return false;
        if (s2.length() < s3.length()) {
            return test1(s1, s3, s2);
        }
        boolean[] dp = new boolean[s3.length() + 1];
        dp[0] = true;

        for (int i = 0; i < s3.length(); i++) {
            dp[i + 1] = s1.charAt(i) == s3.charAt(i);
        }

        for (int i = 0; i < s2.length(); i++) {
            dp[0] = dp[0] && (s1.charAt(i) == s2.charAt(i));
            for (int j = 1; j < s3.length(); j++) {
                char cTempForS1 = s1.charAt(i + j);
                char cTempForS2 = s2.charAt(i + j);
                char cTempForS3 = s3.charAt(i + j);
                dp[j + 1] = (dp[j] && cTempForS1 == cTempForS2) || (dp[j + 1] && cTempForS1 == cTempForS3);
            }
        }
        return dp[s3.length()];
    }
}
