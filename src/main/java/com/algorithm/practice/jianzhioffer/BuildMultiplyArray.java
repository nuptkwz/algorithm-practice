package com.algorithm.practice.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素
 * B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * （注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];
 * Date 2020/3/29 13:59
 * Created by kwz
 */
public class BuildMultiplyArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        System.out.println(handleWithArrayList(A));
    }

    /**
     * Description 比较暴力的一种方法
     * Param [A]
     * return int[]
     */
    private static int[] handleWithArrayList(int[] A) {
        if (A == null || A.length == 0) {
            return new int[]{};
        }
        int[] B = new int[A.length];
        List<Integer> lists = new ArrayList<>();
        for (int value : A) {
            lists.add(value);
        }
        int index = 0;
        while (index < A.length) {
            lists.remove(index);
            int result = 1;
            for (Integer list : lists) {
                result *= list;
            }
            lists.add(index, A[index]);
            B[index++] = result;
        }
        return B;
    }


}