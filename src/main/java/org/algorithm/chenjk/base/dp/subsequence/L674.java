package org.algorithm.chenjk.base.dp.subsequence;

/**
 * @class: L674 最长连续递增序列
 * @description:
 * @author: jack
 * @create: 2024-04-10 22:30
 **/
public class L674 {

    /**
     * 1.dp[i] 代表当前下标最大连续值
     * 2.递推公式 if（nums[i+1]>nums[i]） dp[i+1] = dp[i]+1
     * 3.初始化 都为1
     * 4.遍历方向，从其那往后
     * 5.结果推导 。。。。
     */
    public static int findLengthOfLCIS(int[] nums) {
        int[] dp = new int[nums.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int res = 1;
        //可以注意到，這邊的 i 是從 0 開始，
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            res = Math.max(res, dp[i + 1]);
        }
        return res;
    }
}
