package org.algorithm.chenjk.base.dp;

/**
 * @class: LC516 最长回文子序列
 * @description: 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 *
 * 输入：s = "bbbab"
 * 输出：4
 * 解释：一个可能的最长回文子序列为 "bbbb" 。
 *
 * 如果f(n)是回文，则去掉首尾仍然是回文
 * dp[i][j]表示字符串s的两个下标i,j对应的回文长度
 * 特性：如果长度等于1,都是回文,dp[i][i]=1
 * i<j时：
 * 如果s[i] == s[j]. 则 dp[i][j] = dp[i+1][j-1] + 2
 * 如果s[i] != s[j] 则dp[i][j] = max( dp[i][j-1], dp[i+1][j] )
 *
 * @author: jack
 * @create: 2023-05-17 22:32
 **/
public class LC516 {

    public static void main(String[] args) {
        String s = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        if (s == null) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int begin = 0;
        int end = s.length() - 1;
        int[][] dp = new int[s.length()][s.length()];
        // 从最后n-1开始往前推进, 每次i--
        for (int i = end; i >= 0; i--) {
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            // j从i+1开始往后推进，直到知道dp[i][n-1]的最大值
            for (int j = i + 1; j < s.length(); j++) {
                char c2 = s.charAt(j);
                if (c1 == c2) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[begin][end];
    }

    /**
     * 问题：字符串太多时深度太深
     * @param dp
     * @param s
     * @param begin
     * @param end
     * @return
     */
    private static int buildDp(int[][] dp, String s, int begin, int end) {
        if (begin > end) {
            return 0;
        }
        if (begin == end) {
            dp[begin][end] = 1;
            return 1;
        }
        if (s.charAt(begin) == s.charAt(end)) {
            int val = buildDp(dp, s, begin + 1, end - 1) + 2;
            dp[begin][end] = val;
            return val;
        } else {
            int val = Math.max(buildDp(dp, s, begin + 1, end), buildDp(dp, s, begin, end - 1));
            dp[begin][end] = val;
            return val;
        }

    }


}
