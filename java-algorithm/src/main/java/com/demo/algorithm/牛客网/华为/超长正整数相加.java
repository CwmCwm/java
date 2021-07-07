package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 请设计一个算法完成两个超长正整数的加法。

 接口说明
本题有多组输入数据，请使用while(cin>>)等方式读取

输入描述:
输入两个字符串数字

输出描述:
输出相加后的结果，string型

示例1
输入
99999999999999999999999999999999999999999999999999
1
输出
100000000000000000000000000000000000000000000000000

 * */
public class 超长正整数相加 {



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String addend = in.next();
            String augend = in.next();
            String res = addLongInteger(addend, augend);
            System.out.println(res);
        }
    }

    // 从最低位开始加
    public static String addLongInteger(String addend, String augend) {
        StringBuilder res = new StringBuilder();
        // 进位信息
        int carry = 0;
        int i = addend.length() - 1, j = augend.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;
            if (i >= 0) {
                sum += addend.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += augend.charAt(j--) - '0';
            }
            res.append(sum % 10);
            carry = sum / 10;
        }
        return res.reverse().toString();
    }

}
