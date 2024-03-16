package com.demo.algorithm.牛客网.华为;

import java.io.*;
import java.util.Scanner;

/**

 重复题目

 * */
public class 字符逆序 {

    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);

        //算法1：直接用stringBuilder的方法
        while (sc.hasNext()) {
            StringBuilder stringBuilder = new StringBuilder(sc.nextLine());
            stringBuilder.reverse();
            System.out.println(stringBuilder.toString());
        }

        //算法2：字符串从后遍历输出字符
        while (sc.hasNext()) {
            String str = sc.nextLine();
            for (int i=str.length()-1; i>=0; i--) {
                System.out.print(str.charAt(i));
            }
        }
        System.out.println("");

    }

}
