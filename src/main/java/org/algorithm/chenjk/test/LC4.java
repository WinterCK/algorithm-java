package org.algorithm.chenjk.test;

import java.util.Arrays;

/**
 * @project: algorithm-test
 * @description: 977 有序数组的平方
 * @author: jack
 * @create: 2022-03-06 14:43
 **/
public class LC4 {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        System.out.println(Arrays.toString(sortedSquares2(nums)));
    }

    /**
     * O(nlogN)
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];

        }
        Arrays.sort(nums);
        return nums;
    }

    /**
     * O(n), 归并思路
     * @param nums
     * @return
     */
    public static int[] sortedSquares2(int[] nums) {
        int x = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                x = i;
            }
        }
        // 全为正数，已有序，直接乘
        if (x == -1) {
            return square(nums);
        }
        // 归并 0 - x, x+1 - n-1;
        // 最小的为 x 或x + 1, 左半部分从右到左计算 -- ， 右半部分从左到右计算 ++
        int low = 0;
        int high = nums.length - 1;
        int mid = x;

        int mi2 = mid + 1;
        int[] tmp = new int[nums.length];
        int i = 0;
        while (mid >= low && mi2 <= high) {
            int num1 = nums[mid] * nums[mid];
            int num2 = nums[mi2] * nums[mi2];
            if (num1 < num2) {
                tmp[i] = num1;
                i++;
                mid--;
            } else {
                tmp[i]= num2;
                i++;
                mi2++;
            }
        }
        while (mid >= low) {
            tmp[i] = nums[mid] * nums[mid];
            i++;
            mid--;
        }
        while (mi2 <= high) {
            tmp[i] = nums[mi2] * nums[mi2];
            i++;
            mi2++;
        }
        return tmp;
    }

    private static int[] square(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        return nums;
    }
}
