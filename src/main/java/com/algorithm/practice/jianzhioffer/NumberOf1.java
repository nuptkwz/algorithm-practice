package com.algorithm.practice.jianzhioffer;

/**
 * Description
 * Date 2020/4/25 14:29
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * Created by kwz
 */
public class NumberOf1 {
    public static void main(String[] args) {
        int number = 10;
        System.out.println("handleWithBitCount:" + handleWithBitCount(number));
        System.out.println("handleWithString:" + handleWithString(number));
        System.out.println("handleWithStringReplace:" + handleWithStringReplace(number));
        System.out.println("handleWithBitCount2:" + handleWithBitCount2(number));
    }

    /**
     * Integer的bitCount方法可以用来统计二进制中1的个数
     *
     * @param n : number
     * @return int
     */
    private static int handleWithBitCount(int n) {
        return Integer.bitCount(n);
    }

    /**
     * 利用Integer中的toBinaryString方法，先转成二进制字符串，然后统计1的个数
     *
     * @param n ：number
     * @return int
     */
    private static int handleWithString(int n) {
        String str = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * replaceAll("0","")方法是将字符串中的"0"用""来代替，
     * 最后返回一个新的字符串，然后计算这个字符串的长度即得出结果
     *
     * @param n ：
     * @return ：int
     */
    private static int handleWithStringReplace(int n) {
        return Integer.toBinaryString(n).replaceAll("0", "").length();
    }

    /**
     * (每次和n-1相&可以去除最右边的那个数字)
     * 思想：一个整数减去1之后，会发现这个数二进制，从最右边的1开始都取反了，
     * 如果将这个数与原数相与，那么得到的数是原数字对应的二进制去掉最右边1的数字，
     * 每次与一次，去掉一个1。最后得到count的值，即为二进制中1的个数。
     * 例如：n=12
     * 1:  12&11=1100&1011=1000=8 count=1
     * 2:  8&7=1000&0111=0 count=2
     *
     * @param n: number
     * @return : int
     */
    private static int handleWithBitCount2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
