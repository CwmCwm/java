package com.demo.algorithm.牛客网.华为;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**

 题目描述
 题目标题：
 计算两个字符串的最大公共字串的长度，字符不区分大小写
 详细描述：

 接口说明
 原型：
 int getCommonStrLength(char * pFirstStr, char * pSecondStr);

 输入参数：
 char * pFirstStr //第一个字符串
 char * pSecondStr//第二个字符串

 输入描述:
 输入两个字符串

 输出描述:
 输出一个整数

 示例1
 输入
 asdfas
 werasdfaswer
 输出
 6

 这个前面的体出现过了

 思路2： 滑动窗口（扩展的窗口）， 和 String.contains()方法

 * */
public class 公共字符串计算 {

    public static void main(String[] args) throws IOException {
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
            System.out.println(findMaxCommonStr2(strA, strB).length());
        }
    }

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
