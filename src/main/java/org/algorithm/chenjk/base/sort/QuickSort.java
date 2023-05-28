package org.algorithm.chenjk.base.sort;

import java.util.Arrays;

/**
 * @project: QuickSort
 * @description: 快速排序 O(nlogn) 空间 O(1)
 * @author: jack
 * @create: 2022-08-14 17:46
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {6,2,5,4,2,4};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param nums 数组
     */
    private static void quickSort(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        quickSort(nums, low, high);
    }

    private static void quickSort(int[] nums, int low, int high) {
        // 结束循环
        if (low >= high) {
            return;
        }
        int i = low, j = high;
        int pivot = nums[low]; // 也可以随机取值，尽量到nLogN
        while (i < j) {
            // j和i的两个while是有强制的顺序要求的，必须优先找到比 pivot 小的值，否则结果会错误(i会先++增大)
            while (nums[j] >= pivot && i < j) {
                j--; // 右边直到找到比 pivot 小的值
            }
            while (nums[i] <= pivot && i < j) {
                i++; // 直到左边找到比 pivot 大的值
            }
            if (i < j) {
                // 都找到了，交换
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        // i>=j了，说明左右两边都走了一轮了, 交换pivot 和 i的位置
        nums[low] = nums[i];
        nums[i] = pivot;
        System.out.println(Arrays.toString(nums));
        // 继续拆分
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }
}
