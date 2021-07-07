package com.demo.algorithm.牛客网.华为;

import java.io.*;
import java.util.*;

/**
 题目描述
 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。

 输入描述:
 输入两个正整数A和B。

 输出描述:
 输出A和B的最小公倍数。

 示例1
 输入
 5 7
 输出
 35


 * */
public class 求最小公倍数 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while((str=br.readLine())!=null){
            String[] strArr = str.split(" ");
            int n = Integer.parseInt(strArr[0]);
            int m = Integer.parseInt(strArr[1]);
            int j = m*n;

            // 这里让m是大数， n是小数
            if(n>m){
                int temp = m;
                m = n;
                n =temp;
            }
            //最大公约数--取余算法  TODO  数学证明
            while(n!=0){
                int r = m%n;
                m = n;
                n = r;
            }
            int max = j/m;
            System.out.println(max);
        }
    }

}
