package com.demo.algorithm.华为技术面;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 面试1 {

    public static void main(String[] args) {

//        int[] nums1 = {1,2,3,0,0,0};
//        int[] nums2 = {2,5,6};
        int[] nums1 = {1,10,20,0,0,0};
        int[] nums2 = {2,5,6};
        System.out.println(Arrays.toString(sort2(nums1, nums2)));
    }




    //算法1：很像滑动窗口
    //num1的数组大小 = num1的有效数组大小 + num2的有效数组大小
    public static int[] sort1(int[] nums1, int[] nums2) {
        //rightIndex 和 leftIndex 都是 nums1的下标
        //rightIndex是num1的最大下标
        //leftIndex 是num1的有效数组最大下标
        int rightIndex = nums1.length-1;
        int leftIndex = nums1.length-nums2.length-1;

        //从后遍历nums2
        for (int nums2Index=nums2.length-1; nums2Index>=0; nums2Index--) {
            if (nums2[nums2Index] >= nums1[leftIndex]) {
                //进入这里比较清晰，没啥好说
                nums1[rightIndex] = nums2[nums2Index];
                rightIndex--;
            }
            else {
                //写成do while就少一次比较
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

    //算法2：两个数组都从后遍历，然后将大数从nums1最右边放入
    public static int[] sort2(int[] nums1, int[] nums2) {
        int nums1Last = nums1.length-1;                 //nums1的最右下标
        int nums1Index = nums1.length-nums2.length-1;   //nums1的有效数字最右下标
        int nums2Index = nums2.length-1;                //nums2的有效数字最右下标

        //两个数组都从后遍历，然后将大数从nums1最右边放入
        while (nums1Index>-1 && nums2Index>-1) {
            if (nums1[nums1Index] > nums2[nums2Index]) {
                nums1[nums1Last] = nums1[nums1Index];
                nums1Last--;
                nums1Index--;
            }
            else {
                nums1[nums1Last] = nums2[nums2Index];
                nums1Last--;
                nums2Index--;
            }
        }

        //如果是nums2先遍历完（即nums2Index先等于-1），那nums1剩余的数字位置不用移动
        //如果是nums1先遍历完（即nums1Index先等于-1），那nums2剩余的数字就要往nums1中依次放入
        if (nums1Index == -1) {
            while (nums2Index>-1) {
                nums1[nums1Last] = nums2[nums2Index];
                nums1Last--;
                nums2Index--;
            }
        }

        return nums1;
    }


}
