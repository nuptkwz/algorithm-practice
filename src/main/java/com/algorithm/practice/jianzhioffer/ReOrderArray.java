package com.algorithm.practice.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * Date 2020/4/27 23:50
 * Created by kwz
 */
public class ReOrderArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        handleWithArrayList(array);
        handleWithBubbleSort(array);
        handleWithCountIndex(array);
    }

    /**
     * Description
     * Param [array]
     * return void
     */
    private static void handleWithArrayList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int item : array) {
            if (item % 2 == 1) {
                list.add(item);
            }
        }

        for (int value : array) {
            if (value % 2 == 0) {
                list.add(value);
            }
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    /**
     * Description 冒泡排序，前偶后奇数就交换位置(把偶数往后移)
     * Param [array]
     * return void
     */
    private static void handleWithBubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Description 数组记录下标
     * Param [array]
     * return void
     */
    private static void handleWithCountIndex(int[] array) {
        int oddCount = 0, begin = 0;
        int[] newArray = new int[array.length];
        for (int value : array) {
            if (value % 2 == 1) {
                oddCount++;
            }
        }
        for (int value : array) {
            if (value % 2 == 1) {
                newArray[begin++] = value;
            } else {
                newArray[oddCount++] = value;
            }
        }

        System.arraycopy(newArray, 0, array, 0, array.length);
    }
}
