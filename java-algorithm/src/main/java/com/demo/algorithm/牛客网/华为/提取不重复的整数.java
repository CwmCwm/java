package com.demo.algorithm.牛客网.华为;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 题目描述
 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。

 输入描述:
 输入一个int型整数

 输出描述:
 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数

 示例1
 输入
 9876673
 输出
 37689



 * */
public class 提取不重复的整数 {


    // 对10取余和整除
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            int num = scanner.nextInt();
            Set<Integer> set = new HashSet<>();
            int result = 0;
            while (num > 0) {
                int tmp = num % 10;
                if (!set.contains(tmp)) {
                    result = result * 10 + tmp;
                    set.add(tmp);
                }
                num = num /10;
            }
            System.out.println(result);
        }
    }

}
