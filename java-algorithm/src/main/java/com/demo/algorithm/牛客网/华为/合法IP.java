package com.demo.algorithm.牛客网.华为;


import java.util.*;

/**
 题目描述
 现在IPV4下用一个32位无符号整数来表示，一般用点分方式来显示，点将IP地址分成4个部分，每个部分为8位，表示成一个无符号整数（因此不需要用正号出现），
 如10.137.17.1，是我们非常熟悉的IP地址，一个IP地址串中没有空格出现（因为要表示成一个32数字）。

 现在需要你用程序来判断IP是否合法。
 输入描述:
 输入一个ip地址

 输出描述:
 返回判断的结果YES or NO

 示例1
 输入
 10.138.15.1
 输出
 YES


 * */
public class 合法IP {


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String s = in.nextLine();
            String[] arr = s.split("\\.");
            if (helper(arr)) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean helper(String[] arr){
        for (int i = 0; i < arr.length; i++){
            if (invalid(arr[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean invalid(String s){
        if (s == "") {
            return true;
        }
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) > '9' || s.charAt(i) < '0'){
                return true;
            }
        }
        if (Integer.valueOf(s) > 255) {
            return true;
        }
        return false;
    }

}
