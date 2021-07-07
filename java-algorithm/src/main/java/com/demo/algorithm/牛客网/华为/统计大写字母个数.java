package com.demo.algorithm.牛客网.华为;


import java.io.*;

/**
 题目描述
 找出给定字符串中大写字符(即'A'-'Z')的个数

 输入描述:
 输入一个String数据

 输出描述:
 输出string中大写字母的个数

 示例1
 输入
 add123#$%#%#O
 输出
 1


 * */
public class 统计大写字母个数 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while((line=br.readLine()) !=  null){
            int num=0;
            for (char c: line.toCharArray()){
                if(c>='A' && c<='Z') {
                    num++;
                }
            }
            System.out.println(num);
        }
    }



}
