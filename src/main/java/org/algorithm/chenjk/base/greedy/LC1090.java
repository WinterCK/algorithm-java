package org.algorithm.chenjk.base.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @class: LC1090 受标签影响的最大值
 * @description: 我们有一个n项的集合。给出两个整数数组values和 labels，第 i 个元素的值和标签分别是values[i]和labels[i]。
 * 还会给出两个整数numWanted和 useLimit 。返回子集 s 的最大 分数
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 *
 *
 * @author: jack
 * @create: 2023-05-23 21:56
 **/
public class LC1090 {

    public static void main(String[] args) {
        int[] values = new int[] {5,4,3,2,1};
        int[] labels = new int[] {1,3,3,3,2};
        System.out.println(largestValsFromLabels(values, labels, 3, 2));
        System.out.println(largestValsFromLabels1(values, labels, 3, 2));

    }

    /**
     * 排序 + 哈希表 O(n2)
     * @param values v
     * @param labels l
     * @param numWanted n
     * @param useLimit u
     * @return max
     */
    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        if (values.length == 1) {
            return values[0];
        }
        // 1. 排序
        sort(values, labels);
        Map<Integer, Integer> hashTab = new HashMap<>();
        int maxVal = 0;
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            int label = labels[i];
            if (!hashTab.containsKey(label)) {
                hashTab.put(label, 1);
                maxVal += values[i];
                count++;
            } else {
                int labelCount = hashTab.get(label);
                if (labelCount < useLimit) {
                    hashTab.put(label, labelCount + 1);
                    maxVal += values[i];
                    count++;
                } else {
                    continue;
                }
            }
            if (count == numWanted) {
                return maxVal;
            }
            
        }
        return maxVal;

    }

    /**
     * 排序优化
     */
    public static int largestValsFromLabels1(int[] values, int[] labels, int numWanted, int useLimit) {
        if (values.length == 1) {
            return values[0];
        }
        // 1. 排序优化：再开辟一个数组，存储原数组下标，然后对新数据排序即可
        Integer[] id = new Integer[values.length];
        for (int i = 0; i < values.length; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (a, b) -> values[b] - values[a]);
        Map<Integer, Integer> hashTab = new HashMap<>();
        int maxVal = 0;
        int count = 0;
        for (int i = 0; i < values.length; i++) {
            int label = labels[id[i]];
            if (!hashTab.containsKey(label)) {
                hashTab.put(label, 1);
                maxVal += values[id[i]];
                count++;
            } else {
                int labelCount = hashTab.get(label);
                if (labelCount < useLimit) {
                    hashTab.put(label, labelCount + 1);
                    maxVal += values[id[i]];
                    count++;
                } else {
                    continue;
                }
            }
            if (count == numWanted) {
                return maxVal;
            }

        }
        return maxVal;

    }

    private static void sort(int[] values, int[] labels) {
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length - i - 1; j++) {
                if (values[j] < values[j+1]) {
                    int tmp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = tmp;
                    tmp = labels[j];
                    labels[j] = labels[j+1];
                    labels[j+1] = tmp;
                }
            }

        }

    }
}
