package org.algorithm.chenjk.base.dp.subsequence;

import java.util.Arrays;

/**
 * @class: L300 最长递增子序列
 * @description: 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * @author: jack
 * @create: 2024-04-10 22:15
 **/
public class L300 {
    /**
     * dp[i]表示i之前包括i的以nums[i]结尾的最长递增子序列的长度
     * 位置 i的 最长升序子序列 等于 j从0到i-1各个位置的最长升序子序列 + 1 的最大值。
     * 所以：if (nums[i] > nums[j]) dp[i] = max(dp[i], dp[j] + 1);
     * 注意这里不是要dp[i] 与 dp[j] + 1进行比较，而是我们要取dp[j] + 1的最大值。
     * 初始化：每一个i，对应的dp[i]（即最长递增子序列）起始大小至少都是1.
     */
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums2 = {0,1,0,3,2};
        System.out.println(lengthOfLIS(nums2));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                res = Math.max(res, dp[i]);
                System.out.print(" j: " + j + ": " + dp[j]);
            }
            System.out.println(" i: " + i + " dp[i]: " + dp[i]);
        }
        return res;
    }
}
