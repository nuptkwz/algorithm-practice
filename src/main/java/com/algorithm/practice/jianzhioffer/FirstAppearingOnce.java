package com.algorithm.practice.jianzhioffer;

import java.util.*;

/**
 * Description
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，
 * 第一个只出现一次的字符是"l"。
 * Date 2020/3/29 19:47
 * Created by kwz
 */
public class FirstAppearingOnce {
    private static LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<>();

    public static void main(String[] args) {
        char param = 'g';
        insert(param);
        System.out.println(firstAppearingOnce());
    }

    private static void insert(char ch) {
        if (lhm.containsKey(ch)) {
            lhm.put(ch, lhm.get(ch) + 1);
        } else {
            lhm.put(ch, 1);
        }
    }

    //return the first appearance once char in current string stream
    private static char firstAppearingOnce() {
        for (Map.Entry<Character, Integer> shs : lhm.entrySet()) {
            if (shs.getValue() == 1) {
                return shs.getKey();
            }
        }
        return '#';
    }
}
