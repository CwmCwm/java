package com.demo.algorithm.牛客网.华为;


import java.util.*;

/**
 题目描述
 如果统计的个数相同，则按照ASCII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。

 实现以下接口：
 输入一个字符串，对字符中的各个英文字符，数字，空格进行统计（可反复调用）
 按照统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出
 清空目前的统计结果，重新统计
 调用者会保证：
 输入的字符串以‘\0’结尾。

 输入描述:
 输入一串字符。

 输出描述:
 对字符中的
 各个英文字符（大小写分开统计），数字，空格进行统计，并按照统计个数由多到少输出,如果统计的个数相同，则按照ASII码由小到大排序输出 。如果有其他字符，则对这些字符不用进行统计。

 示例1
 输入
 aadddccddc
 输出
 dca



 * */
public class 字符统计 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str = in.nextLine();
            String res = count(str);
            System.out.println(res);
        }

    }


    public static String count(String str) {
        int N = 127;
        int[] arr = new int[N];
        for (char ch : str.toCharArray()) {
            if (ch >= N) continue;
            arr[ch]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            if (arr[i] != 0) {
                pq.offer(new Pair(i, arr[i]));
            }
        }
        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            res.append(pq.poll().get());
        }
        return res.toString();
    }


    // 构造类实现 Comparable接口，注意比较 Comparable接口和Comparator接口的区别
    static class Pair implements Comparable<Pair>{
        private int value;
        private int times;
        public Pair(int value, int times) {
            this.value = value;
            this.times = times;
        }
        public int compareTo(Pair that) {
            if (this.times == that.times) {
                return this.value - that.value;
            }
            return that.times - this.times;
        }
        public char get() {
            return (char)value;
        }
    }

}
