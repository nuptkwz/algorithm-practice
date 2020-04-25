package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地
 * 覆盖一个2*n的大矩形，总共有多少种方法？
 * 比如n=3时，2*3的矩形块有3种覆盖方法
 * Date 2020/4/25 22:58
 * Created by kwz
 */
public class RectCover {
    public static void main(String[] args) {
        int target = 4;
        System.out.println("solveWithRecursion:" + solveWithRecursion(target));
        System.out.println("solveWithDp:" + solveWithDp(target));
    }

    /**
     * @param target ：
     * @return ：
     */
    private static int solveWithRecursion(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        else
            return solveWithRecursion(target - 2) + solveWithRecursion(target - 1);
    }

    /**
     * 动态规划（层次推进）
     *
     * @param target：
     * @return ：
     */
    private static int solveWithDp(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;
        int result = 0;
        int n0 = 1;
        int n1 = 2;
        for (int i = 3; i <= target; i++) {
            result = n0 + n1;
            n0 = n1;
            n1 = result;
        }
        return result;
    }
}
