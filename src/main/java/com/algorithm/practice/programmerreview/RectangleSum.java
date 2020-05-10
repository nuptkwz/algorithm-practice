package com.algorithm.practice.programmerreview;

/**
 * Description
 * Date 2020/5/8 23:49
 * Created by kwz
 */
public class RectangleSum {

    public static void main(String[] args) {
        int t = 2;
        int[][] arr = {{1, 2}, {2, 4}};
        for (int i = 0; i < t; i++) {
            int n = arr[i][0];
            int m = arr[i][1];
            System.out.println(getRectangleSum(n) * getRectangleSum(m));
        }
    }

    private static int getRectangleSum(int num) {
        int result = 0;
        while (num > 0) {
            result += num--;
        }
        return result;
    }
}
