package com.demo.algorithm.牛客网.华为;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 题目描述
 编写一个程序，将输入字符串中的字符按如下规则排序。
 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 如，输入： Type 输出： epTy
 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 如，输入： BabA 输出： aABb
 规则 3 ：非英文字母的其它字符保持原来的位置。
 如，输入： By?e 输出： Be?y
 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）


 输入描述:
 输入字符串
 输出描述:
 输出字符串
 示例1
 输入
 A Famous Saying: Much Ado About Nothing (2012/8).

 输出
 A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).


 思路：
    方法:1： 冒泡排序(这个方法不能保证  规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。 )
    方法2： 对字符串中的字母按照 从 A 到 Z 排列 ，排序后另存到其他空间，

 * */
public class 字符串排序 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = br.readLine()) != null) {
            char[] arr = str.toCharArray();
            StringBuilder builder = new StringBuilder();
            // 英文字母从 A 到 Z 排列，不区分大小写：26 个
            for (int i = 0; i < 26; i++) {
                char c = (char) ('A' + i);
                // 遍历字符串
                for (int j = 0, length = str.length(); j < length; j++) {
                    // 不区分大小写
                    if (c == arr[j] || c == arr[j] - 'a' + 'A') {
                        builder.append(arr[j]);
                    }
                }
            }
            // 非英文字母的其它字符保持原来的位置
            for (int i = 0, length = str.length(); i < length; i++) {
                if (!((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z'))) {
                    builder.insert(i, arr[i]);
                }
            }
            System.out.println(builder.toString());
        }

    }


}
