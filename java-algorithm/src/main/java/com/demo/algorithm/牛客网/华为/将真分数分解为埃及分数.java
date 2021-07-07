package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。

 输入描述:
 输入一个真分数，String型

 输出描述:
 输出分解后的string

 示例1
 输入
 8/11
 输出
 1/2+1/5+1/55+1/110


 TODO  迭代加深搜索，斐波那契分解分数


 * */
public class 将真分数分解为埃及分数 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String res = "";
            String[] arr = in.nextLine().split("/");
            String pre = "";
            int a = Integer.valueOf(arr[0]);
            int b = Integer.valueOf(arr[1]);
            while (true){
                int c = b/a+1;
                res += "1/";
                res += c;
                a = a - b % a;
                b = b * c;
                res += "+";
                if (a == 1){
                    res += "1/";
                    res += b;
                    break;
                }else if (a > 1 && b % a == 0){
                    res += "1/";
                    res += b/a;
                    break;
                }
            }
            System.out.println(res);
        }
    }

}
