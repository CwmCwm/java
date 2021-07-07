package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

/**
 题目描述
 将一个字符中所有出现的数字前后加上符号“*”，其他字符保持不变

 输入描述:
 输入一个字符串

 输出描述:
 字符中所有出现的数字前后加上符号“*”，其他字符保持不变

 示例1
 输入
 Jkdi234klowe90a3
 输出
 Jkdi*234*klowe*90*a*3*

 * */
public class 表示数字 {

    // 正则
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String input = scanner.next();
//            System.out.println(input.replaceAll("([0-9]+)", "*$1*")); //把所有的数字段提取出来，前后加上星号再放回去
//        }
//    }




    // 遍历判断
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String pInStr = in.nextLine();
            String res = markNum(pInStr);
            System.out.println(res);
        }

    }

    public static String markNum(String pInStr) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < pInStr.length();) {
            // 若发现了数字
            if (pInStr.charAt(i) >= '0' && pInStr.charAt(i) <= '9') {
                res.append('*');
                while (i < pInStr.length() && pInStr.charAt(i) >= '0' && pInStr.charAt(i) <= '9') {
                    res.append(pInStr.charAt(i++));
                }
                res.append('*');
            }
            else {
                res.append(pInStr.charAt(i++));
            }
        }
        return res.toString();
    }



}
