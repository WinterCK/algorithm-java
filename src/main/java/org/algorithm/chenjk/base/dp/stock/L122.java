package org.algorithm.chenjk.base.dp.stock;

/**
 * @class: L122 买卖股票的最佳时机 II
 * @description: 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天 买入，在第 3 天 卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 *      随后，在第 4 天 买入，在第 5 天 卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。总利润为 4 + 3 = 7
 * @author: jack
 * @create: 2024-04-10 22:13
 **/
public class L122 {

    public static void main(String[] args) {

    }

    // 实现1：二维数组存储
    // 可以将每天持有与否的情况分别用 dp[i][0] 和 dp[i][1] 来进行存储
    // 时间复杂度：O(n)，空间复杂度：O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];     // 创建二维数组存储状态
        dp[0][0] = 0;                   // 初始状态
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);    // 第 i 天，没有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];    // 卖出股票收益高于持有股票收益，因此取[0]
    }
}
