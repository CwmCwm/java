package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

/**
 题目描述
 验证尼科彻斯定理，即：任何一个整数m的立方都可以写成m个连续奇数之和。

 例如：
 1^3=1
 2^3=3+5
 3^3=7+9+11
 4^3=13+15+17+19

 输入描述:
 输入一个int整数

 输出描述:
 输出分解后的string

 示例1
 输入
 6
 输出
 31+33+35+37+39+41

 * */
public class 尼科彻斯定理 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt())
        {
            int m = in.nextInt();
            String result = getSequeOddNum(m);
            System.out.println(result);
        }
    }

    // 看规律啊， m的平方左右取值
    public static String getSequeOddNum(int m) {
        // low是直接算出 加法式中的最小数
        int low;
        if (m % 2 != 0) {
            // m是奇数
            low = m * m - 2*(m/2);
        } else {
            low = m * m - 1 - (m-1)/2*2;
        }

        StringBuilder s = new StringBuilder().append(low);
        for (int i = 1; i < m; i++) {
            s.append("+").append(low + i*2);
        }
        return s.toString();
    }




}
