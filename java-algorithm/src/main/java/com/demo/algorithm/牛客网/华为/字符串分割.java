package com.demo.algorithm.牛客网.华为;


import java.util.*;


/**
 题目描述
 连续输入字符串(输出次数为N,字符串长度小于100)，请按长度为8拆分每个字符串后输出到新的字符串数组，
 长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 首先输入一个整数，为要输入的字符串个数。

 输入描述:
 首先输入数字n，表示要输入多少个字符串。连续输入字符串(输出次数为N,字符串长度小于100)。

 输出描述:
 按长度为8拆分每个字符串后输出到新的字符串数组，长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。

 示例1
 输入
 2
 abc
 123456789
 输出
 abc00000
 12345678
 90000000


 * */
public class 字符串分割 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = Integer.valueOf(sc.nextLine());
            for (int i = 0; i <n; i++){
                String str = sc.nextLine();
                helper(str);
            }
        }
    }


    private static void helper(String s){
        if (s == null) {
            return;
        }

        // a是该字符串缺少a个字符就能补足到8的倍数
        int a = 0;
        if (s.length() % 8 != 0) {
            a = 8 - s.length()%8;
        }
        while (a > 0) {
            s += "0";
            a--;
        }

        for (int i = 0; i < s.length(); i+=8){
            System.out.println(s.substring(i, i+8));
        }
    }

}
