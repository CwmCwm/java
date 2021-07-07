package com.demo.algorithm.牛客网.华为;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 题目描述
 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
 输入
 abaca
 输出
 3
 输入描述:
 输入N个字符，字符在ACSII码范围内。

 输出描述:
 输出范围在(0~127)字符的个数。

 示例1
 输入
 abc
 输出
 3


 * */
public class 字符个数统计 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int count = 0;
            Set<Integer> set = new HashSet<>();
            String line = scanner.nextLine();
            for (int i=0; i<line.length(); i++) {
                int char1 = line.charAt(i);
                if (char1 <=127 && !set.contains(char1)) {
                    count++;
                    set.add(char1);
                }
            }
            System.out.println(count);
        }

    }

}
