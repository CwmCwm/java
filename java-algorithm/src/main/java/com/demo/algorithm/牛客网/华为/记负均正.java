package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

/**
 题目描述
 首先输入要输入的整数个数n，然后输入n个整数。输出为n个整数中负数的个数，和所有正整数的平均值，结果保留一位小数。

 输入描述:
 首先输入一个正整数n，
 然后输入n个整数。

 输出描述:
 输出负数的个数，和所有正整数的平均值。

 示例1
 输入
 5
 1
 2
 3
 4
 5
 输出
 0 3.0

 * */
public class 记负均正 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            // count1正数的个数    count2负数的个数    sum所有正数的和
            int count1 = 0;
            int count2 = 0;
            int sum = 0;
            int in = 0;

            for(int i = 0; i < n; i++){
                in  = sc.nextInt();
                if(in > 0){
                    count1++;
                    sum += in;
                } else if(in < 0){
                    count2++;
                }
            }
            
            System.out.printf("%d %.1f\n", count2, (sum * 1.0 / count1));
        }
    }

}
