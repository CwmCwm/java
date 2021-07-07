package com.demo.algorithm.牛客网.华为;



import java.io.*;
import java.util.*;

/**

 题目描述
 查找两个字符串a,b中的最长公共子串。若有多个，输出在较短串中最先出现的那个。

 输入描述:
 输入两个字符串
 输出描述:
 返回重复出现的字符

 示例1
 输入
 abcdefghijklmnop
 abcsafjklmnopqrstuvw
 输出
 jklmnop


 TODO 动态规划 ???

 思路2： 滑动窗口（扩展的窗口）， 和 String.contains()方法

 * */
public class 查找两个字符串a_b中的最长公共子串 {


    public static void main(String[] args) throws IOException{
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        while((line=sc.readLine())!=null){
            String strA = line;
            String strB = sc.readLine();
            if (strA.length() > strB.length()) {
                String temp = strA;
                strA = strB;//str1是较短的子串
                strB = temp;
            }
            System.out.println(findMaxCommonStr2(strA, strB));
        }
    }


//
//    // 输入保证 str1.length <= str2.length  动态规划
//    private static String findMaxCommonStr(String str1, String str2) {
//        char[] str1Char = str1.toCharArray();
//        char[] str2Char = str2.toCharArray();
//        int[][] dp = new int[str1Char.length + 1][str2Char.length + 1];
//        int maxLen = 0;
//        int start = 0;
//        for (int i = 1; i <= str1Char.length; i++) {
//            for (int j = 1; j <= str2Char.length; j++) {
//                if (str1Char[i - 1] == str2Char[j - 1]) {
//                    dp[i][j] = dp[i - 1][j - 1] + 1;
//                    if (dp[i][j] > maxLen) {
//                        maxLen = dp[i][j];
//                        start = i - maxLen;//记录最长公共子串的起始位置
//                    }
//                }
//            }
//        }
//        return str1.substring(start, start + maxLen);
//    }


    // 思路2： 滑动窗口（扩展的窗口）， 和 String.contains()方法
    // 输入保证 str1.length <= str2.length
    private static String findMaxCommonStr2(String str1, String str2) {
        String result = "";
        int leftIndex = 0;
        int rightIndex = 1;
        while (rightIndex <= str1.length()) {
           String tmp = str1.substring(leftIndex, rightIndex);
           if (str2.contains(tmp)) {
               if (tmp.length()>result.length()) {
                   result = tmp;
               }
           } else {
               leftIndex++;
           }
           rightIndex++;
        }
        return result;
    }


}
