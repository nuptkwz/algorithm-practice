package com.algorithm.practice.other;

import java.util.Scanner;

/**
 * Description
 * description:有多个整数，求这些数能拼接成为的最大数
 * 例：9 990 22 987
 * 输出：9->990->987->22
 * Date 2021/3/28 13:45
 * Created by kwz
 */
public class BigNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String inputNumber = scanner.nextLine();
            String[] numbers = inputNumber.split(" ");
            computeBigNum(numbers);
        }
    }

    private static void computeBigNum(String[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (compute(numbers[i], numbers[j])) {
                    String temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }

        for (String num : numbers) {
            System.out.print(num);
        }
    }

    /***
     * Description
     * 左右两个数拼装，看看哪个更大一点
     * Param [first, second]
     * return boolean
     */
    private static boolean compute(String first, String second) {
        String left = first + second;
        String right = second + first;
        return left.compareTo(right) < 0;
    }
}
