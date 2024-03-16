package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。

 输入描述:
 输入一个整数（int类型）

 输出描述:
 这个数转换成2进制后，输出1的个数

 示例1
 输入
 5
 输出
 2

 * */
public class 求int型正整数在内存中存储时1的个数 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(function1(num));
        System.out.println(function2(num));
    }


    /**
     * 算法1，转成字符串，一个个比较
     */
    public static int function1(int num) {
        int count=0;
        String binaryString = Integer.toBinaryString(num);
        for (int i=0; i<binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

    /**
     * 算法2，与运算比较 和 位移动
     */
    public static int function2(int num) {
        int count=0;
        for(int i=0; i<32; i++){
            //num和1 进行每一位的与运算，因为1的二进制就最后是1，前面位都是0，所以就是判断num最后一位是不是1
            if((num&1) == 1) {
                count++;
            }

            num = num >>> 1;//无符号右移
        }
        return count;
    }


}
