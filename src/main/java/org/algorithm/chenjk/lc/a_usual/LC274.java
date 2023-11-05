package org.algorithm.chenjk.lc.a_usual;

import java.util.Arrays;

/**
 * @class: LC274
 * @description: 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * @author: jack
 * @create: 2023-10-29 11:51
 **/
public class LC274 {

    public static void main(String[] args) {
        int[] citations = new int[] {3,0,6,1,5};
        citations = new int[] {1, 2, 100};
        System.out.println(hIndex(citations));
    }

    /**
     * 从大到小查找，直到找到 citations[i] <= h 的 h
     * @param citations 引用数组
     * @return h
     */
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 1, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    /**
     * [1,2,100] 时存在问题
     * @param citations 引用数组
     * @return h
     */
    public static int myHIndex(int[] citations) {
        Arrays.sort(citations);
        int hIdx = citations.length / 2 != 0 ? citations.length / 2 - 1 : 0;
        int hRes = citations[hIdx];
        for (int i = hIdx; i < citations.length; i++) {
            int h = citations[i];
            if (h > citations.length) {
                return citations.length;
            }
            if (citations.length - i < h) {
                hIdx = i + 1;
                break;
            }
            hRes = h;
            hIdx = i + 1;
        }
        return Math.min(hRes, hIdx);
    }
}
