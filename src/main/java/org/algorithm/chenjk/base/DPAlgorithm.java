package org.algorithm.chenjk.base;

/**
 * @project: algorithm-test
 * @description: dynamic programming 动态规划
 * 对于一个可拆分问题中
 * 存在可以由前若干项计算 当前项的问题
 * 可以由动态规算法
 * @author: jason
 * @create: 2022-03-16 23:41
 **/
public class DPAlgorithm {

    public static void main(String[] args) {
        int[][] d = new int[][] {
                {8,0,0,0,0},
                {12,15,0,0,0},
                {3,9,6,0,0},
                {8,10,5,12,0},
                {16,4,18,10,9}};
        System.out.println(dpFunc(d, 5));
    }

    /**
     * DP动态规划
     * 例题：数字三角形问题: 从最上方 只能左下 或右下走，找出最大和的路径, 求经过的数字和的最大值
     * 5
     * 3 8
     * 8 1 0
     * 2 7 4 4
     * 4 5 2 6 5
     *
     * D(r, j) 第r行第j个数字
     * MaxSum(r, j) 最佳路径之和
     *
     * D(r, j) 左下或右下，表示为 D(r+1,j), D(r+1, j+1)
     *
     * 所以对于N行的三角形，有如下公式: 状态转移方程
     * if (r == N)
     *   MaxSum(r, j) = D(r, j)
     * else
     *   Max(r, j) = Max( MaxSum(r+1,j), MaxSum(r+1, j+1) ) + D(r, j)
     *
     *   jason:
     *   状态定义: f(i，j)是第i行j列项最大取数和，求第n行 fn，m（0 < m < n）中最大值。
     *   f(i,j) = max{ f(i-1, j), f(i-1, j-1)} + num[i,j]
     *   if[i=0], f(i,j) = num(i,j)
     *
     *
     */
    private static int dpFunc(int[][] nums, int n) {
        // 额外开辟一个数组空间用来存 f(i,j)坐标的max值
        int[][] maxNums = new int[n][n];
        int max = 0;
        for (int i = 0; i <= n-1; i++) {
            for (int j = 0; j <= i; j++) {
                // 边界条件提前处理
                if (i == 0) {
                    maxNums[0][j] = nums[0][j];
                    continue;
                }
                if (j == 0) {
                    maxNums[i][0] = maxNums[i-1][0] + nums[i][0];
                    continue;
                }
                // f(i,j) = max{ f(i-1, j), f(i-1, j-1)} + num[i,j]
                maxNums[i][j] = Math.max(maxNums[i-1][j], maxNums[i-1][j-1]) + nums[i][j];
                max = Math.max(max, maxNums[i][j]);
            }
        }
        // 获取第n行的 最大值
//        int max1 = 0;
//        for (int i = 1; i <= n-1; i++) {
//            max1 = Math.max(maxNums[n-1][i], max1);
//        }
//        System.out.println(max1);
        return max;
    }

    /**
     * 背包问题：有n件物品和一个最多能背重量为 w 的背包。第i件物品的重量是weight[i]，得到的价值是value[i]，求最大价值
     *  背包问题无法用贪心求最优解，是典型的动态规划问题。背包问题还可以分成3种：① 0-1背包、② 完全背包、③ 多重背包。
     *  ① 0-1背包：每种物品是一件，0/1背包顾名思义就是0和1两种状态，即每个物品装入和不装入背包这两种状态
     *  ② 完全背包：每种物品是无限件
     *  ③ 多重背包：每种物品是有限件
     *  解：用 dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少
     *  dp[i][j] = if w[i]<j, max(dp[i-1][j], value[i]+ dp[i-1][j-weight[i-1]]) else = dp[i-1][j]
     *
     */
    private static int knap(int[] weight, int[] value, int bagWeight) {
        if (bagWeight <= 0) {
            return 0;
        }
        int[][] dp = new int[weight.length + 1][weight.length + 1];
        for (int i = 0; i < weight.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < weight.length; i++) {
            // j 表示从1开始计算最大价值，直到 j = bagWeight重量
            for (int j = 1; j <= bagWeight; j++) {
                if (j < weight[i - 1]){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    // dp[i-1][j - weight[i - 1]] 不放物品i时的最大价值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                }

            }

        }
        return dp[value.length][bagWeight];

    }
}
