package com.algorithm.practice.sort;

/**
 * Description 排序算法
 * Date 2020/4/19 11:55
 * Created by kwz
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {4, 49, 47, 2, 13, 56, 1, 36};
        BubbleSort(arr);
    }

    /**
     * Description: 两个数比较大小，较大的数下沉，较小的数冒起来
     * Param [arr]
     * return void
     */
    private static void BubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * Description
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     * Param [arr]
     * return void
     */
    private static void SelectionSort(int[] arr) {

    }
}
