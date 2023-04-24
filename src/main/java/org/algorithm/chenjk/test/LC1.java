package org.algorithm.chenjk.test;

import java.util.Arrays;

/**
 * @project: algorithm-test
 * @description:
 * @author: jack
 * @create: 2022-03-01 16:30
 **/
public class LC1 {

    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1};
        int result = removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums) {

        int i = 0;
        int length = nums.length;
        for (int j = 1; j <= length -1 ; j++) {
            if (nums[i] == nums[j]){
                continue;
            } else if (nums[i] < nums[j]) {
                nums[i + 1] = nums[j];
                i++;
            }
        }

        return i + 1;
    }
}
