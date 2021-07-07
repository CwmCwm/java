package com.demo.algorithm.牛客网.华为;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 题目描述
 在计算机中，由于处理器位宽限制，只能处理有限精度的十进制整数加减法，比如在32位宽处理器计算机中，
 参与运算的操作数和结果必须在-2^31~2^31-1之间。如果需要进行更大范围的十进制整数加法，需要使用特殊
 的方式实现，比如使用字符串保存操作数和结果，采取逐位运算的方式。如下：
 9876543210 + 1234567890 = ?
 让字符串 num1="9876543210"，字符串 num2="1234567890"，结果保存在字符串 result = "11111111100"。
 -9876543210 + (-1234567890) = ?
 让字符串 num1="-9876543210"，字符串 num2="-1234567890"，结果保存在字符串 result = "-11111111100"。


 要求编程实现上述高精度的十进制加法。
 要求实现方法：
 public String add (String num1, String num2)
 【输入】num1：字符串形式操作数1，如果操作数为负，则num1的前缀为符号位'-'
 num2：字符串形式操作数2，如果操作数为负，则num2的前缀为符号位'-'
 【返回】保存加法计算结果字符串，如果结果为负，则字符串的前缀为'-'
 注：
 (1)当输入为正数时，'+'不会出现在输入字符串中；当输入为负数时，'-'会出现在输入字符串中，且一定在输入字符串最左边位置；
 (2)输入字符串所有位均代表有效数字，即不存在由'0'开始的输入字符串，比如"0012", "-0012"不会出现；
 (3)要求输出字符串所有位均为有效数字，结果为正或0时'+'不出现在输出字符串，结果为负时输出字符串最左边位置为'-'。


 输入描述:
 输入两个字符串

 输出描述:
 输出给求和后的结果

 示例1
 输入
 9876543210
 1234567890
 输出
 11111111100


 TODO  没有细读
 我的思路是：    两个数都是正数，从两个字符串的最低位逐位相加
               两个数都是负数，从两个字符串的最低位逐位相加，最后前面加个"-"
               一正一负，取绝对值（字符串长度和最高位逐位判断），取绝对值大的符号，大的绝对值-小的绝对值（大的绝对值最低位-小的绝对值 逐位相减）
 * */
public class 无线OSS_高精度整数加法 {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null && line.length() > 0) {
            System.out.println(add(line.trim(), br.readLine().trim()));
        }
    }

    static String add(String s1, String s2) {
        if (s1.length() == 0 || s2.length() == 0)
            return "";
        boolean neg1 = s1.charAt(0) == '-';
        boolean neg2 = s2.charAt(0) == '-';

        if (!(neg1 ^ neg2)) {
            if (s1.length() < s2.length()) {
                String temp = s1;
                s1 = s2;
                s2 = temp;
            }
        } else if (neg1) {
            if (s1.length() < s2.length() + 1) {
                String temp = s1;
                s1 = s2;
                s2 = temp;
                neg1 = false;
                neg2 = true;
            }
        } else if (neg2) {
            if (s1.length() + 1 < s2.length()) {
                String temp = s1;
                s1 = s2;
                s2 = temp;
                neg1 = true;
                neg2 = false;
            }
        }

        int[] lmax = new int[neg1 ? s1.length() - 1 : s1.length()];
        for (int i = neg1 ? 1 : 0; i < lmax.length; ++i)
            lmax[i] = s1.charAt(i) - '0';
        int[] lmin = new int[neg2 ? s2.length() - 1 : s2.length()];
        for (int i = neg2 ? 1 : 0; i < lmin.length; ++i)
            lmin[i] = s2.charAt(i) - '0';

        int i = lmax.length - 1, j = lmin.length - 1;
        if (!(neg1 ^ neg2)) {
            int[] carry = new int[1];
            while (j >= 0) {
                add(lmax, i, lmin[j], carry);
                --i;
                --j;
            }
            StringBuilder sb = new StringBuilder();
            if (neg1)
                sb.append('-');
            if (carry[0] == 1)
                sb.append(1);
            for (i = 0; i < lmax.length; ++i)
                sb.append(lmax[i]);
            return sb.toString();
        } else {
            int flag = 0;
            boolean neg = true;
            if (i == j) {
                flag = -1;
                for (int k = 0; k <= i; ++k) {
                    if (lmax[k] > lmin[k]) {
                        flag = 0;
                        neg = neg1;
                        break;
                    } else if (lmax[k] < lmin[k]) {
                        flag = 1;
                        neg = neg2;
                        break;
                    }
                }
            }
            if (flag == -1)
                return "0";
            if (flag == 1) {
                int[] temp = lmax;
                lmax = lmin;
                lmin = temp;
            }
            while (j >= 0) {
                minus(lmax, i, lmin[j]);
                --i;
                --j;
            }
            int L = 0;
            for (i = 0; i < lmax.length; ++i) {
                if (lmax[i] == 0) {
                    ++L;
                } else {
                    break;
                }
            }
            StringBuilder sb = new StringBuilder();
            if (neg)
                sb.append('-');
            for (i = L; i < lmax.length; ++i)
                sb.append(lmax[i]);
            return sb.toString();
        }
    }

    static void add(int[] lmax, int i, int val, int[] carry) {
        if (i == -1) {
            carry[0] = 1;
            return;
        }
        lmax[i] += val;
        if (lmax[i] >= 10) {
            lmax[i] = lmax[i] - 10;
            add(lmax, --i, 1, carry);
        }
    }

    static void minus(int[] max, int i, int val) {
        max[i] -= val;
        if (max[i] < 0) {
            max[i] = max[i] + 10;
            minus(max, --i, 1);
        }
    }


}
