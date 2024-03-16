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
            System.out.println(getResult1(num));
        }
    }



    // 算法1
    // 我只会小学学的 “短除分解法”
    public static String getResult1(long num){
        // 从最小的质数2开始除，除到没法整除了，在将被除数加1后作为被除数
        // 之后是质数3
        // 然后是4，2都没法整除了，那么4只是走个循环而已，肯定没法被整除
        // 同理后面的质数才有可能被整除，如5,7,11。  像6,8,9这些非质数已经被前面的质数整除了是不会做整除的
        // 然后就是优化了，判断整除的边界
        long num_2 = (long) (num/2);        //将整除边界缩少一半
        long num_3 = (long) Math.sqrt(num); //将整除边界缩少到平方根，不知道这个数学原理TODO
        StringBuilder output = new StringBuilder();
        for (long pom=2; pom<=num_3; ++pom) {
            while (num % pom == 0) {
                output.append(pom).append(" ");
                num /= pom;
            }
        }

        //这里num到整除边界后已经被完全分解，那么num就是1
        //这里num到整除边界后还没有被完全分解，那么num就是剩余的那个大质因数
        return num==1 ? output.toString() : output.append(num).toString();
    }

}
