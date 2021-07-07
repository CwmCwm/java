package com.demo.algorithm.牛客网.华为;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 题目描述
 公元前五世纪，我国古代数学家张丘建在《算经》一书中提出了“百鸡问题”：鸡翁一值钱五，鸡母一值钱三，鸡雏三值钱一。百钱买百鸡，问鸡翁、鸡母、鸡雏各几何？

 详细描述：
 接口说明
 原型：
 int GetResult(vector &list)

 输入参数：
 无
 输出参数（指针指向的内存区域保证有效）：
 list  鸡翁、鸡母、鸡雏组合的列表
 返回值：
 -1 失败
 0 成功


 输入描述:
 输入任何一个整数，即可运行程序。
 输出描述:

 示例1
 输入
 1
 输出
 0 25 75
 4 18 78
 8 11 81
 12 4 84


 思路1： 暴力
 思路2： 解方程， 3个未知数，2个等式，消元法，得到一个含有2个未知数的方程，然后遍历一下，看有哪些符合的值

 * */
public class 百钱买百鸡问题 {

    //  思路1： 暴力
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(bf.readLine() != null){
            int a ,b;
            for(a=0;a<20;a++){
                for(b=0;a+b<100;b++){
                    int c = 100 -a -b;
                    if(c%3==0&&(100-5*a-3*b)==c/3){
                        System.out.println(a + " " + b + " " + c);
                    }
                }
            }
        }
    }

}
