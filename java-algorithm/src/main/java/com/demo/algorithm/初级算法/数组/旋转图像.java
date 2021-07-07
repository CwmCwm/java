package com.demo.algorithm.初级算法.数组;



/**
 给定一个 n × n 的二维矩阵表示一个图像。

 将图像顺时针旋转 90 度。

 说明：

 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。

 示例 1:

 给定 matrix =
 [
 [1,2,3],
 [4,5,6],
 [7,8,9]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [7,4,1],
 [8,5,2],
 [9,6,3]
 ]
 示例 2:

 给定 matrix =
 [
 [ 5, 1, 9,11],
 [ 2, 4, 8,10],
 [13, 3, 6, 7],
 [15,14,12,16]
 ],

 原地旋转输入矩阵，使其变为:
 [
 [15,13, 2, 5],
 [14, 3, 4, 1],
 [12, 6, 8, 9],
 [16, 7,10,11]
 ]


 思路：逐层平移和偏移量的增加
 https://leetcode-cn.com/problems/rotate-image/solution/li-kou-48xiao-bai-du-neng-kan-dong-de-fang-fa-zhu-/

 * */
public class 旋转图像 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,3,2,1};
        int[] nums3 = {9,9};


    }


    // 逐层平移和偏移量的增加，外层先翻转，再（层层）翻转内层
    public static void rotate(int[][] matrix) {
        int add = 0;
        int temp = 0;
        int pos1 = 0;
        int pos2 = matrix[0].length - 1;
        // 第一个while是层层向内
        while (pos1 < pos2) {
            add = 0;
            // 第二个while是每层的翻转
            while (add < pos2 - pos1) {
                temp = matrix[pos1][pos1 + add];
                matrix[pos1][pos1 + add] = matrix[pos2 - add][pos1];
                matrix[pos2 - add][pos1] = matrix[pos2][pos2 - add];
                matrix[pos2][pos2 - add] = matrix[pos1 + add][pos2];
                matrix[pos1 + add][pos2] = temp;
                add++;
            }
            pos1++;
            pos2--;
        }
    }


}
