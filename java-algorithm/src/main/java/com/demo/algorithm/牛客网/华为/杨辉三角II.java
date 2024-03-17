package com.demo.algorithm.牛客网.华为;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 *
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 *
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 *
 */
public class 杨辉三角II {

    public static void main(String[] args) {



    }

    //杨辉三角
    public static List<Integer> method1(int rowIndex) {
        //构造指定行数的那一行数组
        Integer[] dp = new Integer[rowIndex + 1];

        //全部填充1作为初始数据
        Arrays.fill(dp,1);

        //i是杨辉三角的行数，计算每一层的杨辉三角，所以要层层计算
        //j是每一层中间的需要计算的位置，后遍历就没问题（不能前遍历，因为会将数组下标会重复叠加）
        for (int i=2; i<dp.length; i++) {
            for (int j=i-1; j>0; j--) {
                dp[j] = dp[j] + dp[j-1];
            }
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public static List<Integer> method2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex-i)/(i+1);
        }
        return res;
    }

}
