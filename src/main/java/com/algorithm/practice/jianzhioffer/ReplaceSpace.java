package com.algorithm.practice.jianzhioffer;

/**
 * Description:
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Date 2020/3/19 23:51
 * Created by kwz
 */
public class ReplaceSpace {

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(handleWithReplace(str));
    }

    /**
     * 用String内置函数处理
     *
     * @param str：input str
     * @return
     */
    private static String handleWithReplace(StringBuffer str) {
        String string = str.toString();
        return string.replace(" ", "%20");
    }
}
