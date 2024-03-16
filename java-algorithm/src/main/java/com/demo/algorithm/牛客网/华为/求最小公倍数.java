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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            //获取两个正整数入参
            int n = sc.nextInt();
            int m = sc.nextInt();
            int j = m*n;

            //这里让m是大数，n是小数
            if (n>m) {
                int temp = m;
                m = n;
                n = temp;
            }

            //算法1：最大公约数--取余算法  TODO  数学证明
//            while (n!=0) {
//                int r = m%n;
//                m = n;
//                n = r;
//            }
//            int max = j/m;

            //算法2：逐渐计算大数m的倍数，看这个倍数能否整除小数n
            int beiShu = 1;             //大数m的放大的倍数
            int yuShu = m*beiShu % n;   //大数m的放大的倍数能否整除小数n
            while (yuShu != 0) {
                beiShu++;
                yuShu = m*beiShu % n;
            }
            int max = m*beiShu;

            System.out.println(max);
        }
    }

}
