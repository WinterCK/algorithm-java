package org.algorithm.chenjk.base.dp.bag.comlete;

import java.util.Arrays;
import java.util.List;

/**
 * @class: L139 单词拆分
 * @description: 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 * @author: jack
 * @create: 2024-03-10 15:09
 **/
public class L139 {

    public static void main(String[] args) {
        // 1. 确定dp数组以及下标的含义
        // dp[i] : 字符串长度为i的话，dp[i]为true，表示可以拆分为一个或多个在字典中出现的单词。
        // 2. 确定递推公式: 如果确定dp[j] 是true，且 [j, i] 这个区间的子串出现在字典里，那么dp[i]一定是true。（j < i ）。
        // 所以递推公式是 if([j, i] 这个区间的子串出现在字典里 && dp[j]是true) 那么 dp[i] = true。
        //
        // 3. dp数组如何初始化: 从递推公式中可以看出，dp[i] 的状态依靠 dp[j]是否为true，那么dp[0]就是递推的根基，dp[0]一定要为true，否则递推下去后面都都是false了。
        // 那么dp[0]有没有意义呢？ dp[0]表示如果字符串为空的话，说明出现在字典里。
        // 但题目中说了“给定一个非空字符串 s” 所以测试数据中不会出现i为0的情况，那么dp[0]初始为true完全就是为了推导公式。
        String s = "applepenapple";
        String[] wordDict = {"apple", "pen"};
        System.out.println(wordBreak(s, Arrays.asList(wordDict)));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < wordDict.size(); j++) {
                int len = wordDict.get(j).length();
                if (i - len >= 0) {
                    // 上一个单词的dp长度为true，且从上一个的长度到i的词包含了本次j的单词。
                    // 无substring(i - wordDict.get(j).length(), i) 则s:"andog", word:["and","dog"]会误判为true
                    if (dp[i - len] && s.substring(i - len, i).contains(wordDict.get(j))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }

}
