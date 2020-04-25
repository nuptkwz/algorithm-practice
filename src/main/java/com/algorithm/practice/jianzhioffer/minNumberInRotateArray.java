package com.algorithm.practice.jianzhioffer;

import java.util.Arrays;

/**
 * Description
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 * Date 2020/4/25 15:09
 * Created by kwz
 */
public class minNumberInRotateArray {

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println("findMinNumber:" + findMinNumber(arr));
        System.out.println("handleWithArraySort:" + handleWithArraySort(arr));
        System.out.println("findWithBinSearch:" + findWithBinSearch(arr));
    }

    /**
     * 排序，找出最小值
     *
     * @param arr ： arr
     * @return :
     */
    private static int findMinNumber(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }

    /**
     * 利用Arrays.sort方法
     *
     * @param array :input array
     * @return ： int
     */
    private static int handleWithArraySort(int[] array) {
        if (array.length == 0) return 0;
        Arrays.sort(array);
        return array[0];
    }

    /**
     * 利用二分查找的方法进行
     *
     * @param array : array
     * @return ： int
     */
    private static int findWithBinSearch(int[] array) {
        if (array.length == 0) return 0;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left];
    }
}
