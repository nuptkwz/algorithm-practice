package com.algorithm.practice.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Description
 * Date 2020/5/6 23:37
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组
 * {2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为
 * {4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * Created by kwz
 */
public class MaxInWindows {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        System.out.println(maxInWindowsWithPriorityQueue(arr, size));
    }

    /**
     * Description
     * 使用优先队列，大顶堆来解决
     * Param [arr, size]
     * return java.util.ArrayList<java.lang.Integer>
     */
    private static ArrayList<Integer> maxInWindowsWithPriorityQueue(int[] arr, int size) {
        if (arr.length <= 0 || size <= 0) {
            return new ArrayList<>();
        }
        ArrayList<Integer> maxInWindowList = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(11,
                (o1, o2) -> o2 - o1
        );
        int index = 0;
        while (index + size - 1 < arr.length) {
            int curIndex = index;
            int curSize = size;
            while (curSize > 0) {
                queue.offer(arr[curIndex + curSize - 1]);
                curSize--;
            }
            Integer peek = queue.peek();
            maxInWindowList.add(peek);
            queue.clear();
            index++;
        }
        return maxInWindowList;
    }

    /**
     * Description
     * 利用arrayList来实现
     * Param [num, size]
     * return java.util.ArrayList<java.lang.Integer>
     */
    public ArrayList<Integer> handleWithArrayList(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length == 0 || size > num.length || size == 0) return list;
        for (int i = 0; i + size <= num.length; i++) {
            int temp = num[i];
            for (int j = i + 1; j < i + size; j++) {
                if (num[j] > temp)
                    temp = num[j];
            }
            list.add(temp);
        }
        return list;
    }
}
