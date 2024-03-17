package com.demo.algorithm.牛客网.华为;


import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 *
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 *
 */
public class 杨辉三角 {

    public static void main(String[] args) {



    }

    //杨辉三角
    //按照杨辉三角的图形和算法组织数据
    public static List<List<Integer>> method1(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int j=1; j<i; j++) {
                row.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            if (i != 0) {
                row.add(1);
            }
            ans.add(row);
        }
        return ans;
    }

}
