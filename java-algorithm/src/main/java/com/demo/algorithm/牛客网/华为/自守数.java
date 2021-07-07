package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 自守数是指一个数的平方的尾数等于该数自身的自然数。例如：25^2 = 625，76^2 = 5776，9376^2 = 87909376。请求出n以内的自守数的个数

 输入描述:
 int型整数

 输出描述:
 n以内自守数的数量。

 示例1
 输入
 2000
 输出
 8


 * */
public class 自守数 {

    // 暴力
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int res = 0;
            for (int i = 0; i < n; i++){
                // k就是 i的位数所在的位数规模，如 i=12,k=10   i=1001,k=1000  因为后面要整除，留下
                int k = 1;
                while (k < i) {
                    k = k * 10;
                }
                // b是i的平方后，去掉后几位数的值    如i=5,b=20   i=25,b=600    i=9376,b=87900000  i是几位数，b的后几位就是0
                int b = i * i / k * k;
                int c = i * i - b ;
                if (c == i){
                    res++;
                }
            }
            System.out.println(res+1);
        }
    }

}
