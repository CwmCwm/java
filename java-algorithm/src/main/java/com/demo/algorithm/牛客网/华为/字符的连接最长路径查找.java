package com.demo.algorithm.牛客网.华为;


import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

/**

 题目描述
 给定n个字符串，请对n个字符串按照字典序排列。
 输入描述:
 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。
 输出描述:
 数据输出n行，输出结果为按照字典序排列的字符串。

 示例1
 输入
 9
 cap
 to
 cat
 card
 two
 too
 up
 boat
 boot
 输出
 boat
 boot
 cap
 card
 cat
 to
 too
 two
 up

 * */
public class 字符的连接最长路径查找 {


    // 使用Arrays排序   ，TreeSet和TreeMap需要额外处理
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int length = scanner.nextInt();
            String[] strings = new String[length];
            for (int i=0; i<length; i++) {
                strings[i] = scanner.next();
            }
            Arrays.sort(strings);

            for (String x : strings) {
                System.out.println(x);
            }
        }
    }


}
