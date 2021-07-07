package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符

 输入描述:
 将一个英文语句以单词为单位逆序排放。

 输出描述:
 得到逆序的句子

 示例1
 输入
 I am a boy
 输出
 boy a am I

 * */
public class 句子逆序 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String sentence = scanner.nextLine();
            System.out.println(reverse(sentence));
        }
    }


    public static String reverse(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=words.length-1; i>=0; i--) {
            stringBuilder.append(words[i] + " ");
        }
        return stringBuilder.toString();
    }


}
