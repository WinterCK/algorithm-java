package org.algorithm.chenjk.base.sort;

import java.util.Arrays;

/**
 * @project: MergeSort
 * @description: 归并排序，稳定排序，O(nlogN), 空间: O(N)
 * @author: chenjk
 * @create: 2022-03-03 22:18
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2,6,5,4,2,4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        sort(nums, low, high);
    }

    /**
     * 递归: 只要low < high, 就持续分解,
     * 归并方法：merge方法包含 low, mid, high
     * @param nums 数组
     * @param low low
     * @param high high
     */
    private static void sort(int[] nums, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(nums, low, mid);
            sort(nums, mid +1, high);
            merge(nums, low, mid, high);
        }
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = new int[high - low + 1]; // 分配新的地址空间
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j<= high) {
            if (nums[i] < nums[j]) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }

        // j 跑完了
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }

        // i 跑完了（左边的数组）
        while (j <= high) {
            tmp[k++] = nums[j++];
        }

        // 将tmp排好序的值放到 nums原数组中
        for (int x = 0; x < tmp.length; x++ ) {
            nums[x + low] = tmp[x];
        }
        // x循环 和while循环 两种方式都可以
//        int m = 0;
//        while (low <= high) {
//            nums[low++] = tmp[m++];
//        }
    }


}
