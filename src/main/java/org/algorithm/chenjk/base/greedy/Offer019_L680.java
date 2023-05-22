package org.algorithm.chenjk.base.greedy;

/**
 * @class: Offer019_L680 最多删除一个字符得到回文
 * @description: 给定一个非空字符串 s，请判断如果 最多 从字符串中删除一个字符能否得到一个回文字符串。
 *
 * 示例：
 * 输入: s = "aba"
 * 输出: true
 *
 * 输入: s = "abc"
 * 输出: false
 *
 * @author: jack
 * @create: 2023-05-22 22:27
 **/
public class Offer019_L680 {

    public static void main(String[] args) {
        String s = "abca";
        System.out.println(validPalindromeSlow(s));
        System.out.println(validPalindrome(s));
    }

    /**
     * 贪心：双指针
     * 如果两个指针指向的字符不同，则两个字符中必须有一个被删除，此时我们就分成两种情况：即删除左指针对应的字符，留下子串
     * [low+1:high] 和 [low:high−1] 当这两个子串中至少有一个是回文串时，就说明原始字符串删除一个字符之后就以成为回文串
     *
     * @param s s
     * @return true/false
     */
    public static boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length() -1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                if (isPalindrome(s, low + 1, high) || isPalindrome(s, low, high - 1)) {
                    return true;
                }
                return false;
            }
            low++;
            high--;
        }
        return true;
    }


    /**
     * 枚举每个字符被删除，判断是否是回文，O(N2) 速度慢
     * @param s s
     * @return true/false
     */
    public static boolean validPalindromeSlow(String s) {
        if (s.length() <= 2) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s.substring(0, i) + s.substring(i+1))) {
                return true;
            }
        }
        return false;

    }

    /**
     * 是否为回文串
     * @param s s
     * @return true: 是
     */
    private static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        return isPalindrome(s, i, j);
    }

    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

}
