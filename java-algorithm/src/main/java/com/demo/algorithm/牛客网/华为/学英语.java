package com.demo.algorithm.牛客网.华为;

import java.util.*;
import java.io.*;

/**
 题目描述
 Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 如22：twenty two，123：one hundred and twenty three。

 说明：
 数字为正整数，长度不超过九位，不考虑小数，转化结果为英文小写；
 输出格式为twenty two；
 非法数据请返回“error”；
 关键字提示：and，billion，million，thousand，hundred。

 方法原型：public static String parse(long num)


 输入描述:
 输入一个long型整数

 输出描述:
 输出相应的英文写法

 示例1
 输入
 2356
 输出
 two thousand three hundred and fifty six


 * */
public class 学英语 {

    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            Integer l = Integer.valueOf(line);
            System.out.println(parse(l));
        }
    }
    public static String parse(int num){
        String[] numStr={"zero","one","two","three","four","five", "six","seven","eight","nine","ten",
                "eleven","twelve", "thirteen","fourteen","fifteen","sixteen","seventeen", "eighteen","ninteen"};
        if (num>=0 && num<20) {
            return numStr[num];
        } else if (num>=20 && num<100) {
            int a=num%10;
            if (num<30) {
                return a !=0?"twenty "+parse(a):"twenty";
            } else if (num<40){
                return a !=0?"thirty "+parse(a):"thirty";
            } else if (num<50){
                return a !=0?"forty "+parse(a):"forty";
            } else if (num<60){
                return a !=0?"fifty "+parse(a):"fifty";
            } else if (num<70){
                return a !=0?"sixty "+parse(a):"sixty";
            } else if (num<80){
                return a !=0?"seventy "+parse(a):"seventy";
            } else if (num<90){
                return a !=0?"eighty "+parse(a):"eighty";
            } else if (num<100){
                return a !=0?"ninety "+parse(a):"ninety";
            }
        } else if (num>=100 && num<1000) {
            int x=num/100;
            int y=num%100;
            if (y!=0) {
                return parse(x)+" hundred"+ " and "+ parse(y);
            } else {
                return parse(x)+" hundred";
            }
        } else if (num>=1000 && num<1000000) {
            int x=num/1000;
            int y=num%1000;
            if(y!=0){
                return parse(x)+" thousand "+ parse(y);
            }else{
                return parse(x)+" thousand";
            }
        } else if (num>=1000000 && num<100000000) {
            int x=num/1000000;
            int y=num%1000000;
            if(y!=0){
                return parse(x)+" million "+ parse(y);
            }else{
                return parse(x)+" million";
            }
        }
        return "error";
    }


}
