package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * Date 2020/4/25 16:05
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项
 * （从0开始，第0项为0）。n<=39
 * Created by kwz
 */
public class Fibonacci {

    public static void main(String[] args) {
        int n = 10;
        System.out.println("handleWithRecursion:" + handleWithRecursion(n));
        System.out.println("handleWithDp:" + handleWithDp(n));
    }

    /**
     * 递归解法
     *
     * @param n : number
     * @return : int
     */
    private static int handleWithRecursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return handleWithRecursion(n - 1) + handleWithRecursion(n - 2);
    }

    /**
     * 采用动态规划思想，比递归实现起来要节省时间。（核心思想就是逐步推进）
     *
     * @param n : number
     * @return : int
     */
    private static int handleWithDp(int n) {
        int num1 = 0;
        int num2 = 1;
        int result = 0;
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            //进行迭代
            for (int i = 2; i <= n; i++) {
                result = num1 + num2;
                num1 = num2;
                num2 = result;
            }
        }
        return result;
    }
}
