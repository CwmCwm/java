package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。
 给出多个名字，计算每个名字最大可能的“漂亮度”。
 输入描述:
 整数N，后续N个名字

 输出描述:
 每个名称可能的最大漂亮程度

 示例1
 输入
 2
 zhangsan
 lisi
 输出
 192
 101


 思路： 其实就是计算出各个字母出现的次数，出现次数最多的字母的“漂亮度”最大（26），后面按次数依次递减

 * */
public class 名字的漂亮度 {

    private static final int N = 26;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            for (int i = 0; i < n; i++) {
                String name = in.nextLine().toLowerCase();
                int result = count(name);
                System.out.println(result);
            }
        }
    }

    // 这里的这个转换强啊
    public static int count(String name) {
        // int[] arr 就是 a-z(0-25) 字母数的统计
        int[] arr = new int[N];
        for (int i = 0; i < name.length(); i++) {
            char ch = name.charAt(i);
            arr[ch - 'a']++;
        }
        // 直接排序，后面就跟具体字母无关了
        Arrays.sort(arr);

        //  arr数组的从后面开始遍历和权重--
        int result = 0;
        for (int weight = N, i = N - 1; i >= 0; i--) {
            if (arr[i] != 0) {
                result += weight * arr[i];
                weight--;
            }
        }
        return result;
    }


}
