package org.algorithm.chenjk.lc.matrix;

import java.util.Arrays;

/**
 * @project: algorithm-test
 * @description: L2373 矩阵题, matrix: 矩阵
 * 给你一个大小为 n x n 的整数矩阵 grid 。
 * 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵 maxLocal ，并满足：
 * maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。
 * 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。
 *
 * 返回生成的矩阵
 * @author: chenjk
 * @create: 2023-03-01 23:06
 **/
public class L2373 {

    public static void main(String[] args) {
        int[][] grid = new int[][] {
                new int[]{9,9,8,1},
                new int[]{5,6,2,6},
                new int[]{8,2,6,4},
                new int[]{6,2,2,2}
        };
        int[][] res = largestLocal(grid);
        System.out.println(Arrays.deepToString(res));
    }

    /**
     * 暴力取值，每次计算相关值的max并返回. 时间: O(N2), 空间: O(1)
     * @param grid 二维矩阵input
     * @return
     */
    public static int[][] largestLocal(int[][] grid) {
        int[][] res = new int[grid.length-2][grid.length-2];

        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                res[i][j] = maxValInGrid(grid, i, j);
            }
        }
        return res;
    }

    /**
     * 暴力计算，针对x,y 将从x,y -> x+2,y+2 的所有值遍历一遍，取出最大值
     * 由于这个循环是特定 3 X 3的循环，为确定逻辑，不为时间复杂度O(N2)
     * @param grid 二维数组
     * @param x 当前res的x轴
     * @param y 当前res的y轴
     * @return maxVal
     */
    private static int maxValInGrid(int[][] grid, int x, int y) {
        int max = 0;
        // x,y; x,y+1; x,y+2; x+1,y; x+1,y+1, x+1,y+2,
        for (int i = x; i <= x+2; i++) {
            for (int j = y; j <= y+2 ; j++) {
                if (grid[i][j] >= max) {
                    max = grid[i][j];
                }
            }
        }
        return max;
    }
}
