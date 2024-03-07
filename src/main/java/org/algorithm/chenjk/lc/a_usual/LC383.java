package org.algorithm.chenjk.lc.a_usual;

import java.util.HashMap;
import java.util.Map;

/**
 * @class: LC383 赎金信 https://leetcode.cn/problems/ransom-note/solutions/1135839/shu-jin-xin-by-leetcode-solution-ji8a
 * @description: 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * @author: jack
 * @create: 2024-01-07 12:45
 **/
public class LC383 {

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
        System.out.println(canConstructOff(ransomNote, magazine));
        System.out.println('d' - 'a');
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            if (magazineMap.containsKey(c)) {
                magazineMap.put(c, magazineMap.get(c) + 1);
            } else {
                magazineMap.put(c, 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char note = ransomNote.charAt(i);
            if (!magazineMap.containsKey(note)) {
                return false;
            }
            Integer count = magazineMap.get(note);
            if (count == 1) {
                magazineMap.remove(note);
            } else {
                magazineMap.put(note, count - 1);
            }
        }
        return true;
    }

    public static boolean canConstructOff(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        for (char c : magazine.toCharArray()) {
            cnt[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            cnt[c - 'a']--;
            if(cnt[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
