package org.algorithm.chenjk.base.dp;

/**
 * @class: LC62 不同路径
 * @description: 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 输入：m = 3, n = 7
 * 输出：28
 * @author: jack
 * @create: 2023-05-11 20:47
 **/
public class LC62 {

    public static void main(String[] args) {
        int m = 51;
        int n = 9;
        System.out.println(uniquePaths(m, n));
        System.out.println(uniquePathsOff(m, n));
        System.out.println(uniquePaths1(m, n));
        System.out.println(uniquePaths2(m, n));
    }

    /**
     * dp[i][j]为最大路径
     * 由于dp[i,j]的上一步可能由两种情况组成 dp[i-1,j] dp[i,j-1]
     * 得方程：dp[i,j] = dp[i-1,j] + dp[i,j+1]
     * 2x3:
     * 1 1 1
     * 1 2 3
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {
        return dpNewWalk(m, n);
    }


    /**
     * dp进行了优化：由递归改成了从左上角开始相加
     *
     * @param m m
     * @param n n
     * @return 路径值
     */
    private static int dpNewWalk(int m, int n) {
        int[][] dp = new int[m][n];
        // 位于左上角，即y轴=n-1的那一行
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        // x轴=0的那一列
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        if (n < 2) {
            return dp[m-1][0];
        }
        int x = 1;
        int y = n - 2;
        while (x < m && y > 0) {
            for (int i = x; i < m; i++) {
                dp[i][y] = dp[i - 1][y] + dp[i][y + 1];
            }
            for (int j = y; j >= 0; j--) {
                dp[x][j] = dp[x - 1][j] + dp[x][j + 1];
            }
            x++;
            y--;
        }
        // y轴已=0
        while (x < m) {
            dp[x][y] = dp[x - 1][y] + dp[x][y + 1];
            x++;
        }
        // x轴=m-1
        while (y > 0 && m >= 2) {
            dp[m - 1][y] = dp[m - 2][y] + dp[m - 1][y + 1];
            y--;
        }
        // 返回右下角的值：即(x,y)坐标系 = (m-1, 0)
        return dp[m - 1][0];
    }

    /**
     * 官方题解
     * @param m m
     * @param n n
     * @return 数量
     */
    public static int uniquePathsOff(int m, int n) {
        int[][] f = new int[m][n];
        // 相当于左下角到右上角
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }


    public static int uniquePaths1(int m, int n) {
        int[][] dp = new int[m][n];

        return dpWalk(dp, m, n, m - 1, 0);
    }

    /**
     * 这么写还是会超时，递归太久，要从左上角开始相加做计算
     *
     * @param dp
     * @param m
     * @param n
     * @param x
     * @param y
     * @return
     */
    public static int dpWalk(int[][] dp, int m, int n, int x, int y) {
        if (x == 0) {
            return 1;
        }
        if (y == n - 1) {
            return 1;
        }
        return dpWalk(dp, m, n, x - 1, y) + dpWalk(dp, m, n, x, y + 1);
    }

    static int nums;

    /**
     * 坐标起始（0, n-1）
     * <p>
     * 退出条件：i,j=0,n-1
     * 问题：速度太慢
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        walk(m, n, 0, n - 1);
        return nums;
    }

    private static void walk(int m, int n, int x, int y) {
        if (x == m - 1 && y == 0) {
            nums++;
            return;
        }
        if (x < m - 1 && y > 0) {
            walk(m, n, x + 1, y);
            walk(m, n, x, y - 1);
            return;
        }
        if (x < m - 1) {
            walk(m, n, x + 1, y);
            return;
        }
        if (y > 0) {
            walk(m, n, x, y - 1);
        }
    }
}
