package org.algorithm.chenjk.practice.template.sort;

import java.util.Arrays;

/**
 * @class: MaxHeap 大顶堆: 根节点的数据为最大值
 * @see org.algorithm.chenjk.base.sort.heap.MaxHeap_AscSort
 * @description: 堆排序 O(nlogn)
 * 大顶堆（Max Heap）是一种特殊的二叉堆（Binary Heap），它满足以下性质：
 * 对于任意节点i，其父节点的值大于等于节点i的值；
 * 大顶堆是一棵完全二叉树（Complete Binary Tree），即除了最后一层外，其他层的节点个数都是满的，最后一层的节点都尽量靠左排列。
 * (一般升序排序使用，因大顶堆的0-idx为最大值，可通过0 -> len-1 替换快速将最大的值放到数组最后，后重复构建大顶堆找出第二大的值)
 * @author: jack
 **/
public class MaxHeap_AscSort {

    public static void main(String[] args) {
        int[] nums = {4, 101, 8, 2, 3, 11, 12, 9, 10, 6};
        System.out.println(Arrays.toString(nums));
//        buildMaxHeapify(nums);
//        System.out.println(Arrays.toString(nums));
        heapAscSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 升序排序
     * 1. 先将数组按 最大堆建好
     * 2. 再将最小值的index（即length -1）和 0 做替换，然后再把heapSize -1, 这样 num[length-1]就变最大值，且不参与堆排序
     * 3. 循环替换，最大堆调整后 将 0 和length -2 替换，这样 num[length-2]就变第二大值
     * 无需创建新空间
     * @param nums 数组
     */
    public static void heapAscSort(int[] nums) {

    }

    /**
     * 创建最大堆
     * @param nums 数组
     */
    private static void buildMaxHeapify(int[] nums) {

    }

    /**
     * 最大堆调整
     * @param nums 数组
     * @param index parent值
     * @param heapSize 堆size
     */
    private static void maxHeapify(int[] nums, int index, int heapSize) {


    }



    private static int parent(int i) {
        return (i - 1) / 2;
//        return (int) (Math.floor(i / 2) - 1);
    }

    // i节点的左节点下标
    private static int left(int i) {
        return 2 * i + 1;
    }

    // i节点的右节点下标
    private static int right(int i) {
        return 2 * (i + 1);
    }

    public static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}
