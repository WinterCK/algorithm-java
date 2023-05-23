package org.algorithm.chenjk.base.greedy;

/**
 * @class: Offer045 把数组排成最小的数
 * @description: 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 输入: [10,2]
 * 输出: "102"
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 * @author: jack
 * @create: 2023-05-23 22:23
 **/
public class Offer045 {

    public static void main(String[] args) {
        int[] nums = new int[] {3, 30, 34, 5, 9};
        System.out.println(minNumber(nums));
    }

    /**
     * 自定义排序：
     * 设置 0 <= x,y < n.length。如果 x + y(330) < y + x (303), 则x,y需交换
     * @param nums
     * @return
     */
    public static String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);

        // 排序并交换
        quickSort(strs, 0, strs.length - 1);

        StringBuilder res = new StringBuilder();
        for(String s : strs) {
            res.append(s);
        }
        return res.toString();

    }

    public static void quickSort(String[] strs, int low, int high) {
        if (low < high) {
            int middle = getMiddle(strs, low, high);
            quickSort(strs, low, middle - 1);
            quickSort(strs, middle + 1, high);
        }
    }

    public static int getMiddle(String[] strs, int low, int high) {
        //数组的第一个数为基准元素
        String temp = strs[low];
        while (low < high) {
            // 从后向前找比基准小的数
            while (low < high && (strs[high] + temp).compareTo(temp + strs[high]) >= 0)
                high--;
            // 把比基准小的数移到低端
            strs[low] = strs[high];
            // 从前向后找比基准大的数
            while (low < high && (strs[low] + temp).compareTo(temp + strs[low]) <= 0)
                low++;
            // 把比基准大的数移到高端
            strs[high] = strs[low];
        }
        // 最后low==high
        strs[low] = temp;
        return low;
    }

}
