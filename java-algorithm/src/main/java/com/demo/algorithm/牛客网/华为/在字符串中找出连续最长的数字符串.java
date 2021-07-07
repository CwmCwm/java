package com.demo.algorithm.牛客网.华为;


import java.util.*;

/**

 题目描述
 样例输出

 输出123058789，函数返回值9
 输出54761，函数返回值5

 输入描述:
 输入一个字符串。

 输出描述:
 输出字符串中最长的数字字符串和它的长度，中间用逗号间隔。如果有相同长度的串，则要一块儿输出（中间不间隔），但是长度还是一串的长度，与数字字符串间用逗号间隔。

 示例1
 输入
 abcd12345ed125ss123058789
 输出
 123058789,9


 * */
public class 在字符串中找出连续最长的数字符串 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String pInStr = in.nextLine();
            List<String> pOutputstr = new LinkedList<>();
            int res = continumax(pOutputstr, pInStr);
            for (String str : pOutputstr) {
                System.out.print(str);
            }
            System.out.println("," + res);
        }
    }

    public static int continumax(List<String> pOutputstr,  String intputstr) {
        int max = 0 ;
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < intputstr.length(); i++) {
            // 找出连续最长数字串
            if (intputstr.charAt(i) >= '0' && intputstr.charAt(i) <= '9') {
                while (i < intputstr.length() && intputstr.charAt(i) >= '0' && intputstr.charAt(i) <= '9') {
                    s.append(intputstr.charAt(i++));
                }
                max = Math.max(max, s.length());
                pOutputstr.add(s.toString());
                s.setLength(0);
            }
        }
        // 移除短的数字串
        for (int i = 0; i < pOutputstr.size(); i++) {
            if (pOutputstr.get(i).length() < max) {
                pOutputstr.remove(i);
                i--;
            }
        }
        return max;
    }

}
