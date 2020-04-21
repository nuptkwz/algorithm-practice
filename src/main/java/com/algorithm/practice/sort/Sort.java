package com.algorithm.practice.sort;

/**
 * Description 排序算法
 * Date 2020/4/19 11:55
 * Created by kwz
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {4, 49, 47, 2, 13, 56, 1, 36};
//        BubbleSort(arr);
//        SelectionSort(arr);
    }

    /**
     * Description: 两个数比较大小，较大的数下沉，较小的数冒起来
     * 平均时间复杂度 o(n^2)
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

        System.out.println("BubbleSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * Description
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     * 平均时间复杂度：O(n^2)
     * Param [arr]
     * return void
     */
    private static void SelectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        System.out.println("SelectionSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * Description 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到
     * 前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     * 平均时间复杂度：O(n^2)(比较适合少量数据的排序)
     * Param [arr]
     * return void
     */
    private static void InsertionSort(int[] arr) {


        System.out.println("InsertionSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
