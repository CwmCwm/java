package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）

 输入描述:
 输入一个十六进制的数值字符串。

 输出描述:
 输出该数值的十进制字符串。

 输入例子1:
 0xA

 输出例子1:
 10


 * */
public class 进制转换 {

    // 关于 进制转换见 Integer源码
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String hexString = scanner.nextLine();
            //
            System.out.println(Integer.parseInt(hexString.substring(2), 16));
        }
    }


}
