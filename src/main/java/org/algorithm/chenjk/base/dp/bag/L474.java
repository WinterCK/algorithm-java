package org.algorithm.chenjk.base.dp.bag;

/**
 * @class: L474 一和零
 * @description: 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集
 * 输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出：4
 * 解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4
 * @author: jack
 * @create: 2024-03-07 21:30
 **/
public class L474 {

    public static void main(String[] args) {
        String[] strs = {"10","0","1"};
        System.out.println(findMaxForm(strs, 1, 1));
    }

    public static int findMaxForm(String[] strs, int m, int n) {
        // dp[m][n] = max(dp[m][n], dp[m - m1][n - n1] + 1)
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;

        for (String str : strs) {
            int mLen = 0;
            int nLen = 0;
            for (int k = 0; k < str.length(); k++) {
                if ('0' == str.charAt(k)) {
                    mLen ++;
                }
                if ('1' == str.charAt(k)) {
                    nLen ++;
                }
            }
            for (int i = m; i >= mLen; i--) {

                for (int j = n; j >= nLen; j--) {

//                    Math.max(dp[i - 1][j], dp[i][j - 1])
                    dp[i][j] = Math.max(dp[i][j], dp[i - mLen][j - nLen] + 1);
                }
            }

        }
        return dp[m][n];

    }


}
