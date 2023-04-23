package org.algorithm.chenjk.test;

import java.util.Stack;

/**
 * @project: algorithm-test
 * @description: 12 整数转罗马
 * @author: chenjk
 * @create: 2022-03-16 23:58
 **/
public class LC7 {

    public static void main(String[] args) {

        System.out.println(intToRoman(3569));
    }


    static String[] thousands = {"", "M", "MM", "MMM"};
    static String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

    public static String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        roman.append(thousands[num / 1000]);
        roman.append(hundreds[num % 1000 / 100]);
        roman.append(tens[num % 100 / 10]);
        roman.append(ones[num % 10]);
        return roman.toString();
    }

}
