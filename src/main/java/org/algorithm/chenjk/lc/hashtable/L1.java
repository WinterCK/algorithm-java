package org.algorithm.chenjk.lc.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @project: algorithm-test
 * @description: 1. 两数之和: 给定一个整数数组 nums 和一个整数目标值 target，
 * 请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标
 * @author: chenjk
 * @create: 2022-08-14 17:55
 **/
public class L1 {

    public static void main(String[] args) {
        int[] nums = {3,2,4};
        int[] res = twoSumByMe(nums, 6);
        System.out.println(Arrays.toString(res));
    }

    /**
     * 简单做法：2个下标顺序增加，直到等于target则推出, 时间：O(N2), 空间O(1)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSumByMe(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        res[0] = i;
                        res[1] = j;
                        return res;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 哈希表：时间和空间都是O(N)
     * key: 其中一个value, value: 其下标index
     *  如: a + b = target  for i =a, 则 hashTable的 key 为 b = target-num[i]
     *  即 num[i] + target-num[i]  = target
     *  哈希表查询key O(1)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // key: value, val: index
        Map<Integer, Integer> hashtable = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }



}
