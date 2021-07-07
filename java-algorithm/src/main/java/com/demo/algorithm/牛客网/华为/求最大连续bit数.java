package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

/**
 题目描述
 功能: 求一个byte数字对应的二进制数字中1的最大连续数，例如3的二进制为00000011，最大连续2个1

 输入: 一个byte型的数字
 输出: 无

 返回: 对应的二进制数字中1的最大连续数
 输入描述:
 输入一个byte数字

 输出描述:
 输出转成二进制之后连续1的个数

 示例1
 输入
 3
 输出
 2

 * */
public class 求最大连续bit数 {


    // 这个是正则
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int number = scanner.nextInt();
//            String binaryString = Integer.toBinaryString(number);
//            String[] strings = binaryString.split("0+"); //再将字符串按多个0分割
//            int count = 0;
//            for (String string : strings) {
//                count = Math.max(count, string.length());
//            }
//            System.out.println(count);
//        }
//    }



    // 位运算后计数
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            // result是最后计数结果      count是临时计数
            int result = 0;
            int count = 0;
            while (number > 0) {
                if ((number & 1) == 1) {
                    count++;
                    result = Math.max(result, count);
                } else {
                    count = 0;
                }
                number = number >>> 1;
            }
            System.out.println(result);
        }
    }


}
