package org.algorithm.chenjk.test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @project: algorithm-test
 * @description: 存在重复元素
 * @author: chenjk
 * @create: 2022-03-14 18:33
 **/
public class LC5 {

    public static void main(String[] args) {
        int[] nums = new int[]{-4,-1,0,3,10};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }
}
