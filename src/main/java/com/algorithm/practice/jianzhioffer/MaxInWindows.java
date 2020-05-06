package com.algorithm.practice.jianzhioffer;

import java.util.ArrayList;
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


    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int index = 0;
        while (index + size < num.length) {
            int curIndex = index;
            int curSize = size;
            while (curSize>0){
                queue.offer(num[curIndex+curSize-1]);
                curSize--;
            }
            Integer peek = queue.peek();
            list.add(peek);
            index++;
        }
        return list;
    }
}
