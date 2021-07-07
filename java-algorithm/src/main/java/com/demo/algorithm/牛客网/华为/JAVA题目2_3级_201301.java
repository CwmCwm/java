package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**

 题目描述
 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 输入描述:
 输入两个正整数

 输出描述:
 返回结果

 示例1
 输入
 2
 2
 输出
 6



 * */
public class JAVA题目2_3级_201301 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num1= sc.nextInt();
            int num2= sc.nextInt();
            System.out.println(methods(num1,num2));
        }
    }

    // 每一步有两个选择（往右和往下走），
    public static int methods(int num1, int num2) {
        if (num1 == 0 || num2 == 0) {
            // 这里只要某一边到达边界（即0），就只剩一条路（一个方向走到终点），所以直接返回1
            // 不用
            return 1;
        }
        return methods(num1-1,num2) + methods(num1,num2-1);
    }


}
