package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 描述：

 输入一个整数，将这个整数以字符串的形式逆序输出

 程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001


 输入描述:
 输入一个int整数

 输出描述:
 将这个整数以字符串的形式逆序输出

 示例1
 输入
 1516000
 输出
 0006151


 * */
public class 数字颠倒 {

    // 对10取余和整除
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            StringBuilder stringBuilder = new StringBuilder();
            while (num > 0) {
                stringBuilder.append(num % 10);
                num = num / 10;
            }
            System.out.println(stringBuilder.toString());
        }


        // 数字转字符串，处理字符串
        //   StringBuffer 或 StringBuilder 的 reverse 成员方法
        //   逆序输出字符串

    }

}
