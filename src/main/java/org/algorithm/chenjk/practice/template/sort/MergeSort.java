package org.algorithm.chenjk.practice.template.sort;

import java.util.Arrays;

/**
 * @project: MergeSort
 * @see org.algorithm.chenjk.base.sort.MergeSort
 * @description: 归并排序，稳定排序，O(nlogN), 空间: O(N)
 * @author: jack
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {2,6,5,4,2,4};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] nums) {

    }


}
