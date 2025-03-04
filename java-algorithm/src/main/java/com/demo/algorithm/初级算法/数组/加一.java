package com.demo.algorithm.初级算法.数组;


import java.util.Arrays;

/**
 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 你可以假设除了整数 0 之外，这个整数不会以零开头。

 示例 1:
 输入: [1,2,3]
 输出: [1,2,4]
 解释: 输入数组表示数字 123。

 示例 2:
 输入: [4,3,2,1]
 输出: [4,3,2,2]
 解释: 输入数组表示数字 4321。


 个人评价：思路好像很简单嘛，考察边界判断和写法的细节

 * */
public class 加一 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {4,3,2,1};
        int[] nums3 = {9,9};

        System.out.println(Arrays.toString(plusOne(nums1)));
        System.out.println(Arrays.toString(plusOne(nums2)));
        System.out.println(Arrays.toString(plusOne(nums3)));
    }


    public static int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i=length-1; i>=0; i--) {
            if ((digits[i] + 1) % 10 != 0) {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }

        // 会运行到这里就是 全部为9 这种情况
        int[] result = new int[length+1];
        result[0] = 1;
        return result;
    }



}
