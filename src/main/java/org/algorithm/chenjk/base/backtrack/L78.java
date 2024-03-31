package org.algorithm.chenjk.base.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @class: L78 子集
 * @description: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * @author: jack
 * @create: 2024-03-17 16:16
 **/
public class L78 {


    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(subsets(nums));
    }

    static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
    static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果

    /**
     * 回溯算法的模版：
     * void backtracking(参数) {
     *     if (终止条件) {
     *         存放结果;
     *         return;
     *     }
     *
     *     for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
     *         处理节点;
     *         backtracking(路径，选择列表); // 递归
     *         回溯，撤销处理结果
     *     }
     * }
     *
     */
    public static List<List<Integer>> subsets(int[] nums) {
        subsetsHelper(nums, 0);
        return result;
    }

    private static void subsetsHelper(int[] nums, int startIndex) {
        //「遍历这个树的时候，把所有节点都记录下来，就是要求的子集集合」。
        result.add(new ArrayList<>(path));
        System.out.println(path);
        if (startIndex >= nums.length){ //终止条件可不加
            return;
        }
        for (int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            subsetsHelper(nums, i + 1);
            path.removeLast();
        }
    }

}
