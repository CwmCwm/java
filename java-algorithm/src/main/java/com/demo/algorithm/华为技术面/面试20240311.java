package com.demo.algorithm.华为技术面;

import java.util.ArrayList;
import java.util.List;

/**
 * 一位有名的美容师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此不能接受相邻的预约。
 * 给定一个预约请求序列，替美容师找到最优的预约集合（总预约时间最长），返回总的分钟数和最优的预约集合的客户编号。
 *
 * 示例 1：
 * 输入： [1,2,3,1]
 * 输出： 4, [1,3]
 * 解释： 选择 1号预约和 3号预约，总时长 = 1 + 3 = 4。
 *
 * 示例 2：
 * 输入： [2,7,9,3,1]
 * 输出： 12, [1,3,5]
 * 解释： 选择 1号预约、 3号预约和 5号预约，总时长 = 2 + 9 + 1 = 12。
 *
 * 示例 3：
 * 输入： [2,1,4,5,3,1,1,3]
 * 输出： 12, [1,3,5,8]
 * 解释： 选择 1号预约、 3号预约、 5号预约和 8号预约，总时长 = 2 + 4 + 3 + 3 = 12。
 */
public class 面试20240311 {

    public static void main(String[] args) {
        //int[] yuYue = {1,2,3,1};
        //int[] yuYue = {2,7,9,3,1};
        int[] yuYue = {2,1,4,5,3,1,1,3};
        //int[] yuYue = {2,100,4,5,3,1,1,3};
        //int[] yuYue = {2,1,4,500,3,1,1,3};
        //int[] yuYue = {2,1,4,5,300,1,1,3};

        System.out.println(rec_opt(yuYue, yuYue.length-1));

    }

    //动态规划，TODO，总是看不懂
    //重后面遍历，递归
    public static int rec_opt(int[] yuYue, int i) {
        //递归终止的条件,意味着如果只能选第一个,那么最好的方法就是yuYue[0]
        if (i==0) {
            return yuYue[0];
        }
        //处理特殊情况,因为题目要求间隔选择
        else if (i==1) {
            return Math.max(yuYue[0], yuYue[1]);
        }


        else {
            int a = rec_opt(yuYue,i-2) + yuYue[i];  //对于每一个顾客无非两种情况,选或者不选,如果选的话,就是,i-2个的最优解加上当前的value
            int b = rec_opt(yuYue,i-1);             //如果不选,那么就只能使用上一个的最优解
            return Math.max(a,b);                      //最后比较两种情况,得出当前情况的最优解
        }
    }

}
