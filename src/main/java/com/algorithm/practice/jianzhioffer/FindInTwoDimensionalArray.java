package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * Date 2020/3/28 21:48
 * Created by kwz
 */
public class FindInTwoDimensionalArray {
    public static void main(String[] args) {
        int target = 6;
        int[][] array = {{1, 2, 3}, {2, 3, 4}, {4, 5, 6}};
        System.out.println("violenceSolve:" + violenceSolve(target, array));
        System.out.println("findWithTwoPointSearch:" + findWithTwoPointSearch(target, array));
        System.out.println("fromUpperRightCorner:" + fromUpperRightCorner(target, array));
    }


    /**
     * 暴力求解：二维数组循环遍历，查找到后返回(o(n^2)的时间复杂度)
     * Description
     * Param [target, array]
     * return boolean
     */
    private static boolean violenceSolve(int target, int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Description 由于是顺序可以用二分查找的方法
     * Param [target, array]
     * return boolean
     */
    private static boolean findWithTwoPointSearch(int target, int[][] array) {
        for (int[] ints : array) {
            int low = 0;
            int high = ints.length - 1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (ints[mid] > target) {
                    high = mid - 1;
                } else if (ints[mid] < target) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Description 因为是有序，从右上角开始找，比target大则j--,target小则i++,同理可以从左下角开始找
     * Param [target, array]
     * return boolean
     */
    private static boolean fromUpperRightCorner(int target, int[][] array) {
        int i = 0;
        int j = array.length - 1;
        while (j >= 0 && i < array[j].length) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
