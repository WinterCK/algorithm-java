package org.algorithm.chenjk.base.sort.heap;

import java.util.Arrays;

/**
 * @class: MinHeap_DescSort 最小堆，用来做降序排序
 * @description: 数组降序排序
 * @author: jason
 * @create: 2023-04-23 22:39
 **/
public class MinHeap_DescSort {


    public static void main(String[] args) {
        int[] nums = {4, 101, 8, 2, 3, 11, 12, 9, 10, 6};
        System.out.println(Arrays.toString(nums));//打印排序前数组
//        buildMinHeapify(nums);
//        System.out.println(Arrays.toString(nums));//打印排序后数组
        descSort(nums);
        System.out.println(Arrays.toString(nums));//打印排序后数组
    }

    /**
     * 降序排序：
     * @param nums nums
     */
    private static void descSort(int[] nums) {
        buildMinHeapify(nums);
        int heapSize = nums.length;
        for (int i = heapSize - 1; i > 0; i--) {
            // 交换，使 length-1 的值为最小值
            swap(nums, 0, i);
            heapSize = heapSize - 1;
            // 交换完重新排序使其保持最小堆, 因为0被交换过，所以从0开始
            minHeapify(nums, 0, heapSize);
        }
    }

    private static void buildMinHeapify(int[] nums) {
        // 从parent开始调整
        int maxParent = parent(nums.length);
        for (int i = maxParent; i >= 0 ; i--) {
            minHeapify(nums, i, nums.length);
        }
    }

    /**
     * 保证heapSize大小内为最小堆： 顶部值最小
     * @param nums 数组
     * @param index parentIndex
     * @param heapSize 堆大小
     */
    private static void minHeapify(int[] nums, int index, int heapSize) {
        int r = right(index);
        int l = left(index);
        int minIndex = index;
        if (l < heapSize && nums[l] < nums[minIndex]) {
            minIndex = l;
        }
        if (r < heapSize && nums[r] < nums[minIndex]) {
            minIndex = r;
        }
        if (minIndex != index) {
            swap(nums, index, minIndex);
            // 由于调整了，继续递归其子树
            minHeapify(nums, minIndex, heapSize);
        }

    }




    private static int parent(int index) {
        // -1/2这里也= 0
        return (index - 1) / 2;
    }

    private static int left(int index) {
        return 2 * index + 1;
    }

    private static int right(int index) {
        return 2 * index + 2;
    }


    public static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
