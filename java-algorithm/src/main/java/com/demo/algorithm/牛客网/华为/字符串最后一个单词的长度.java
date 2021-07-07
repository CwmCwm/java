package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 计算字符串最后一个单词的长度，单词以空格隔开。

 输入描述:
 一行字符串，非空，长度小于5000。

 输出描述:
 整数N，最后一个单词的长度。

 示例1
 输入
 hello world
 输出
 5

 * */
public class 字符串最后一个单词的长度 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            lastWordLength(line);
        }
    }


    // 这是使用 String提供的方法
    public static void lastWordLength(String line) {
        //正则表达式实用性更强( str.split("\\s+"))
        String[] lines = line.split(" ");
        System.out.println(lines[lines.length-1].length());
    }


    // 方法二: 反过来打印,对输入字符串反向一个个字符判断
    // 这个才是本题想要的答案
    public static void lastWordLength2(String line) {
        int count = 0;
        for (int i=line.length()-1; i>=0; i--) {
            if (line.charAt(i) == ' ') {
                break;
            }
            count++;
        }
        System.out.println(count);
    }


}
