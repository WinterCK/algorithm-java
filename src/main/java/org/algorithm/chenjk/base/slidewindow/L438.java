package org.algorithm.chenjk.base.slidewindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @class: L438 找到字符串中所有字母异位词
 * @description: 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * @author: jack
 * @create: 2024-03-31 22:19
 **/
public class L438 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen < pLen) {
            return res;
        }
        int[] pCnt = new int[26];
        int[] sCnt = new int[26];
        // 前p长度进行字符数量统计
        for(int i = 0; i < pLen; i++){
            pCnt[p.charAt(i) - 'a']++;
            sCnt[s.charAt(i) - 'a']++;
        }
        // 前p个字符都相同，说明从0开始为异位词
        if(Arrays.equals(sCnt, pCnt)){
            res.add(0);
        }
        // 从pLen后开始计算
        for(int i = pLen; i < sLen; i++){
            // 去除最左的字符对应的count
            sCnt[s.charAt(i - pLen) - 'a']--;
            // 新增i新字符对应的count
            sCnt[s.charAt(i) - 'a']++;
            // 如果一样，说明还是异位词
            if(Arrays.equals(sCnt, pCnt)){
                res.add(i - pLen + 1);
            }
        }
        return res;
    }

}
