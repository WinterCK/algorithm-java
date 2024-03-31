package org.algorithm.chenjk.base.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @class: L90 子集 II
 * @description: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * @author: jack
 * @create: 2024-03-17 16:40
 **/
public class L90 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    static List<List<Integer>> res = new ArrayList<>();
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0);
        return res;
    }


    private static void subsetsWithDupHelper(int[] nums, int start) {
        res.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            // 跳过当前树层使用过的、相同的元素
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            path.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1);
            path.removeLast();
        }
    }

}
