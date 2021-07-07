package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 题目标题：

 判断短字符串中的所有字符是否在长字符串中全部出现

 输入描述:
 输入两个字符串。第一个为短字符，第二个为长字符。

 输出描述:
 返回值：

 示例1
 输入
 bc
 abc
 输出
 true

 * */
public class 字符串匹配 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String pShortString = in.nextLine();
            String pLongString = in.nextLine();
            boolean res = isAllCharExist(pShortString, pLongString);
            System.out.println(res);
        }
    }


    public static boolean isAllCharExist(String pShortString, String pLongString) {
        Set<Character> set = new HashSet<>();
        for (char ch : pLongString.toCharArray()) {
            set.add(ch);
        }
        for (char ch : pShortString.toCharArray()) {
            if (!set.contains(ch)) {
                return false;
            }
        }
        return true;
    }

}
