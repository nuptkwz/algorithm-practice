package com.algorithm.practice.jianzhioffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Description
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * Date 2020/3/28 18:02
 * Created by kwz
 */
public class DuplicateNumber {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int[] duplication = new int[1];
        System.out.println("violenceSolve:" + violenceSolve(numbers, numbers.length, duplication));
        System.out.println("handleWithListContains:" + handleWithListContains(numbers, numbers.length, duplication));
        System.out.println("handleWithHashSet:" + handleWithHashSet(numbers, numbers.length, duplication));
        System.out.println("handleWithStringBuffer:" + handleWithStringBuffer(numbers, numbers.length, duplication));
        System.out.println("handleWithArray:" + handleWithArray(numbers, numbers.length, duplication));
    }


    /**
     * 两层for循环遍历，暴力求解，时间复杂度为o(n^2)
     * Description
     * Param [numbers, length, duplication]
     * return boolean
     */
    private static boolean violenceSolve(int[] numbers, int length, int[] duplication) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (numbers[i] == numbers[j]) {
                    duplication[0] = numbers[i];
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 用list的contains方法，要是存在contains方法返回true，赋值duplication[0]，否则返回false(同理可以用hashSet)
     * Description
     * Param [numbers, length, duplication]
     * return boolean
     */
    private static boolean handleWithListContains(int[] numbers, int length, int[] duplication) {
        List<Integer> noDuplicateList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (noDuplicateList.contains(numbers[i])) {
                duplication[0] = numbers[i];
                return true;
            } else {
                noDuplicateList.add(numbers[i]);
            }
        }
        return false;
    }

    /**
     * Description 用hashSet的add方法，要是存在add，它就会返回false
     * Param [numbers, length, duplication]
     * return boolean
     */
    private static boolean handleWithHashSet(int[] numbers, int length, int[] duplication) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < length; i++) {
            boolean flag = set.add(numbers[i]);
            if (!flag) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * Description indexOf和lastIndexOf分别返回sb中同一个字符第一次和最后一次出现的位置，如果不相同，那么即为重复
     * Param [numbers, length, duplication]
     * return boolean
     */
    private static boolean handleWithStringBuffer(int[] numbers, int length, int[] duplication) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append(numbers[i]);
        }

        for (int i = 0; i < length; i++) {
            if (stringBuilder.indexOf(numbers[i] + "") != stringBuilder.lastIndexOf(numbers[i] + "")) {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }

    /**
     * 利用数组下标唯一性的特性，标记已经遍历的元素
     * Description
     * Param [numbers, length, duplication]
     * return boolean
     */
    private static boolean handleWithArray(int[] numbers, int length, int[] duplication) {
        boolean[] k = new boolean[length];
        for (int i = 0; i < k.length; i++) {
            if (k[numbers[i]]) {
                duplication[0] = numbers[i];
                return true;
            }
            k[numbers[i]] = true;
        }
        return false;
    }
}
