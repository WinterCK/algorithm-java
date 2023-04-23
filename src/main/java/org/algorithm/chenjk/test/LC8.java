package org.algorithm.chenjk.test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project: algorithm-test
 * @description: 17 电话号码字母组合
 * @author: chenjk
 * @create: 2022-03-17 00:10
 **/
public class LC8 {
    public static void main(String[] args) {
        String s= "2756";
        System.out.println(letterCombinations(s));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        backtrack(combinations, digits, 0, new StringBuffer());
        return combinations;
    }

    static Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    /**
     * 递归计算
     * @param combinations
     * @param digits
     * @param index
     * @param combination
     */
    public static void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

}
