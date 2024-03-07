package org.algorithm.chenjk.lc.array;

import java.util.Arrays;

/**
 * @class: LC27 移除元素
 * @description: 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author: jack
 * @create: 2024-01-08 21:45
 **/
public class LC27 {

    public static void main(String[] args) {
        int[] arr = new int[] {2,6,5,4,2,4};
        System.out.println(removeElement(arr, 2));
        System.out.println(Arrays.toString(arr));
    }
    /**
     * 快慢指针：等于val值时, slowIndex不动，不相等时才动
     * @param nums 数组
     * @param val val
     * @return remove后的数组长度，后续的值均为无效值
     */
    public static int removeElement(int[] nums, int val) {
        int slowIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (val != nums[i]) {
                nums[slowIndex++] = nums[i];
            }
        }
        return slowIndex;
    }
}
