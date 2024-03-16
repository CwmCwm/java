package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 对字符串中的所有单词进行倒排。

 说明：
 1、构成单词的字符只有26个大写或小写英文字母；
 2、非构成单词的字符均视为单词间隔符；
 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 4、每个单词最长20个字母；

 输入描述:
 输入一行以空格来分隔的句子

 输出描述:
 输出句子的逆序

 示例1
 输入
 I am a student
 输出
 student a am I

 * */
public class 单词倒排 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            String res = reverse(str);
            System.out.println(res);
        }
    }


    public static String reverse(String str) {
        // 匹配非字母的字符进行分割
        String[] words = str.split("[^A-Za-z]");
        StringBuilder result = new StringBuilder();

        // 逆序添加分割完的单词
        for (int i=words.length-1; i>= 0; i--) {
            result.append(words[i]).append(" ");
        }
        return result.toString().trim();
    }

}
