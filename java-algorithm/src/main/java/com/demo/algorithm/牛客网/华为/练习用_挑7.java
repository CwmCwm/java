package com.demo.algorithm.牛客网.华为;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 题目描述
 输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数（一组测试用例里可能有多组数据，请注意处理）

 输入描述:
 一个正整数N。(N不大于30000)

 输出描述:
 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.

 示例1
 输入
 20
 输出
 3

 * */
public class 练习用_挑7 {


    // 思路： 一种被7整除     另一种每一位对10取余，余数=7
    public static void main(String[] args) throws Exception {
        BufferedReader bfr= new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while((str=bfr.readLine())!=null){
            int count = 0;
            int num = Integer.parseInt(str);
            for (int i=6; i<=num; i++) {
                if(i%7==0 || iscontain7(i)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean iscontain7(int num){
        int count=0;
        int temp=0;
        while (num!=0) {
            temp=num%10;
            if(temp==7){
                count++;
            }
            num/=10;
        }
        if (count>0) {
            return true;
        } else {
            return false;
        }
    }

}
