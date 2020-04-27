package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * Date 2020/4/26 22:44
 * Created by kwz
 */
public class Power {
    public static void main(String[] args) {
        double base = 2;
        int exponent = -3;
        System.out.println("handleWithMathPowMethod:" + handleWithMathPowMethod(base, exponent));
        System.out.println(handleWithMultiply(2, -3));
        System.out.println(handleWithRecursion(2, -3));
    }

    /**
     * 利用Math.pow的内置函数处理
     * Description
     * Param [base, exponent]
     * return double
     */
    private static double handleWithMathPowMethod(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    /**
     * Description
     * 用累计乘法
     * Param [base, exponent]
     * return double
     */
    private static double handleWithMultiply(double base, int exponent) {
        int sum = 1;
        int times = Math.abs(exponent);
        for (int i = 1; i <= times; i++) {
            sum *= base;
        }
        return exponent > 0 ? sum : (1.0 / sum);
    }

    /**
     * Description：采用递归写法，时间复杂度是LogN
     * 分奇数和偶数，奇数为：
     * Param [base, exponent]
     * return double
     */
    private static double handleWithRecursion(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent < 0) {
            return 1.0 / handleWithRecursion(base, -exponent);
        }
        if (exponent % 2 == 1) {
            return base * handleWithRecursion(base, exponent - 1);
        }
        return handleWithRecursion(base * base, exponent / 2);
    }

    /**
     * Description
     * 使用非递归的方法
     * Param [base, exponent]
     * return double
     */
    public static double handleWithNotRecursion(double base, int exponent) {
        // TODO: 2020/4/27 : handleWithNotRecursion
        return 1.0;
    }
}
