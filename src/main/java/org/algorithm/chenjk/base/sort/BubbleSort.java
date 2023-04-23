package org.algorithm.chenjk.base.sort;

import java.util.Arrays;

/**
 * @project: BubbleSort
 * @description: 冒泡排序：时间 O(N2), 空间 O(1)
 * @author: jason
 * @create: 2022-03-03 22:09
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2,6,5,4,2,4};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序：时间 O(N2), 空间 O(1)
     * 双层循环，主要第二层循环次数为 j < length - i - 1
     * @param nums nums
     */
    private static void bubbleSort(int[] nums) {
        int tmp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j +1] = tmp;
                }
            }
        }
    }
}
