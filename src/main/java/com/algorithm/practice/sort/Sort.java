package com.algorithm.practice.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
//        quickSort(arr);
        mergeSort(arr);

        int [] candies = {2,3,5,1,3};
        int extraCandies = 3;
        List<Boolean> booleans = kidsWithCandies(candies, extraCandies);
        System.out.println(booleans);
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if(candies.length<=0){
            return new ArrayList<>();
        }
        List<Boolean> result = new ArrayList<>(candies.length);
        int[] sortCandies = Arrays.copyOf(candies, candies.length);
        Arrays.sort(sortCandies);
        int max = sortCandies[sortCandies.length - 1];
        for(int i=0;i<candies.length;i++){
            if((candies[i]+extraCandies)>=max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
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
     * 1.先从数列中取出一个数作为基准数；
     * 2.分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边；
     * 3.对左右两个数列重复第二步，直至各区间只有1个数。
     * 平均时间复杂度 O(N*logN)
     * Param [array]
     * return void
     */
    private static void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
        int[] candies=  new int[4];
        int[] sortCandies = new int[candies.length];
        int[] ints = Arrays.copyOf(candies, candies.length);

        System.out.print("QuickSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("--------------------------");
    }

    private static void sort(int[] arr, int i, int j) {
        if (i >= j) return;
        int index = arr[i];
        while (i < j) {
            while (i < j && arr[j] >= index) j--;
            if (i < j) arr[i++] = arr[j];

            while (i < j && arr[i] < index) i++;
            if (i < j) arr[j--] = arr[i];

            arr[i] = index;
            sort(arr, 0, i - 1);
            sort(arr, i + 1, j);
        }
    }

    /**
     * 分而治之的思想
     *
     * @param arr
     */
    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];//在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
        sort(arr, 0, arr.length - 1, temp);
        System.out.print("MergeSort排序结果为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("--------------------------");
    }

    private static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //左边归并排序，使得左子序列有序
            sort(arr, left, mid, temp);
            //右边归并排序，使得右子序列有序
            sort(arr, mid + 1, right, temp);
            //将两个有序子数组合并操作
            merge(arr, left, mid, right, temp);
        }
    }

    /**
     * 治
     *
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;//左序列指针
        int j = mid + 1;//右序列指针
        int t = 0;//临时数组指针
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中
        while (i <= mid) {
            temp[t++] = arr[i++];
        }
        //将右序列剩余元素填充进temp中
        while (j <= right) {
            temp[t++] = arr[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
