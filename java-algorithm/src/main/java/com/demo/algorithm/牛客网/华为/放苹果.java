package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**

 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 输入
 每个用例包含二个整数M和N。0<=m<=10，1<=n<=10。
 样例输入
 7 3
 样例输出
 8

 输入描述:
 输入两个int整数

 输出描述:
 输出结果，int型

 示例1
 输入
 7 3
 输出
 8


 TODO 看不懂？？

 采用递归的思想将此事件无限细分，
 每个事件可以分为f(m,n)=f(m-n,n)+f(m,n-1);
 f(m-n,n)是当苹果数大于等于盘子数的情况，
 f(m,n-1)是当苹果数小于盘子数的情况。
 当此事件分到苹果数为0或苹果数为1或盘子数为1的时候返回1，当苹果数小于0或盘子数小于等于0返回0.

 * */
public class 放苹果 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(count(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
    }

    // m是苹果数， n是盘子数
    public static int count(int m,int n) {
        if(m<0||n<=0)
            return 0;
        //细分到苹果数为一或盘子数为一的情况返回一
        if(m==1||n==1||m==0)
            return 1;
        //将此事件无线细分
        return count(m,n-1)+count(m-n,n);
    }


}
