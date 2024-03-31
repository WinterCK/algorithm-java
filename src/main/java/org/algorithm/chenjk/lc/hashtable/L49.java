package org.algorithm.chenjk.lc.hashtable;

import java.util.*;

/**
 * @class: L49 字母异位词分组
 * @description: 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * @author: jack
 * @create: 2024-03-30 14:12
 **/
public class L49 {

    /**
     * O(nklogk) n 是 strs 中的字符串的数量，k 是 strs中的字符串的的最大长度
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String a = String.valueOf(chars);
            if (map.containsKey(a)) {
                map.get(a).add(str);
            } else {
                List<String> res = new ArrayList<>();
                res.add(str);
                map.put(a, res);
            }
        }
        List<List<String>> result = new ArrayList<>();
        map.forEach((key, value) -> result.add(value));
        return result;
    }
}
