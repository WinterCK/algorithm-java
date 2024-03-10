package org.algorithm.chenjk.base.dp.bag.comlete;

/**
 * @class: L518 零钱兑换 II
 * @description: 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * @author: jack
 * @create: 2024-03-10 13:44
 **/
public class L518 {

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(amount, coins));
    }

    /**
     * 完全背包是凑成背包最大价值是多少，而本题是要求凑成总金额的物品组合个数！（组合不不强调元素顺序，排列强调元素之间的顺序）
     * dp[j]：凑成总金额j的货币组合数为dp[j]
     * dp[j] 就是所有的dp[j - coins[i]]（考虑coins[i]的情况）相加。
     * dp[j] += dp[j - coins[i]];
     */
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];

            }
        }
        return dp[amount];
        // 计算排列数，则先遍历背包容量
        // for (int j = 0; j <= amount; j++) { // 遍历背包容量
        //    for (int i = 0; i < coins.size(); i++) { // 遍历物品
        //        if (j - coins[i] >= 0) dp[j] += dp[j - coins[i]];
        //    }
        //}

    }


}
