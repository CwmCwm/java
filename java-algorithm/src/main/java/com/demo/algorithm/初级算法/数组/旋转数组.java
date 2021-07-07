package com.demo.algorithm.初级算法.数组;


import java.util.Arrays;

/**
 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 这里是把数组看成圆环，所以才叫“旋转数组”

 示例 1:
 输入: [1,2,3,4,5,6,7] 和 k = 3
 输出: [5,6,7,1,2,3,4]
 解释:
 向右旋转 1 步: [7,1,2,3,4,5,6]
 向右旋转 2 步: [6,7,1,2,3,4,5]
 向右旋转 3 步: [5,6,7,1,2,3,4]

 示例 2:
 输入: [-1,-100,3,99] 和 k = 2
 输出: [3,99,-1,-100]
 解释:
 向右旋转 1 步: [99,-1,-100,3]
 向右旋转 2 步: [3,99,-1,-100]

 说明:
 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 要求使用空间复杂度为 O(1) 的 原地算法。  （原地算法就是不依赖额外的资源或者依赖少数的额外资源，这里就是不能创建一个新的数组，只创建一个变量）


 官方答案
 方法 1：暴力 最简单的方法是旋转 k 次，每次将数组旋转 1 个元素
 方法 2：使用额外的数组 用一个额外的数组来将每个元素放到正确的位置上，也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置
 方法 3：使用环状替换,把元素看做同学，把下标看做座位，大家换座位。第一个同学离开座位去第k+1个座位，第k+1个座位的同学被挤出去了，他就去坐他后k个座位，如此反复。(这样理解比较容易，用个计数记交换的次数去保证全部同学交换)
 方法 4：使用反转  这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。

 个人评价：不是要原地算法吗？怎么有方法2？   方法3倒是想过，不过就是要加些判断   方法4强啊，交换好像很常用到啊

 * */
public class 旋转数组 {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        int k1 = 3;
        int[] nums2 = {-1,-100,3,99};
        int k2 = 2;

        rotate4(nums1, k1);
        rotate4(nums2, k2);
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

    }


    // k就是转换成k次向右推1个位置 （方法1：暴力）
    private static void rotate(int[] nums, int k) {
        for (int count=1; count<=k; count++) {
            int tmpPosition = nums[0];
            for (int i=0; i<nums.length-1; i++) {
                int tmp = nums[i+1];
                nums[i+1] = tmpPosition;
                tmpPosition = tmp;
            }
            nums[0] = tmpPosition;
        }
    }



    // 方法4：使用反转
    private static void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    // 反转
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


}
