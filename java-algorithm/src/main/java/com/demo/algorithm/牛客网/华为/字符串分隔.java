package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 输入描述:
 连续输入字符串(输入2次,每个字符串长度小于100)

 输出描述:
 输出到长度为8的新字符串数组

 示例1
 输入
 复制
 abc
 123456789
 输出
 复制
 abc00000
 12345678
 90000000


 * */
public class 字符串分隔 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()) {
            String string1 = scanner.nextLine();
            split8(string1);
        }
    }

    // 先填充到8的整数倍，再拆分输出
    public static void split8(String string1) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string1);
        // 注意刚好是8的整数倍
        int supply = 8 - string1.length()%8;
        supply = supply==8 ? 0 : supply;
        for (int i=0; i<supply; i++) {
            stringBuilder.append("0");
        }

        String string2 = stringBuilder.toString();
        while (string2.length() > 0) {
            System.out.println(string2.substring(0, 8));
            string2 = string2.substring(8);
        }
    }


}
