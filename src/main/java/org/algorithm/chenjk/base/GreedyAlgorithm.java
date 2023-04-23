package org.algorithm.chenjk.base;

/**
 * @class: GreedyAlgorithm 贪心算法: 贪婪算法是一种分阶段的工作，在每一个阶段，可以认为所做决定是最好的，而不考虑将来的后果
 * 选择的贪心策略必须具备无后效性，即某个状态以后的过程不会影响以前的状态，只与当前状态有关
 * 基本思路：
 * 1. 建立数学模型来描述问题。
 * 2. 把求解的问题分成若干个子问题。
 * 3. 对每一子问题求解，得到子问题的局部最优解。
 * 4. 把子问题的解局部最优解合成原来解问题的一个解。
 * @description:
 * @author: jason
 * @create: 2023-03-26 12:20
 **/
public class GreedyAlgorithm {

    public static void main(String[] args) {
        System.out.println(greedyGiveMoney(546));
        System.out.println(greedyGiveMoney(1456));
    }

    /**
     * 假设1元、2元、5元、10元、20元、50元、100元的纸币，张数不限制，现在要用来支付K元，至少要多少张纸币？
     * @param money k
     */
    private static int greedyGiveMoney(int money) {
        int[] moneyLevel = {1, 2, 5, 10, 20, 50, 100};
        int count = 0;
        for (int i = moneyLevel.length - 1; i >= 0; i--) {
            int num = money / moneyLevel[i];
            System.out.println(moneyLevel[i] + " need " + num + " num");
            count += num;
            int mod = money % moneyLevel[i];
            System.out.println("money 剩余 = " + mod);
            money = mod;
        }
        return count;
    }
}
