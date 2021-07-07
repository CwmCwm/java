package com.demo.algorithm.牛客网.华为;

import java.io.*;
import java.util.*;

/**
 题目描述
 输入整型数组和排序标识，对其元素按照升序或降序进行排序（一组测试用例可能会有多组数据）

 输入描述:
 1、输入需要输入的整型数个数
 排序标识：0表示按升序，1表示按降序

 输出描述:
 输出排好序的数字

 示例1
 输入
 8
 1 2 4 9 3 55 64 25
 0
 输出
 1 2 3 4 9 25 55 64

 * */
public class 输入整形数组和排序标识_对其元素按照升序或降序进行排序 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str = br.readLine()) != null && str.length() > 0){
            int n = Integer.parseInt(str);
            String[] sarr = br.readLine().split(" ");
            int sig = Integer.parseInt(br.readLine());
            int[] arr = new int[sarr.length];
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(sarr[i]);
            }

            Arrays.sort(arr);
            StringBuilder sb = new StringBuilder();

            if(sig == 0){
                for(int i = 0; i < n; i++){
                    sb.append(arr[i]);
                    if (i != n - 1) sb.append(" ");
                }
            }else{
                for(int i = n - 1; i >= 0; i--){
                    sb.append(arr[i]);
                    if (i != 0) sb.append(" ");
                }
            }
            System.out.println(sb.toString());
        }
    }

}
