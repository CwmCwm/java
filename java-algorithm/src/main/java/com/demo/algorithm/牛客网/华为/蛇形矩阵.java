package com.demo.algorithm.牛客网.华为;


import java.util.*;


/**
 题目描述
 题目说明

 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。

 样例输入
 5

 样例输出
 1 3 6 10 15
 2 5 9 14
 4 8 13
 7 12
 11

 接口说明
 原型
 void GetResult(int Num, char * pResult);
 输入参数：
 int Num：输入的正整数N
 输出参数：
 int * pResult：指向存放蛇形矩阵的字符串指针
 指针指向的内存区域保证有效
 返回值：
 void



 输入描述:
 输入正整数N（N不大于100）

 输出描述:
 输出一个N行的蛇形矩阵。

 示例1
 输入
 4
 输出
 1 3 6 10
 2 5 9
 4 8
 7

 样例输入
 5
 样例输出
 1 3 6 10 15      (+2, +3, +4, +5 ...)
 2 5 9 14         (+3, +4, +5)
 4 8 13           (+4, +5)
 7 12             (+5)
 11
 竖向 (+1, +2, +3, +4)


思路：找规律

 * */
public class 蛇形矩阵 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int n = sc.nextInt();
            StringBuffer str = new StringBuffer();
            int y1 = 1;//y轴上的第1位，即每行的第1位
            int b = 0;  //一行里面向右移的每一位

            //i是竖向的计数，j是横向的计数
            for (int i=0; i<n; i++) {
                y1 = y1 + i;
                b = y1;//重置后再加
                for (int j=0; j<n-i; j++) {
                    str.append(b + " ");
                    b = b + j+i+2;
                }
                System.out.println(str.toString().trim());
                str = new StringBuffer();
            }
        }
    }
}
