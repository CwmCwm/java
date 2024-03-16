package com.demo.algorithm.华为技术面;


import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 现有一批杂乱的字符串，请逐个判断每个字符串是否是合法的工号，把非法的直接丢弃，并将合法的整理成规定的格式。
 * 合法工号：去除所有空格后，长度不超过9；首位为字母、其它均为数字（至少有一个数字）。
 * 格式化要求（格式化后如：a00012345）：工号首字母统一规整成小写字符。去除所有空格。
 * 如果工号不满9位，在数字前面补零，使工号长度恰好为9。
 * 请对格式化后的合法工号，去重后，按照字典序升序输出。
 * 解答要求时间限制：1000ms, 内存限制：256MB
 */
public class 整理工号 {

    public static void main(String[] args) {

        String[] gongHaos = {"a1", "b1", "a12345678", "a123456789", "aa1", "a", "123"};

        //用于存放合法的工号，同时按照字典序升序
        Set<String> set = new TreeSet<>();

        //处理工号
        for (String gongHao : gongHaos) {
            //合法工号：去除所有空格后，长度不超过9；首位为字母、其它均为数字（至少有一个数字）。
            //格式化要求（格式化后如：a00012345）：工号首字母统一规整成小写字符。去除所有空格。
            String tmp = gongHao.replace(" ", "").toLowerCase();
            if (tmp.length()<2 || tmp.length()>9) {
                continue;
            }
            if (tmp.charAt(0)<'a' || tmp.charAt(0)>'z') {
                continue;
            }
            boolean qiYuShiShuZi = true;
            for (int i=1; i<tmp.length(); i++) {
                if (tmp.charAt(i)<'0' || tmp.charAt(i)>'9') {
                    qiYuShiShuZi = false;
                    break;
                }
            }
            if (!qiYuShiShuZi) {
                continue;
            }

            //如果工号不满9位，在数字前面补零，使工号长度恰好为9。
            //对格式化后的合法工号，去重后，按照字典序升序输出。
            if (tmp.length()<9) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder = stringBuilder.append(tmp.charAt(0));
                int buLing = 9 - tmp.length();
                for (int i=0; i<buLing; i++) {
                    stringBuilder = stringBuilder.append("0");
                }
                stringBuilder = stringBuilder.append(tmp.substring(1));
                set.add(stringBuilder.toString());
            }
            else {
                set.add(tmp);
            }
        }

        //输出整理后的工号
        for (String string : set) {
            System.out.println(string);
        }
    }


}
