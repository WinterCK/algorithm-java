package org.algorithm.chenjk.test;

import java.util.Arrays;

/**
 * @project: algorithm-test
 * @description: 189-轮转数组
 * @author: jack
 * @create: 2022-03-06 14:23
 **/
public class LC189 {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5,6,7};
        int k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 额外数组: O(n)
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        int[] temp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int locate = i + k ;
            while (locate - nums.length >= 0) {
                locate = locate - nums.length;
            }

            temp[locate] = nums[i];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i] = temp[i];
        }
//        nums = temp;

    }
    // 1, 2, 3, 4,  size = 4, k =2, 3+2 = 5, 5-4=1,  2+2 =4, = -4 = 0, 0+2 = 2;
}
