package org.algorithm.chenjk.base.dp.subsequence;

/**
 * @class: L1143 最长公共子序列
 * @description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * @author: jack
 * @create: 2024-04-10 22:32
 **/
public class L1143 {

    /**
     * dp[i][j]：长度为[0, i - 1]的字符串text1与长度为[0, j - 1]的字符串text2的最长公共子序列为dp[i][j]
     *   -- 如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
     *   -- 如果text1[i - 1] 与 text2[j - 1]不相同，即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
     */
    public int longestCommonSubsequence(String text1, String text2) {
        // char[] char1 = text1.toCharArray();
        // char[] char2 = text2.toCharArray();
        // 可以在一開始的時候就先把text1, text2 轉成char[]，之後就不需要有這麼多爲了處理字串的調整

        int[][] dp = new int[text1.length() + 1][text2.length() + 1]; // 先对dp数组做初始化操作
        for (int i = 1 ; i <= text1.length() ; i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                if (char1 == char2) { // 开始列出状态转移方程
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
