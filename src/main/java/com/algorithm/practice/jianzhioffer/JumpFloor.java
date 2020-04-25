package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * Date 2020/4/25 16:26
 * Created by kwz
 */
public class JumpFloor {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("handleWithRecursion:" + handleWithRecursion(n));
        System.out.println("handleWithDp:" + handleWithDp(n));
    }

    /**
     * 采用递归的形式
     *
     * @param target : target
     * @return : int
     */
    private static int handleWithRecursion(int target) {
        if (target <= 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return handleWithRecursion(target - 1) + handleWithRecursion(target - 2);
        }
    }

    /**
     * 采用动态规划的方式
     *
     * @param target ：
     * @return ：
     */
    private static int handleWithDp(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;
        int result = 0;
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= target; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
