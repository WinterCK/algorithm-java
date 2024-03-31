package org.algorithm.chenjk.base.slidewindow;

import java.util.LinkedList;

/**
 * @class: L3 无重复字符的最长子串
 * @description: 给定一个字符串 s ，请你找出其中不含有重复字符的 最长
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @author: jack
 * @create: 2024-03-31 22:17
 **/
public class L3 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int maxLen = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (int j = 0; j < s.length(); j++) {
            char cur = s.charAt(j);
            if (!list.contains(cur)) {
                list.add(cur);
                maxLen = Math.max(maxLen, list.size());
            } else {
                while (list.contains(cur)) {
                    list.removeFirst();
                }
                list.add(cur);
            }
        }
        return maxLen;
    }
}
