package com.demo.algorithm.牛客网.华为;

import java.io.*;
import java.util.*;

/**
 题目描述
 输入n个整数，输出其中最小的k个。

 输入描述:
 输入说明
 1 输入两个整数
 2 输入一个整数数组

 输出描述:
 输出一个整数数组

 示例1
 输入
 5 2
 1 3 5 7 2
 输出
 1 2


 思路1： 先排序，后找最小的k个
 思路2： 使用有序堆（重小到大）， 一次遍历（先往堆塞满k个数，后面每次与堆中最大的那个进行判断，要么交换/不交换，如果交换就要进行堆的重新排序，不交换就没事了 ）


 * */
public class 输入n个整数_输出其中最小的k个 {


    // 下面这个是先排序，后找最小的k个
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = null;
//        while ((str = br.readLine()) != null) {
//            if (str.equals("")) continue;
//            String[] params = str.split(" ");
//            int n = Integer.parseInt(params[0]), k = Integer.parseInt(params[1]);
//            int[] res = new int[n];
//            int start = 0, index = 0;
//            if (params.length > 2) start = 2;
//            else params = br.readLine().split(" ");
//            for (int i = start; i < params.length; i++) {
//                res[index++] = Integer.parseInt(params[i]);
//            }
//            Arrays.sort(res);
//            StringBuilder ans = new StringBuilder();
//            for (int i = 0; i < k; i++) ans.append(res[i]).append(" ");
//            System.out.println(ans.toString().trim());
//        }
//    }





    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int n = in.nextInt(), k = in.nextInt();
            Integer[] pInputArray = new Integer[n];
            Integer[] pOutputArray = new Integer[k];
            for (int i = 0; i < n; i++) {
                pInputArray[i] = in.nextInt();
            }
            boolean res = getMinK(n, pInputArray, k, pOutputArray);
            if (res) {
                for (Integer i : pOutputArray) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }


    public static boolean getMinK(int n, Integer[] pInputArray, int k, Integer[] pOutputArray) {
        if (k > n) return false;
        // 实现个比较器，从大到小排
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (Integer i : pInputArray) {
            if (pq.size() == k && i < pq.peek()) {
                pq.poll();
            }
            if (pq.size() < k) {
                pq.offer(i);
            }
        }
        for (int i = k - 1; i >= 0; i--) {
            pOutputArray[i] = pq.poll();
        }
        return true;
    }



}
