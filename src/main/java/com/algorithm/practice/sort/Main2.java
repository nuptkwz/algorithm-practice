package com.algorithm.practice.sort;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 * Date 2021/4/11 14:04
 * Created by kwz
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean nextLine = scanner.hasNextLine();
        int num = 0;
        if (nextLine) {
            num = Integer.parseInt(scanner.nextLine());
        }
        if (num >= 10) {
            return;
        }
        List<Integer> suShuNums = initSuShu(1000);
        List<String> result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            if (num <= 0) return;
            BigInteger bigInteger = new BigInteger(scanner.nextLine());
            result.add(isFind(suShuNums, bigInteger));
            num--;
            if (num == 0) {
                for (int i = 0; i < result.size(); i++) {
                    System.out.println(result.get(i));
                }
            }
        }
    }

    private static String isFind(List<Integer> suShuNums, BigInteger currentNum) {
        for (int i = 0; i < suShuNums.size(); i++) {
            BigInteger sum = new BigInteger(String.valueOf(suShuNums.get(i)));
            for (int j = i + 1; j < suShuNums.size(); j++) {
                sum = sum.add(new BigInteger(String.valueOf(suShuNums.get(j))));
                if (sum.equals(currentNum)) {
                    return "yes";
                }
            }
        }
        return "no";
    }

    private static List<Integer> initSuShu(int n) {
        List<Integer> lists = new ArrayList<>();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (isSuShu(i)) {
                lists.add(i);
                if (lists.size() == n) {
                    return lists;
                }
            }
        }
        return lists;
    }

    private static boolean isSuShu(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
