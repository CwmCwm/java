package com.demo.algorithm.牛客网.华为;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 题目描述
 密码要求:
 1.长度超过8位
 2.包括大小写字母.数字.其它符号,以上四种至少三种
 3.不能有相同长度大于2的子串重复


 输入描述:
 一组或多组长度超过2的子符串。每组占一行

 输出描述:
 如果符合要求输出：OK，否则输出NG

 示例1
 输入
 021Abc9000
 021Abc9Abc1
 021ABC9000
 021$bc9000
 输出
 OK
 NG
 NG
 OK


 * */
public class 密码验证合格程序 {


    //
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String input = in.nextLine();
            // 1.长度超过8位
            if (input.length() < 9) {
                System.out.println("NG");
                continue;
            }

            // 2.包括大小写字母.数字.其它符号,以上四种至少三种
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            int count4 = 0;
            for (int i=0; i<input.length(); i++) {
                if (input.charAt(i) >= 'a' && input.charAt(i) <= 'z') {
                    count1 = 1;
                }
                else if (input.charAt(i) >= 'A' && input.charAt(i) <= 'Z') {
                    count2 = 1;
                }
                else if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
                    count3 = 1;
                }
                else {
                    count4 = 1;
                }
            }
            if (count1+count2+count3+count4 < 3) {
                System.out.println("NG");
                continue;
            }

            // 3.不能有相同长度大于2的子串重复  <=> 即！（i=i+3,i+1=i+4,i+2=i+5）的泛化
            // 类似两个连接在一起的滑动窗口的比较，用字串只需要3格就够，因为4/5/n格相等都会退化为3个相等
            boolean flag3 = true;
            for (int i=0; i<input.length()-5; i++) {
                for (int j=i+3; j<input.length()-2; j++) {
                    if (input.substring(i, i+3).equals(input.substring(j, j+3))) {
                        flag3 = false;
                        break;
                    }
                }
            }

            if (flag3) {
                System.out.println("OK");
            }
            else {
                System.out.println("NG");
            }
        }
    }

    // 检查是否满足正则
    private static boolean getMatch(String str){
        int count = 0;
        Pattern p1 = Pattern.compile("[A-Z]");
        if(p1.matcher(str).find()){
            count++;
        }
        Pattern p2 = Pattern.compile("[a-z]");
        if(p2.matcher(str).find()){
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if(p3.matcher(str).find()){
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if(p4.matcher(str).find()){
            count++;
        }
        if(count >= 3){
            return false;
        }
        else{
            return true;
        }
    }

    // 校验是否有重复子串
    private static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        }
        else {
            return getString(str,l+1,r+1);
        }
    }

}
