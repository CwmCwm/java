package com.demo.algorithm.牛客网.华为;


import java.util.*;

/**
 题目描述
 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数。


输入描述:
输入一行字符串，可以有空格

输出描述:
统计其中英文字符，空格字符，数字字符，其他字符的个数

示例1
输入
1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
输出
26
3
10
12

 * */
public class 输入一行字符_分别统计 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int isLetter=0, isDigit=0, isWhitespace=0, isQt=0;
            char[] str = sc.nextLine().toCharArray();
            for(int i=0;i<str.length;i++){
                char a = str[i];
                if (Character.isLetter(a)) {
                    isLetter++;
                }
                else if (Character.isDigit(a)) {
                    isDigit++;
                }
                else if (Character.isWhitespace(a)) {
                    isWhitespace++;
                }
                else {
                    isQt++;
                }
            }
            System.out.println(isLetter);
            System.out.println(isWhitespace);
            System.out.println(isDigit);
            System.out.println(isQt);
        }
    }

}
