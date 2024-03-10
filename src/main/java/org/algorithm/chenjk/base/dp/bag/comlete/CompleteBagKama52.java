package org.algorithm.chenjk.base.dp.bag.comlete;

/**
 * @class: CompleteBagKama52 完全背包问题
 * @description:
 * 01背包内嵌的循环是从大到小遍历，为了保证每个物品仅被添加一次。
 * 而完全背包的物品是可以添加多次的，所以要从小到大去遍历，即
 * for (int i = 0; i < weight.size(); i++) { // 遍历物品
 *     for (int j = weight[i]; j <= bagWeight ; j++) { // 遍历背包容量
 *         dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
 *     }
 * }
 *
 * // 先遍历背包，再遍历物品 也可以
 * for (int j = 0; j <= bagWeight; j++) { // 遍历背包容量
 *     for (int i = 0; i < weight.size(); i++) { // 遍历物品
 *         if (j - weight[i] >= 0) dp[j] = max(dp[j], dp[j - weight[i]] + value[i]);
 *     }
 * }
 * @author: jack
 * @create: 2024-03-10 12:19
 **/
public class CompleteBagKama52 {

    /**
     * 携带研究材料
     * 小明的行李箱所能承担的总重量为 N，问小明应该如何抉择，才能携带最大价值的研究材料，每种研究材料可以选择无数次，并且可以重复选择。
     * 第一行包含两个整数，N，V，分别表示研究材料的种类和行李空间
     * 接下来包含 N 行，每行两个整数 wi 和 vi，代表第 i 种研究材料的重量和价值
     */
    public static void main(String[] args) {
        int[] wi = {1,2,3,4};
        int[] vi = {2,4,4,5};
        int bagSize = 5;
        System.out.println(completeBag(wi, vi, bagSize));
    }

    private static int completeBag(int[] wi, int[] vi, int bagSize) {
        int size = wi.length;
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < size; i++) {
            for (int j = wi[i]; j <= bagSize; j++) {
                dp[j] = Math.max(dp[j], dp[j - wi[i]] + vi[i]);
            }
        }
        return dp[bagSize];
    }

}
