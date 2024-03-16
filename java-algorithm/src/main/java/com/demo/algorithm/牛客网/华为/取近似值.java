package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**

 题目描述
 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。

 输入描述:
 输入一个正浮点数值

 输出描述:
 输出该数值的近似整数值

 示例1
 输入
 5.5
 输出
 6



 * */
public class 取近似值 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextFloat()){
            double  num = scanner.nextFloat();
            System.out.println(rounding(num));

            // 参考Math源码
            // System.out.println(Math.round(num));
        }
    }

    // 先加0.5，然后强转舍去小数部分
    public static int rounding(double num) {
        return (int)(num + 0.5);
    }

}
