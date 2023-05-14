package org.algorithm.chenjk.base.dp;

/**
 * @class: LC63 不同路径 2
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物
 *
 * @author: jack
 * @create: 2023-05-13 13:09
 **/
public class LC63 {

    public static void main(String[] args) {
        int[][] obstacleGrid = new int[][] {
                new int[]{0,0},
                new int[]{1,1},
                new int[]{0,0},
        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    /**
     * 和62一样，只是多了if判断, 为1则+0
     * @param obstacleGrid 障碍网格
     * @return 路径树
     */
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) {
            return 0;
        }
        // 几个边界：1, 机器人自身有障碍， 起始点两侧都是障碍
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // (0,0)
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m-1][n-1];

    }

}
