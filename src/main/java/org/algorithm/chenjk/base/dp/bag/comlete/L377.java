package org.algorithm.chenjk.base.dp.bag.comlete;

/**
 * @class: L377 组合总和 Ⅳ
 * @description: 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：所有可能的组合为：
 * (1, 1, 1, 1)、(1, 1, 2)、(1, 2, 1)、(1, 3)、(2, 1, 1)、(2, 2)、(3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。 (即排列个数)
 * @author: jack
 * @create: 2024-03-10 14:11
 **/
public class L377 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        // 求排列个数，则从背包容量（dp[j]代表含义开始）
        for (int i = 1; i <= target; i++) {
            // 如此每个容量都会遍历每个物品，可排列出 1,1,2, 1,2,1等不同排列
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }

        }
        return dp[target];
    }
}
