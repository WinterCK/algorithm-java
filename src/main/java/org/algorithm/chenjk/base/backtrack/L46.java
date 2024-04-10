package org.algorithm.chenjk.base.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @class: L46 全排列
 * @description: 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * 输入: [1,2,3]
 * 输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * @author: jack
 * @create: 2024-04-07 20:54
 **/
public class L46 {

    public static void main(String[] args) {
        int[] nums = {1, 2,3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> a : res) {
            System.out.println(a);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(nums, used, result, path);

        return result;
    }

    private static void backtracking(int[] nums, boolean[] used, List<List<Integer>> result, LinkedList<Integer> path) {
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (used[j]) {
                continue;
            }
            int num = nums[j];
            path.add(num);
            used[j] = true;
            backtracking(nums, used, result, path);
            used[j] =  false;
            path.removeLast();
        }

    }
}
