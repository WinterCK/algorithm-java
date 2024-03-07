package org.algorithm.chenjk.base.dp.bag;

/**
 * @class: Lama46 https://kamacoder.com/problempage.php?pid=1046
 * @description: 01 背包 有n件物品和一个最多能背重量为w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i] 。
 * 每件物品只能用一次，求解将哪些物品装入背包里物品价值总和最大。
 * @author: jack
 * @create: 2024-03-05 20:28
 **/
public class Kama46 {

    public static void main(String[] args) {
        int[] weight = {1,3,4};
        int[] value = {15,20,30};
        int bagSize = 4;
        System.out.println(testWeightBagProblem(weight, value, bagSize));
        int[] nums = {1,5,11,5};
        int res = testWeightBagProblem(nums, nums, (1+11+10) /2);
        System.out.println(res == (1+11+10) /2);
    }

    /**
     * dp[i][j]的含义：从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
     * 不放物品i：由dp[i - 1][j]推出，即背包容量为j，里面不放物品i的最大价值，此时dp[i][j]就是dp[i - 1][j]。(其实就是当物品i的重量大于背包j的重量时，物品i无法放进背包中，所以背包内的价值依然和前面相同。)
     * 放物品i：由dp[i - 1][j - weight[i]]推出，dp[i - 1][j - weight[i]] 为背包容量为j - weight[i]的时候不放物品i的最大价值，
     * 那么dp[i - 1][j - weight[i]] + value[i] （物品i的价值），就是背包放物品i得到的最大价值
     *
     * 递归公式： dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
     *
     * 初始化: 如果背包容量j为0的话，即dp[i][0]，无论是选取哪些物品，背包价值总和一定为0
     * dp[0][j]，即：i为0，存放编号0的物品的时候，各个容量的背包所能存放的最大价值。
     * 当 j < weight[0]的时候，dp[0][j] 应该是 0，因为背包容量比编号0的物品重量还小。
     */
    public static int testWeightBagProblem(int[] weight, int[] value, int bagSize){

        // 创建dp数组
        int goods = weight.length;  // 获取物品的数量
        int[][] dp = new int[goods][bagSize + 1];

        // 初始化: 重量为0时，放哪个物品都放不进，初始化为0 （代码可忽略）
        for (int i = 0; i < goods; i++) {
            dp[i][0] = 0;
        }
        // 初始化: 放不进第一个物品的重量，那些都初始化为0 （代码可忽略）
        for (int j = 0 ; j < weight[0]; j++) {
            dp[0][j] = 0;
        }
        // 初始化: 放入第一个物品后, 第一个重量对应的 value
        for (int j = weight[0]; j <= bagSize; j++) {
            dp[0][j] = value[0];
        }

        // 填充dp数组
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                // 当前临时背包j的容量都没有当前物品i大的时候，是不放物品i的, 那么前i-1个物品能放下的最大价值就是当前情况的最大价值
                if (j < weight[i]) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 当前背包的容量可以放下物品i, 比较 1、不放物品i 和 2、放物品i 两种情况下，哪种背包中物品的最大价值最大
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight[i]] + value[i]);
                }
            }
        }

        // 打印dp数组
        for (int i = 0; i < goods; i++) {
            for (int j = 0; j <= bagSize; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println("\n");
        }
        return dp[goods - 1][bagSize];
    }
}
