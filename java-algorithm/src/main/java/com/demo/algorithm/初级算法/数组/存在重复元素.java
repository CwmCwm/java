package com.demo.algorithm.初级算法.数组;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 给定一个整数数组，判断是否存在重复元素。
 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false

 示例 1:
 输入: [1,2,3,1]
 输出: true

 示例 2:
 输入: [1,2,3,4]
 输出: false

 示例 3:
 输入: [1,1,1,3,3,4,3,2,4,2]
 输出: true

 官方答案
 方法一：朴素线性查找 【超时】（暴力）
 方法二：排序  如果存在重复元素，排序后它们应该相邻。
 方法三：哈希表 【通过】


 个人评价： 方法2就是将重复问题转成排序问题，就变成了考察排序算法     方法3哈希思想道挺常用的

 * */
public class 存在重复元素 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(containsDuplicate3(nums1));
        System.out.println(containsDuplicate3(nums2));
        System.out.println(containsDuplicate3(nums3));
    }



    // 暴力算法
    private static boolean containsDuplicate1(int[] nums) {
        int tmp;
        for (int i=0; i<nums.length-1; i++) {
            tmp = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (tmp == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }


    // 哈希表，人类思路最简单的算法
    private static boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }




}
