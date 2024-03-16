package com.demo.algorithm.牛客网.华为;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 面试1 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            String[] num1 = scanner.nextLine().split(" ");
//            String[] num2 = scanner.nextLine().split(" ");
//
//            int[] nums1 = new int[num1.length];
//            int[] nums2 = new int[num2.length];
//            int[] result = new int[nums1.length+nums2.length];
//
//            for(int i=0; i<num1.length; i++) {
//                result[i] = Integer.parseInt(num1[i]);
//            }
//            for(int i=num1.length, j=0; i<num1.length+num2.length; i++,j++) {
//                result[i] = Integer.parseInt(num2[j]);
//            }
//
//            Arrays.sort(result);
//        }



        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
//        int[] nums1 = {1,10,20,0,0,0};
//        int[] nums2 = {2,5,6};
        System.out.println(Arrays.toString(sort1(nums1, nums2)));

    }




    // 算法1，很像滑动窗口
    // num1的数组大小 = num1的有效数组大小 + num2的有效数组大小
    public static int[] sort1(int[] nums1, int[] nums2) {
        // rightIndex 和 leftIndex 都是 nums1的下标
        // rightIndex是num1的最大下标
        // leftIndex 是num1的有效数组最大下标
        int rightIndex = nums1.length-1;
        int leftIndex = nums1.length-nums2.length-1;

        // 从后遍历 nums2
        for (int nums2Index=nums2.length-1; nums2Index>=0; nums2Index--) {
            if (nums2[nums2Index] >= nums1[leftIndex]) {
                // 进入这里比较清晰，没啥好说
                nums1[rightIndex] = nums2[nums2Index];
                rightIndex--;
            }
            else {
                // 写成do while就少一次比较
                do {
                    // 这里就不断进行比较，nums1中的值移动
                    nums1[rightIndex] = nums1[leftIndex];
                    leftIndex--;
                    rightIndex--;
                }
                while (nums2[nums2Index] < nums1[leftIndex]);

                // 跳出上面while证明 要移动nums2中的值
                nums1[rightIndex] = nums2[nums2Index];
                rightIndex--;
            }
        }

        return nums1;
    }




}
