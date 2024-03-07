package org.algorithm.chenjk.base.dp.bag;

/**
 * @class: L1049
 * @description: 有一堆石头，每块石头的重量都是正整数。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 * 如果 x == y，那么两块石头都会被完全粉碎；如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 * 最后，最多只会剩下一块石头。返回此石头最小的可能重量。如果没有石头剩下，就返回 0。
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
 * 组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
 * 组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
 * 组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
 * 1 <= stones.length <= 30
 * 1 <= stones[i] <= 100
 * @author: jack
 * @create: 2024-03-07 21:07
 **/
public class L1049 {

    public static void main(String[] args) {
        int[] nums = {2,7,4,1,8,1};
        int[] num2 = {31,26,33,21,40};
        System.out.println(lastStoneWeightII(nums));
        System.out.println(lastStoneWeightII(num2));
    }

    /**
     * 两两相撞，最多只会剩下一块石头。返回此石头最小的可能重量
     * 相当于先把石头合成两块最接近 sum/2 大小的石头，之后想减即为最小数量
     * 合成两块最接近 sum/2 大小的石头 即01背包，sum/2下最大的石头大小
     * 方程：dp[j] = max(dp[j], dp[j - stone[i]] + stone[i])
     * @param stones 石头
     * @return 最小数量
     */
    public static int lastStoneWeightII(int[] stones) {
        // 1 <= stones.length <= 30
        // 1 <= stones[i] <= 100, 石头的最大背包即 3000 / 2
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int target = sum / 2;
//        int[] dp = new int[3000 / 2 + 1];
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >= stones[i] ; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        // 第二块石头 - 最接近sum/2的最大石头
        return (sum - dp[target]) - dp[target];
    }
}
