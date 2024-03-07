package org.algorithm.chenjk.base.sort.heap;

import java.util.Arrays;

/**
 * @class: MaxHeap 大顶堆: 根节点的数据为最大值
 * @description: 堆排序 O(nlogn)
 * 二叉树： parent = (i - 1) / 2, left = 2 * i + 1, right = 2 * (i + 1)
 * @author: jack
 * @create: 2023-04-23 21:56
 **/
public class MaxHeap_AscSort {

    public static void main(String[] args) {
        int[] nums = {4, 101, 8, 2, 3, 11, 12, 9, 10, 6};
        System.out.println(Arrays.toString(nums));//打印排序前数组
//        buildMaxHeapify(nums);
//        System.out.println(Arrays.toString(nums));//打印排序后数组
        heapAscSort(nums);
        System.out.println(Arrays.toString(nums));//打印排序后数组
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
        int heapSize = nums.length;
        buildMaxHeapify(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i); // 节点 num[length - 1] 为最大值，因此为升序排序
            heapSize = heapSize - 1;     // 通过减小headSize，去掉节点i
            maxHeapify(nums, 0, heapSize);  // 还原位置，避免违反最大堆性质
        }
    }

    /**
     * 创建最大堆
     * @param nums 数组
     */
    private static void buildMaxHeapify(int[] nums) {
        // length最大值-1/2 就等于 他的parent值，即为深度-1的最大值下标，传入parent并一直 -- 来排序所有堆
        int parentIndex = parent(nums.length);
        for (int i = parentIndex; i >= 0; i--) {
            maxHeapify(nums, i, nums.length);
        }
    }

    /**
     * 最大堆调整
     * @param nums 数组
     * @param index parent值
     * @param heapSize 堆size
     */
    private static void maxHeapify(int[] nums, int index, int heapSize) {
        int l = left(index);
        int r = right(index);
        int maxIndex = index;
        // l 和 r 已经过 *2的计算，因此要判断 < heapSize
        if (l < heapSize && nums[l] > nums[maxIndex]) {
            maxIndex = l;
        }
        // 必须跟maxIndex判断
        if (r < heapSize && nums[r] > nums[maxIndex]) {
            maxIndex = r;
        }
        if (maxIndex != index) {
            swap(nums, maxIndex, index);

            // 由于发生了变化，递归调用避免违反最大堆的性质
            maxHeapify(nums, maxIndex, heapSize);
        }

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
