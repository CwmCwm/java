package com.demo.algorithm.牛客网.华为;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 题目描述
 根据输入的日期，计算是这一年的第几天。。

 详细描述：
 输入某年某月某日，判断这一天是这一年的第几天？。
 测试用例有多组，注意循环输入


 输入描述:
 输入多行，每行空格分割，分别是年，月，日

 输出描述:
 成功:返回outDay输出计算后的第几天;
 失败:返回-1

 示例1
 输入
 2012 12 31
 输出
 366



 * */
public class 计算日期到天数转换 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        while ((str = br.readLine()) != null) {
            String[] strs = str.split(" ");
            int year = Integer.parseInt(strs[0]);
            int month = Integer.parseInt(strs[1]);
            int day = Integer.parseInt(strs[2]);
            int result = day;
            // 累加月份对应的天数
            for (int i = 1; i < month; i++) {
                result += getMonthDays(year, i);
            }
            System.out.println(result);
        }
    }

    // 该月份的天数，注意闰年
    public static int getMonthDays(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 2) {
            return year % 4 == 0 ? 29 : 28;
        }
        return 30;
    }

}
