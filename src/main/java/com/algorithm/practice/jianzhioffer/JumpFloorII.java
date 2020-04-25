package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Date 2020/4/25 16:35
 * Created by kwz
 */
public class JumpFloorII {

    public static void main(String[] args) {
        int target = 39;
        System.out.println("solveWithRecursion:" + solveWithRecursion(target));
        System.out.println("solveWithRecursion:" + solveWithRecursion(target));
        System.out.println("solveWithMathPow:" + solveWithMathPow(target));
    }

    /**
     * 通过分析可以发现第n次的结果为：2*f(n-1)
     *
     * @param target :
     * @return :
     */
    private static int solveWithRecursion(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        else
            return 2 * solveWithRecursion(target - 1);
    }

    /**
     * 利用2^n次方
     *
     * @param target ：
     * @return ：
     */
    private static int solveWithMathPow(int target) {
        if (target <= 0) return 0;
        return (int) Math.pow(2, target - 1);
    }

    /**
     * 动态规划
     *
     * @param target :
     * @return :
     */
    private static int solveWithDp(int target) {
        if (target == 0) return 0;
        if (target == 1) return 1;
        int dp0 = 1;
        int result = 1;
        for (int i = 2; i <= target; i++) {
            result = 2 * dp0;
            dp0 = result;
        }
        return result;
    }
}
