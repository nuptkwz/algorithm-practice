package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Author  kwz
 * date 2020/3/21 21:04
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");

        String withReplace = handleWithReplace(str);
        System.out.println("withReplace:" + withReplace);

        String withCharAt = handleWithCharAt(str);
        System.out.println("withCharAt:" + withCharAt);

        String withString = handleWithString(str);
        System.out.println("withString:" + withString);

        String string = handleWithString(str);
        System.out.println("string：" + string);
    }

    /**
     * Description 用String内置函数处理
     * Param [str]
     * return java.lang.String
     */
    private static String handleWithReplace(StringBuffer str) {
        String string = str.toString();
        return string.replace(" ", "%20");
    }

    /**
     * Description 用StringBuffer来实现
     * Param [str]
     * return java.lang.String
     */
    private static String handleWithCharAt(StringBuffer str) {
        StringBuilder sb = new StringBuilder();
        String string = str.toString();
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ')
                sb.append(string.charAt(i));
            else
                sb.append("%20");
        }
        return sb.toString();
    }

    /**
     * Description 通过string 字符串来处理
     * Param [str]
     * return java.lang.String
     */
    private static String handleWithString(StringBuffer str) {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (curChar == ' ') {
                resultStr.append("%20");
            } else {
                resultStr.append(curChar);
            }
        }
        return resultStr.toString();
    }
}
