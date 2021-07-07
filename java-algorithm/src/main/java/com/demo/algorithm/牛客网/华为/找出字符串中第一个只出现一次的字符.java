package com.demo.algorithm.牛客网.华为;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**

 题目描述
 找出字符串中第一个只出现一次的字符

 输入描述:
 输入几个非空字符串

 输出描述:
 输出第一个只出现一次的字符，如果不存在输出-1

 示例1
 输入
 asdfasdfo
 aabb
 输出
 o
 -1

 思路1： 暴力循环
 思路2： 一个Map记录字符出现的次数

 * */
public class 找出字符串中第一个只出现一次的字符 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            int result = count(str);
            if (result == -1) {
                System.out.println(result);
            }
            else {
                System.out.println((char)result);
            }
        }
    }


    private static int count(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str.toCharArray()) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return -1;
    }


}
