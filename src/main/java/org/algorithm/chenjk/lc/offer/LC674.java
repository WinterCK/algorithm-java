package org.algorithm.chenjk.lc.offer;

/**
 * @class: LC674
 * @description: 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * @author: jack
 * @create: 2023-04-28 00:59
 **/
public class LC674 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        int l = findLengthOfLCIS(nums);
        System.out.println(l);
    }

    public static int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }
        return ans;
    }


}
