package com.demo.algorithm.华为技术面;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
 * 请你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 *
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 *
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class 三数之和 {

    public static void main(String[] args) {
        //int[] nums = {-1,0,1,2,-1,-4};
        //int[] nums = {0,1,1};
        int[] nums = {0,0,0};

        System.out.println(method1(nums));
    }

    //算法1：3个下标i,j,k分别从左开始进行组合，判断这3个下标对应的值相加是否为0
    public static String method1(int[] nums) {
        if (nums.length<3) {
            return "[]";
        }

        StringBuilder stringBuilder = new StringBuilder("[");
        int i=0;
        int j=1;
        int k=2;
        while (i<nums.length-2) {
            while (j<nums.length-1) {
                while (k<nums.length) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        stringBuilder.append("[" +nums[i] + "," + nums[j] + "," + nums[k] + "],");
                        break;
                    }
                    k++;
                }
                j++;
                k=j+1;
            }
            i++;
            j=i+1;
        }

        //格式处理
        if (stringBuilder.length()>2) {
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}
