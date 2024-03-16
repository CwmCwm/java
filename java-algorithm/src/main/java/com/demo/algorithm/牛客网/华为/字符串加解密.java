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


    public static void main(String []args) {
        Scanner scanner =new Scanner(System.in);

        while (scanner.hasNext()) {
            String jiami = scanner.nextLine();
            String jiemi = scanner.nextLine();

            System.out.println(new String(encrypt(jiami.toCharArray())));
            System.out.println(new String(unEncrypt(jiemi.toCharArray())));
        }

    }


    public int a_A = 'a' - 'A';//不记得偏移量是32，那就计算出来

    //加密
    public static char[] encrypt (char source[]) {
        //target用于存放加密后的字符串
        char[] target = new char[source.length];

        //遍历source中每个字符，然后进行加密
        for (int i=0; i<source.length; i++) {
            if (source[i]>='a' && source[i]<='z') {
                if (source[i]=='z') {
                    target[i] = 'A';
                }
                else {
                    target[i] = (char)(source[i]-32+1);
                }

            }
            else if(source[i]>='A' && source[i]<='Z') {
                if (source[i]=='Z') {
                    target[i] = 'a';
                }
                else {
                    target[i] = (char)(source[i]+32+1);
                }
            }
            else if(source[i]>='0' && source[i]<='9') {
                if(source[i]=='9') {
                    target[i] = '0';
                }
                else {
                    target[i] = (char)(source[i]+1);
                }
            }
        }

        return target;
    }

    //解密
    public static char[] unEncrypt (char source[]) {
        //target用于存放解密后的字符串
        char[] target = new char[source.length];

        for(int i=0; i<source.length; i++) {
            if (source[i]>='a' && source[i]<='z') {
                if (source[i]=='a') {
                    target[i] = 'Z';
                }
                else {
                    target[i] = (char)(source[i]-32-1);
                }
            }
            else if (source[i]>='A' && source[i]<='Z') {
                if(source[i]=='A') {
                    target[i] = 'z';
                }
                else {
                    target[i] = (char)(source[i]+32-1);
                }
            }
            else if (source[i]>='0' && source[i]<='9') {
                if (source[i]=='0') {
                    target[i] = '9';
                }
                else {
                    target[i] = (char)(source[i]-1);
                }
            }
        }

        return target;
    }


}
