package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 编写一个截取字符串的函数，输入为一个字符串和字节数，输出为按字节截取的字符串。但是要保证汉字不被截半个，如"我ABC"4，应该截为"我AB"，输入"我ABC汉DEF"6，应该输出为"我ABC"而不是"我ABC+汉的半个"。

 输入描述:
 输入待截取的字符串及长度

 输出描述:
 截取后的字符串

 示例1
 输入
 我ABC汉DEF
 6
 输出
 我ABC

 * */
public class 按字节截取字符串 {

    // char在Java中是16位的，因为Java用的是Unicode。
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String str = scanner.next();
            int n = scanner.nextInt();
            char[] ch = str.toCharArray();
            int i=0;  //保存应该生成的子串的索引位置
            int count=0;
            for (int j=0; j<ch.length; j++) {
                // c >= 0 && c <= 255   普通字符的编码范围
                // c >= 0x0391 && c <= 0xFFE5  中文字符的编码范围
                if (ch[j] <= 255) {
                    count++;
                    if (count <= n) {
                        i++;
                    }
                } else {
                    count = count + 2;
                    if (count <= n) {
                        i++;
                    }
                }
            }
            System.out.println(str.substring(0,i));
        }
    }

}
