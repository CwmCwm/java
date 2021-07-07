package com.demo.algorithm.牛客网.华为;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 题目描述
 1、对输入的字符串进行加解密，并输出。
 2加密方法为：
 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 其他字符不做变化。
 3、解密方法为加密的逆过程。



 接口描述：
 实现接口，每个接口实现1个基本操作：
 void Encrypt (char aucPassword[], char aucResult[])：在该函数中实现字符串加密并输出

 说明：
 1、字符串以\0结尾。
 2、字符串最长100个字符。


 int unEncrypt (char result[], char password[])：在该函数中实现字符串解密并输出

 说明：
 1、字符串以\0结尾。
 2、字符串最长100个字符。


 输入描述:
 输入说明
 输入一串要加密的密码
 输入一串加过密的密码

 输出描述:
 输出说明
 输出加密后的字符
 输出解密后的字符

 示例1
 输入
 abcdefg
 BCDEFGH
 输出
 BCDEFGH
 abcdefg


 * */
public class 字符串加解密 {


    public static void main(String []args) throws Exception{
        Scanner scanner =new Scanner(System.in);

        while (scanner.hasNext()) {
            String jiami = scanner.next();
            String jiemi = scanner.next();
            char[] jiamiReuslt = new char[jiami.length()];
            char[] jiemiReuslt = new char[jiemi.length()];

            Encrypt(jiami.toCharArray(), jiamiReuslt);
            unEncrypt(jiemi.toCharArray(), jiemiReuslt);

            System.out.println(new String(jiamiReuslt));
            System.out.println(new String(jiemiReuslt));
        }


    }



    public static void Encrypt (char aucPassword[], char aucResult[]) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i<aucPassword.length; i++) {
            if(aucPassword[i]>='a' && aucPassword[i]<='z') {
                if(aucPassword[i]=='z')
                    stringBuilder.append('A');
                else
                    stringBuilder.append((char)(aucPassword[i]-32+1));
            }
            else if(aucPassword[i]>='A' && aucPassword[i]<='Z') {
                if(aucPassword[i]=='Z')
                    stringBuilder.append('a');
                else
                    stringBuilder.append((char)(aucPassword[i]+32+1));
            }
            else if(aucPassword[i]>='0' && aucPassword[i]<='9') {
                if(aucPassword[i]=='9')
                    stringBuilder.append('0');
                else
                    stringBuilder.append(aucPassword[i]-'0'+1);
            }
        }

        for (int i=0; i<stringBuilder.length(); i++) {
            aucResult[i] = stringBuilder.charAt(i);
        }
    }


    public static void unEncrypt (char result[], char password[]) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<result.length; i++) {
            if(result[i]>='a' && result[i]<='z') {
                if(result[i]=='a')
                    stringBuilder.append('Z');
                else
                    stringBuilder.append((char)(result[i]-32-1));
            }
            else if(result[i]>='A' && result[i]<='Z') {
                if(result[i]=='A')
                    stringBuilder.append('z');
                else
                    stringBuilder.append((char)(result[i]+32-1));
            }
            else if(result[i]>='0' && result[i]<='9') {
                if(result[i]=='0')
                    stringBuilder.append('9');
                else
                    stringBuilder.append(result[i]-'0'-1);
            }
        }

        for (int i=0; i<stringBuilder.length(); i++) {
            password[i] = stringBuilder.charAt(i);
        }
    }


}
