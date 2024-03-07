package org.algorithm.chenjk.base.dp.base;

/**
 * @class: L509 斐波那契数
 * @description: 通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。
 * 也就是： F(0) = 0，F(1) = 1
 *  F(n) = F(n - 1) + F(n - 2)，其中 n > 1 给你n ，请计算 F(n) 。
 * @author: jack
 * @create: 2024-03-03 18:26
 **/
public class L509 {

    public static void main(String[] args) {
        System.out.println(fib(6));
        System.out.println(fibO1(6));
    }

    public static int fib(int n) {
        if (n <= 1) return n;
        int[] dp = new int[n + 1];
        // 2.确定状态转移方程  dp[i] = dp[i - 1] + dp[i - 2]
        // 3. 数组初始化
        dp[0] = 0;
        dp[1] = 1;
        // 4. 确定遍历顺序并遍历
        for (int i = 2; i <= n; i++) {
            // 5. 举例推导, 需要则print
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 空间复杂度O（1），只存n-1和n-2用来计算
     * @param n n
     * @return fib val
     */
    public static int fibO1(int n) {
        if (n <= 1) return n;
        int[] dp = new int[2];
        // 数组初始化
        // dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
