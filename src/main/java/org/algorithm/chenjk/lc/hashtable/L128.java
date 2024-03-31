package org.algorithm.chenjk.lc.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @class: L128 最长连续序列
 * @description:
 * @author: jack
 * @create: 2024-03-30 14:31
 **/
public class L128 {

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> num_set = new HashSet<Integer>();
        // 将数字全部放入set中
        for (int num : nums) {
            num_set.add(num);
        }
        int longestStreak = 0;
        for (int num : num_set) {
            // 不存在n-1的，即从连续序列的最小的num开始找其 num + 1, 慢慢计算长度
            if (!num_set.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (num_set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

}
