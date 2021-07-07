package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 功能:等差数列 2，5，8，11，14。。。。
 输入:正整数N >0
 输出:求等差数列前N项和
 返回:转换成功返回 0 ,非法输入与异常返回-1
 本题为多组输入，请使用while(cin>>)等形式读取数据

 输入描述:
 输入一个正整数。

 输出描述:
 输出一个相加后的整数。

 示例1
 输入
 2
 输出
 7


 * */
public class 等差数列 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt();
            int res = Sn(n);
            System.out.println(res);
        }
    }

    // 等差数列的公式
    private static int Sn(int n) {
        // (2 + (n-1)*3+2) * n / 2
        return (1 + 3*n) * n / 2;
    }

}
