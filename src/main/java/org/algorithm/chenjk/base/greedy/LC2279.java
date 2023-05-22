package org.algorithm.chenjk.base.greedy;

import java.util.Arrays;

/**
 * @class: LC2279 装满石头的背包的最大数量
 * @description: 现有编号从0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。
 * 第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了 rocks[i] 块石头。
 * 另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
 * 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
 *
 * 输入：capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
 * 输出：3
 * 解释：1 块石头放入背包 0 ，1 块石头放入背包 1 。 每个背包中的石头总数是 [2,3,4,4] 。
 *
 * 输入：capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
 * 输出：3
 * @author: jack
 * @create: 2023-05-20 13:10
 **/
public class LC2279 {

    public static void main(String[] args) {
        int[] capacity = new int[] {2, 3, 4, 5};
        int[] rocks = new int[] {1, 2, 4, 4};
        int add = 2;
        System.out.println(maximumBags(capacity, rocks, add));
    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int[] remainCap = new int[capacity.length];
        int initLen = 0;
        for (int i = 0; i < capacity.length; i++) {
            remainCap[i] = capacity[i] - rocks[i];
        }
        // 排序后从idx 0开始就是默认贪心策略
        Arrays.sort(remainCap);
        for (int i = 0; i < remainCap.length; i++) {
            if (additionalRocks == 0 || initLen == remainCap.length) {
                return initLen;
            }
            if (additionalRocks >= remainCap[i]) {
                additionalRocks = additionalRocks - remainCap[i];
                initLen++;
            } else {
                return initLen;
            }
        }
        return initLen;
        // 不排序逻辑, O(n2)
//        for (int i = 0; i <= additionalRocks; i++) {
//            for (int j = 0; j < remainCap.length; j++) {
//                if (additionalRocks == 0 || initLen == capacity.length) {
//                    return initLen;
//                }
//                if (remainCap[j] == i && additionalRocks >= i) {
//                    additionalRocks = additionalRocks - i;
//                    remainCap[j] = 0;
//                    initLen++;
//                }
//            }
//        }
//        return initLen;
    }
}
