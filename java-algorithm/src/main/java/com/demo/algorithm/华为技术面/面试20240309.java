package com.demo.algorithm.华为技术面;

import java.util.*;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 *
 * 示例 2:
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 *
 * 示例 3:
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 */
public class 面试20240309 {

    public static void main(String[] args) {
        //int[] temperatures = {73,74,75,71,69,72,76,73};
        //int[] temperatures = {30,40,50,60};
        int[] temperatures = {30,60,90};

        System.out.println(Arrays.toString(method1(temperatures)));
    }

    //算法1：双指针遍历
    public static int[] method1(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        //遍历，下标差就是值
        int i = 0;
        int j = 1;
        while (i<temperatures.length) {
            while (j<temperatures.length) {
                if (temperatures[j] > temperatures[i]) {
                    answer[i] = j-i;
                    break;
                }
                j++;
            }
            i++;
            j=i+1;
        }

        return answer;
    }

    //算法2：双指针遍历，Map做数据整理（空间换时间）
    public static int[] method2(int[] temperatures) {
        int[] answer = new int[temperatures.length];



        return answer;
    }

}
