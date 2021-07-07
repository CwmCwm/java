package com.demo.algorithm.初级算法.数组;


import java.util.HashSet;

/**
 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 说明：
 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

 示例 1:
 输入: [2,2,1]
 输出: 1

 示例 2:
 输入: [4,1,2,1,2]
 输出: 4

 像这种存不存，重不重复，哈希很常用啊

 官方答案
 方法3： 使用集合存储数组中出现的所有数字，并计算数组中的元素之和。由于集合保证元素无重复，因此计算集合中的所有元素之和的两倍，即为每个元素出现两次的情况下的元素之和。由于数组中只有一个元素出现一次，其余元素都出现两次，因此用集合中的元素之和的两倍减去数组中的元素之和，剩下的数就是数组中只出现一次的数字。

 个人评价：方法3是针对这一题意，不通用

 * */
public class 只出现一次的数字 {

    public static void main(String[] args) {
        int[] nums1 = {2,2,1};
        int[] nums2 = {4,1,2,1,2};
        int[] nums3 = {4,1,2,1,2,11,100,11,100};

        System.out.println(singleNumber2(nums1));
        System.out.println(singleNumber2(nums2));
        System.out.println(singleNumber2(nums3));
    }


    // 傻傻的我用 HashSet
    private static int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i<nums.length; i++) {
            for (int j=i+1; j<nums.length; j++) {
                if (nums[i] == nums[j]) {
                    set.add(nums[i]);
                    break;
                }
            }
        }

        for (int x : nums) {
            if (!set.contains(x)) {
                return x;
            }
        }
        return 0;
    }


    // 异或运算,这个太难了，要前置知识
    public static int singleNumber2(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }



}
