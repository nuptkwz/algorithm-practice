package com.algorithm.practice.sort;

/**
 * Description 排序算法
 * Date 2020/4/19 11:55
 * Created by kwz
 */
public class Sort {

    public static void main(String[] args) {
        int[] arr = {4, 49, 47, 2, 13, 56, 1, 36};
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertionSort(arr);
        quickSort(arr);
    }

    /**
     * Description: 两个数比较大小，较大的数下沉，较小的数冒起来
     * 平均时间复杂度 o(n^2)
     * Param [arr]
     * return void
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.print("BubbleSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("--------------------------");
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
    private static void selectionSort(int[] arr) {
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

        System.out.print("SelectionSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("--------------------------");
    }

    /**
     * Description 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到
     * 前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
     * 平均时间复杂度：O(n^2)(比较适合少量数据的排序)
     * Param [arr]
     * return void
     */
    private static void insertionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int insertNum = arr[j];
            while (j > 0 && insertNum < arr[j - 1]) {
                arr[j] = arr[--j];
            }
            arr[j] = insertNum;
        }

        System.out.print("InsertionSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("--------------------------");
    }

    /**
     * Description
     * 基本思想：（分治）
     * 1.先从数列中取出一个数作为key值；
     * 2.将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
     * 3.对左右两个小数列重复第二步，直至各区间只有1个数。
     * Param [array]
     * return void
     */
    private static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);

        System.out.print("QuickSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("--------------------------");
    }

    private static void sort(int[] arr, int low, int high) {
        int i, j, index;
        if (low >= high) return;
        i = low;
        j = high;
        index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index) j--;
            if (i < j) arr[i++] = arr[j];

            while (i < j && arr[i] < index) i++;
            if (i < j) arr[j--] = arr[i];

            arr[i] = index;
            sort(arr, low, i - 1);
            sort(arr, i + 1, high);
        }
    }
}
