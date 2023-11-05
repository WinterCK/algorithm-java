package org.algorithm.chenjk.lc.search;

/**
 * LC200_DFS 岛屿数量
 * @author jack
 * @description 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 输入：grid = [ ['1','1','0','0','0'],
 *              ['1','1','0','0','0'],
 *              ['0','0','1','0','0'],
 *              ['0','0','0','1','1'] ]
 * 输出：3
 * @date 2023/5/9 15:03
 */
public class LC200_DFS {

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                new char[]{'1','1','0','0','0'},
                new char[]{'1','1','0','0','0'},
                new char[]{'0','0','1','0','0'},
                new char[]{'0','0','0','1','1'},
        };
        int num = numIslands(grid);
        System.out.println(num);
    }

    /**
     * 数组的边界条件：不合法为边界 >=length
     * DFS流程：
     * 1. 循环节点进行遍历（子递归中要对已遍历的染色，不能重复遍历）
     * 2. 边界条件判断编写，到边界退出/异常idx退出
     * 3. 遍历方法中写相关计算条件
     * @param grid 数组
     * @return 数量
     */
    public static int numIslands(char[][] grid) {
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 标记会将其置为2, 以防重复错误计算数量
                if (grid[i][j] == '1') {
                    markIsland(grid, i, j);
                    num++;
                }
            }
        }
        return num;
    }

    private static void markIsland(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y >= grid[x].length || y < 0) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            markIsland(grid, x - 1, y);
            markIsland(grid, x + 1, y);
            markIsland(grid, x, y - 1);
            markIsland(grid, x, y + 1);
        }

    }
}
