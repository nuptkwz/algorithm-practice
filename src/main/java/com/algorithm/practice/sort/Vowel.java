package com.algorithm.practice.sort;

import java.util.Scanner;

/**
 * Description
 * 元音转大写，辅音转小写
 * Date 2021/4/11 13:43
 * Created by kwz
 */
public class Vowel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String string = scanner.nextLine();
            if (string.length() > 100 || string.length() <= 0) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                char currentChar = string.charAt(i);
                if (isYuanYin(currentChar)) {
                    stringBuilder.append(String.valueOf(currentChar).toUpperCase());
                } else {
                    stringBuilder.append(String.valueOf(currentChar).toLowerCase());
                }
            }
            System.out.println(stringBuilder.toString());
        }
    }

    private static boolean isYuanYin(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
