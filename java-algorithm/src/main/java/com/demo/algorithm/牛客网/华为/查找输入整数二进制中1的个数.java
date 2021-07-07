package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**

 题目描述
 请实现如下接口

 譬如：输入5 ，5的二进制为101，输出2


涉及知识点：

注意多组输入输出！！！！！！
输入描述:
输入一个整数

输出描述:
计算整数二进制中1的个数

示例1
输入
5
输出
2

 * */
public class 查找输入整数二进制中1的个数 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int num = in.nextInt();
            int res = findNumberOf1(num);
            System.out.println(res);
        }
    }


    // 从二进制角度看， 进行 &1 运算就能判断最低位是不是1  ，然后右移1位，重复进行
    private static int findNumberOf1(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num = num >>> 1;
        }
        return count;
    }




}
