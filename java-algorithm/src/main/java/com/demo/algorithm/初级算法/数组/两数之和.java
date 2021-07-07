package com.demo.algorithm.初级算法.数组;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
  
 示例:
 给定 nums = [2, 7, 11, 15], target = 9
 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]

 官方答案：
 方法一：暴力法
 方法二：两遍哈希表
 方法三：一遍哈希表

 个人评价：方法一最容易想到，   方法二和方法三思想一致，就是方法三优化一下


 * */
public class 两数之和 {

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;

        System.out.println(Arrays.toString(twoSum3(nums1, target1)));
    }


    // 双下标、暴力
    public static int[] twoSum(int[] nums, int target) {
        int firstIndex = 0;
        int secondIndex = 0;
        int[] result = new int[2];

        for (; firstIndex<nums.length-1; firstIndex++) {
            for (secondIndex=firstIndex+1; secondIndex<nums.length; secondIndex++) {
                if (nums[firstIndex]+nums[secondIndex] == target) {
                    return new int[] { firstIndex, secondIndex};
                }
            }
        }
        return null;
    }


    // 方法三：一遍哈希表
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference)) {
                return new int[] {map.get(difference), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
