package org.algorithm.chenjk.base.dp;

/**
 * @class: LC64 最小路径和
 * @description: 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * @author: jack
 * @create: 2023-05-13 13:53
 **/
public class LC64 {

    public static void main(String[] args) {
        // 数组反过来注入这个方法才是对的。
        int[][] grid = new int[][] {
                new int[]{4,2,1},
                new int[]{1,5,1},
                new int[]{1,3,1},
        };
        System.out.println(minPathSum(grid));
        int[][] grid2 = new int[][] {
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1},
        };
        System.out.println(minPathSubOff(grid2));
    }

    public static int minPathSubOff(int[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(i == 0 && j == 0) {
                    continue;
                } else if(i == 0) {
                    grid[0][j] = grid[0][j - 1] + grid[0][j];
                } else if(j == 0) {
                    grid[i][0] = grid[i - 1][0] + grid[i][0];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    /**
     * // f(i,j)每一步从上[j-1]或从左来[i-1]，即得公式:
     * f(i,j) = Math.min( f(i,j-1), f(i-1, j) ) + f(i,j).num
     * 从左上角[0,n-1] -> 右下角[m-1,0]
     * 边界条件：边界的-1会报错，因此值可直接计算
     *
     * 注：这个方法实现有数组注入顺序的问题: 左下角y轴应=n-1，但是在leetcode里左下角为第一个数组，即y = 0 ......
     * @param grid 网格
     * @return 最小路径和
     */
    public static int minPathSum(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        // 左上角[0,n-1] -> 右下角[m-1,0]
        dp[0][n-1] = grid[0][n-1];
        // 左上角往右走, x轴++
        for (int i = 1; i < m; i++) {
            dp[i][n-1] = dp[i - 1][n-1] + grid[i][n - 1];
        }
        // 左上角往下走, y轴--
        for (int j = n - 2; j >= 0; j--) {
            dp[0][j] = dp[0][j + 1] + grid[0][j];
        }

        // 从左下角的右下位置开始
        int x = 1;
        for (; x < m; x++) {
            for (int y = n - 2; y >= 0; y--) {
                dp[x][y] = Math.min(dp[x][y + 1], dp[x - 1][y]) + grid[x][y];
            }
        }
        return dp[m - 1][0];
    }
}
