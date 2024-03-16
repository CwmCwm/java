package com.demo.algorithm.华为技术面;


import java.util.Arrays;

/**
 * 一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 *
 * 示例 1：
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 *
 * 示例 2：
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 *
 * 示例 3：
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 */
public class 数组内元素排序 {

    public static void main(String[] args) {
        //int[] nums = {2,5,1,3,4,7};
        //int[] nums = {1,2,3,4,4,3,2,1};
        int[] nums = {1,1,2,2};

        System.out.println(Arrays.toString(method1(nums)));
    }

    //算法1：按顺序取出元素后重新放入数组中
    //@param    nums    确保元素个数为偶数
    public static int[] method1(int[] nums) {
        int xIndex = 0;                     //按照题意，数组前一半的下标
        int yIndex = nums.length/2;         //按照题意，数组后一半的下标
        int[] nums1 = new int[nums.length]; //新数组，用来按顺序取出元素后重新放入数组中
        int nums1Index = 0;                 //nums1的下标

        //按下标位置替换
        while (nums1Index < nums1.length) {
            nums1[nums1Index] = nums[xIndex];
            nums1[nums1Index+1] = nums[yIndex];

            nums1Index = nums1Index + 2;
            xIndex++;
            yIndex++;
        }

        return nums1;
    }


}
