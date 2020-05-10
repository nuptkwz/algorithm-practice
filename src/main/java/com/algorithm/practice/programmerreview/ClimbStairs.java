package com.algorithm.practice.programmerreview;

/**
 * Description
 * Date 2020/5/8 23:35
 * Created by kwz
 */
public class ClimbStairs {

    public static void main(String[] args) {
        int t = 2;
        int[] arr = {2, 19};
        for (int i = 0; i < t; i++) {
            System.out.println(getSumStepsByDp(arr[i]));
        }
    }

    /**
     * Description:采用动态规划
     * Param [num]
     * return int
     */
    private static int getSumStepsByDp(int num) {
        if (num == 1) return 1;
        if (num == 2) return 2;
        int result = 0;
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= num; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }

}
