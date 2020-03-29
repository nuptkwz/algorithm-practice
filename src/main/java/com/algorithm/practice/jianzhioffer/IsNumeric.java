package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * Date 2020/3/29 14:33
 * Created by kwz
 */
public class IsNumeric {
    public static void main(String[] args) {
        char[] str = {'+', '1', '0', '0'};
        System.out.println(handleWithTryCatch(str));
        System.out.println(handleWithRegex(str));
    }

    /**
     * 将char型数组转成字符串，再用Double的parseDouble方法转成double型数字，
     * 如果能转成功，则返回true。否则会发生NumberFormatException异常。返回false
     * Description
     * Param [str]
     * return boolean
     */
    private static boolean handleWithTryCatch(char[] str) {
        try {
            Double.parseDouble(new String(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    /**
     * 利用正则匹配
     * Description
     * Param [str]
     * return boolean
     */
    private static boolean handleWithRegex(char[] str) {
        String string = new String(str);
        return string.matches("([eE][+-]?[0-9]+)?[+-]?[0-9]*(\\\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }
}
