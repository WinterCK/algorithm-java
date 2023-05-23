package org.algorithm.chenjk.base.greedy;

/**
 * @class: LC11 盛最多水的容器
 * @description: 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 返回容器可以储存的最大水量。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。
 *
 * @author: jack
 * @create: 2023-05-23 22:42
 **/
public class LC11 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    /**
     * 贪心，双指针
     * 两个坐标的面积： min(height(i), height(j)) * (j - i) ，即 高(宽)度 * 长度
     * 这里的关键判断为：if: height(i) < height(j), 则i++, 否则j--。高度小的需要移动
     *
     * @param height 数组
     * @return maxArea
     */
    public static int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
            max = Math.max(max, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }
}
