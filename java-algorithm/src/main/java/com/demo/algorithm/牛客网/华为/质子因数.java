package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）

 最后一个数后面也要有空格

 输入描述:
 输入一个long型整数

 输出描述:
 按照从小到大的顺序输出它的所有质数的因子，以空格隔开。最后一个数后面也要有空格。

 示例1
 输入
 复制
 180
 输出
 复制
 2 2 3 3 5



 分解质因数的有两种表示方法，除了大家最常用知道的“短除分解法”之外，还有一种方法就是“塔形分解法”。
 我只会小学学的 “短除分解法”

 * */
public class 质子因数 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextLong()){
            long num = scanner.nextLong();
            System.out.println(getResult(num));
        }
    }


    // 我只会小学学的 “短除分解法”
    public static String getResult(long num){
        // 从最小的质数2 开始除
        int pom = 2;
        StringBuilder output = new StringBuilder();
        while(num >= pom){
            if (num % pom == 0){
                num = num / pom;
                output.append(pom).append(" ");
            }
            else {
                pom++;
            }
        }
        return output.toString();
    }

}
