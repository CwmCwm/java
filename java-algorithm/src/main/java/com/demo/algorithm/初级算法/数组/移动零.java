package com.demo.algorithm.初级算法.数组;


import java.util.Arrays;

/**
 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

 示例:
 输入: [0,1,0,3,12]
 输出: [1,3,12,0,0]

 说明:
 必须在原数组上操作，不能拷贝额外的数组。
 尽量减少操作次数。


 个人评价：滑动窗口/双指针，我一般都叫滑动窗口，比较有画面感

 * */
public class 移动零 {


    public static void main(String[] args) {
        int[] nums1 = {0,1,0,3,12};
        moveZeroes(nums1);
        System.out.println(Arrays.toString(nums1));

    }


    // 看其他人的答案有个技巧不用交互值，因为这里固定值0，才有直接修改值为0
    // 滑动窗口/双指针
    public static void moveZeroes(int[] nums) {
        // startIndex， endIndex 滑动窗口的起止
        int startIndex = 0;
        int endIndex = 0;
        int lastIndex = nums.length-1;

        while (endIndex <= lastIndex) {
            if (nums[endIndex] != 0) {
                swap(nums, startIndex, endIndex);
                startIndex++;
            }
            endIndex++;
        }
    }
    // 交互数组两个位置的值
    public static void swap(int[] nums, int firstIndex, int secondIndex) {
        int tmp = nums[firstIndex];
        nums[firstIndex] = nums[secondIndex];
        nums[secondIndex] = tmp;
    }



}
