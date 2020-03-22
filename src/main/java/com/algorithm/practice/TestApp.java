package com.algorithm.practice;

import java.util.HashMap;

/**
 * Description
 * Date 2020/3/21 21:18
 * Created by kwz
 */
public class TestApp {
    public static void main(String[] args) {
        HashMap<String, Object> maps = new HashMap<>(8);
        maps.put("one","1");
        maps.put("two","2");
        maps.put("three","3");
        System.out.println(maps);

        System.out.println(maps.hashCode());
        System.out.println("str".hashCode());
    }
}
