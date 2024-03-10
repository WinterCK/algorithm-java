package org.algorithm.chenjk.base.dp.bag.comlete;

import java.util.Arrays;

/**
 * @class: L279 完全平方数
 * @description: 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。完全平方数 是一个整数，其值等于另一个整数的平方；
 * 换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * @author: jack
 * @create: 2024-03-10 14:23
 **/
public class L279 {

    public static void main(String[] args) {
        System.out.println(numSquares(12));
        System.out.println(numSquares(13));
    }

    public static int numSquares(int n) {
        // 为 n 的完全平方数的最少数量
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < n; j++) {
                int val = j * j;
                if (val <= n && i - val >= 0) dp[i] = Math.min(dp[i], dp[i - val] + 1);
            }
        }
        return dp[n];
    }
}
