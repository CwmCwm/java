package com.demo.algorithm.牛客网.华为;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 题目描述
 从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
 本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
 数据范围小于1e6
 输入描述:
 输入任意个整数

 输出描述:
 输出负数个数以及所有非负数的平均值

 示例1
 输入
 -13
 -4
 -7
 输出
 3
 0.0

 这题之前有了，重复

 * */
public class 记负均正II {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nNum=0;
        int pNum=0;
        int pSum=0;
        String str;
        while((str=br.readLine())!=null){
            int n=Integer.valueOf(str);
            if(n>=0){
                pNum++;
                pSum+=n;
            }else{
                nNum++;
            }
        }
        System.out.println(nNum);
        System.out.println(Math.round(pSum*10.0/pNum)/10.0);
    }

}
