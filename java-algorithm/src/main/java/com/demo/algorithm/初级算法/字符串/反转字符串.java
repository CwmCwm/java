package com.demo.algorithm.初级算法.字符串;


import java.util.Arrays;

/**
 示例 1：

 输入：["h","e","l","l","o"]
 输出：["o","l","l","e","h"]
 示例 2：

 输入：["H","a","n","n","a","h"]
 输出：["h","a","n","n","a","H"]


 * */
public class 反转字符串 {

    public static void main(String[] args) {
        String string1 = "hello";
        String string2 = "Hannah";
        char[] s1 = string1.toCharArray();
        char[] s2 = string2.toCharArray();
        reverseString(s1);
        reverseString(s2);

        System.out.println(Arrays.toString(s1));
        System.out.println(Arrays.toString(s2));

    }

    // 遍历到数组的中间位置，遍历过程中交换头和尾
    public static void reverseString(char[] s) {
        int middleIndex = s.length / 2;
        for (int i=0; i<middleIndex; i++) {
            char tmp = s[i];
            s[i] = s[s.length-1-i];
            s[s.length-1-i] = tmp;
        }
    }


}
