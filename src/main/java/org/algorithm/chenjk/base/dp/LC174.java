package org.algorithm.chenjk.base.dp;

/**
 * @class: LC174 地下城游戏
 * @description: 恶魔们抓住了公主并将她关在了地下城dungeon 的 右下角 。地下城是由 m x n 个房间组成的二维网格。
 * 我们英勇的骑士最初被安置在 左上角 的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 要求：返回确保骑士能够拯救到公主所需的最低初始健康点数。
 * 输入：dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
 * 输出：7
 * 解释：如果骑士遵循最佳路径：右 -> 右 -> 下 -> 下 ，则骑士的初始健康点数至少为 7 。
 * @author: jack
 * @create: 2023-05-13 22:15
 **/
public class LC174 {

    /**
     * 解释：leetcode的题一直存在的问题：
     *   所谓的 左上角 按理解正常是（0, max-1）坐标，但构造数组时起始坐标为（0, 0）即左下角
     *   而右下角（max-1, 0）实际坐标为（max-1, max-1）即右上角
     * @param args main
     */
    public static void main(String[] args) {
        int[][] dungeon = new int[][] {
                new int[] {-2, -3,   3},
                new int[] {-5, -10,  1},
                new int[] {10,  30, -5},
        };
        System.out.println(calculateMinimumHP(dungeon));
    }

    /**
     * 动态规划：
     * 如果都是扣血，那方程为：dp[i][j] + num[i][j] = Math.min( dp[i-1][j], dp[i][j-1] )
     * 存在加血：则如果为正数则其实只要0血进来就能满足条件
     * 真正的为：dp[i][j]= Math.max( min(dp[i+1][j],dp[i][j+1]) − dungeon(i,j), 1)
     * 需要从后递归 i-1 -> 0
     *
     * @param dungeon
     * @return
     */
    public static int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        // 设置最后一个值。
        dp[m - 1][n -1] = Math.max(0, -dungeon[m - 1][n - 1]);

        // 设置最后一列的值
        for (int i = m - 2; i >= 0; i--) {
            int needMin = dp[i + 1][n - 1] - dungeon[i][n - 1];
            dp[i][n -1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
        for (int i = n - 2; i >= 0; --i) {
            int needMin = dp[m - 1][i + 1] - dungeon[m - 1][i];
            dp[m - 1][i] = Math.max(0, needMin);
        }

        for (int i = m - 2; i >= 0; --i) {
            for (int j = n - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        return dp[0][0] + 1;

    }
}
