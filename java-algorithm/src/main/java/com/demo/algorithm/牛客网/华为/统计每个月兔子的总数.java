package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

/**

 题目描述
 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问每个月的兔子总数为多少？


输入描述:
输入int型表示month

输出描述:
输出兔子总数int型

示例1
输入
9
输出
34


 思路1: 斐波那契数列，所以公式为f(n)=f(n-1)+f(n-2);   递归
 思路2：按月模拟兔子生产过程

 * */
public class 统计每个月兔子的总数 {

//    思路1: 斐波那契数列，所以公式为f(n)=f(n-1)+f(n-2);   递归
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while(scanner.hasNext()){
//            int mon= scanner.nextInt();
//            System.out.println(getNum(mon));
//        }
//    }
//
//    public static int getNum(int mon){
//        if (mon == 1 ||mon == 2) {
//            return 1;
//        }
//        return getNum(mon-1)+getNum(mon-2);
//    }


    // 思路2：按月模拟兔子生产过程
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int months = scanner.nextInt();

            int month1 = 1;//month1是1个月大的兔子数量
            int month2 = 0;//month2是2个月大的兔子数量
            int month3 = 0;//month3是成熟的兔子数量（3个月和超过3个月）

            // 这里上面 month1 = 1 已经初始化，即第一个月已经过了，下面循环从第2个月开始
            // 每过1个月就循环一次
            for (int i=1; i<months; i++) {
                month3 = month3 + month2;
                month2 = month1;
                month1 = month3;
            }

            System.out.println(month1 + month2 + month3);
        }
    }

}
