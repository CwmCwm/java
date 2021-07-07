package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 写出一个程序，接受一个由字母和数字组成的字符串，和一个字符，然后输出输入字符串中含有该字符的个数。不区分大小写。

 输入描述:
 第一行输入一个有字母和数字以及空格组成的字符串，第二行输入一个字符。

 输出描述:
 输出输入字符串中含有该字符的个数。

 示例1
 输入
 ABCDEF
 A
 输出
 1



 * */
public class 计算字符个数 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int inputCount = 0;
        String string1 = "";
        String string2 = "";
        while(scanner.hasNext()) {
            if (inputCount == 0) {
                string1 = scanner.nextLine();
                inputCount++;
            } else {
                string2 = scanner.nextLine();
                numbers(string1, string2);
                inputCount = 0;
            }
        }

    }

    public static void numbers(String string1, String string2) {
        int count = 0;
        String tmp1 = string1.toLowerCase();
        char tmp2 = string2.charAt(0);
        for (int i=0; i<tmp1.length(); i++) {
            if (tmp1.charAt(i) == tmp2) {
                count++;
            }
        }
        System.out.println(count);
    }

}
