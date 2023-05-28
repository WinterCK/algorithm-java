package org.algorithm.chenjk.base.sort;

import java.util.Arrays;

/**
 * @project: InsertSort
 * @description: 插入排序: 时间 O(N2), 空间 O(1)
 * @author: jack
 * @create: 2022-08-14 17:48
 **/
public class InsertSort {


    public static void main(String[] args) {
        int[] arr = new int[] {2,6,5,4,2,4};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 插入排序: 时间 O(N2), 空间 O(1)
     * 将i {0 -> len-1},左边做为已排好序的数组
     * j = i, j做--循环, 使num[j]插入到左边排好序的数组中
     *
     * @param nums nums
     */
    private static void insertSort(int[] nums) {
        // 每次i循环，<i的都以排好序
        for (int i = 0; i < nums.length; i++) {
            // 每次j 都是把num[j]和比他小的比，一直用tmp替换到已排好序的数组中，使其加入num[j]并排好序
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j - 1];
                    nums[j - 1] = tmp;
                }
            }
        }

    }
}
