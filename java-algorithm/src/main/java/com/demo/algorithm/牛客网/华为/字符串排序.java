package com.demo.algorithm.牛客网.华为;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 题目描述
 编写一个程序，将输入字符串中的字符按如下规则排序。
 规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
 如，输入： Type 输出： epTy
 规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
 如，输入： BabA 输出： aABb
 规则 3 ：非英文字母的其它字符保持原来的位置。
 如，输入： By?e 输出： Be?y
 注意有多组测试数据，即输入有多行，每一行单独处理（换行符隔开的表示不同行）


 输入描述:
 输入字符串
 输出描述:
 输出字符串
 示例1
 输入
 A Famous Saying: Much Ado About Nothing (2012/8).

 输出
 A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).


 思路：
    方法:1： 冒泡排序(这个方法不能保证  规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。 )
    方法2： 对字符串中的字母按照 从 A 到 Z 排列 ，排序后另存到其他空间，

 * */
public class 字符串排序 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a_A = 'a' - 'A'; //大写A在前，小写a在后，这样就是小写字母和大写字母的偏移量

        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            StringBuilder builder = new StringBuilder();
            int length = str.length();

            // 英文字母从A到Z排列，不区分大小写：26 个
            // 先将字符串中的所有字母按从A到Z排列（不区分大小写），放入StringBuilder中
            for (int i=0; i<26; i++) {
                char c = (char) ('A' + i);
                // 遍历字符串
                for (int j=0; j<length; j++) {
                    // 不区分大小写
                    if (c==arr[j] || c==arr[j] - a_A) {
                        builder.append(arr[j]);
                    }
                }
            }

            // 非英文字母的其它字符保持原来的位置
            // 然后遍历原字符串，在非英文字母的其它字符中的下标位置在StringBuilder重新插入
            for (int i=0; i<length; i++) {
                if (!((arr[i] >= 'A' && arr[i] <= 'Z') || (arr[i] >= 'a' && arr[i] <= 'z'))) {
                    builder.insert(i, arr[i]);
                }
            }

            System.out.println(builder.toString());
        }

    }

    // 算法1: 使用Arrays.sort
    public static void withArraysAPI()  {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        String[] ss = new String[num];
        for (int i=0; i<num; i++) {
            ss[i] = in.nextLine();
        }
        Arrays.sort(ss);

        for(String str : ss) {
            System.out.println(str);
        }
    }

    // 算法2: 使用list并自己实现Comparator, 比较能体现算法的思路
    public static void withComparator() {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());
        List<String> list = new ArrayList<>();
        String s = "";
        for (int i=0; i<num; i++) {
            list.add(in.nextLine());
        }

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int i = 0;//第几位，字符串的下标
                while (i < s1.length() && i < s2.length()) {
                    if (s1.charAt(i) != s2.charAt(i)) {
                        return (s1.charAt(i) > s2.charAt(i)) ? 1 : -1;
                    }
                    i++;
                }
                if (s1.length() == s2.length()) {
                    return 0;
                }
                else {
                    return (s1.length() > s2.length()) ? 1 : -1;
                }
            }
        });

        for(String str : list) {
            System.out.println(str);
        }
    }


}
