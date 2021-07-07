package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）

 输入描述:
 输入N个字符

 输出描述:
 输出该字符串反转后的字符串

 示例1
 输入
 abcd
 输出
 dcba


 * */
public class 字符串反转 {


    // 另一个方法是字符数组倒序输出
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            StringBuilder stringBuilder = new StringBuilder(string).reverse();
            System.out.println(stringBuilder.toString());
        }

    }


}
