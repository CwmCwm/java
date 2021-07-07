package com.demo.algorithm.初级算法.数组;


import java.util.*;

/**
 给定两个数组，编写一个函数来计算它们的交集。

 示例 1：
 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 输出：[2,2]

 示例 2:
 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出：[4,9]
  
 说明：
 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 我们可以不考虑输出结果的顺序。
 进阶：
 如果给定的数组已经排好序呢？你将如何优化你的算法？
 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？


 官方答案
 方法一：哈希表
 方法二：排序
   如果两个数组是有序的，则可以便捷地计算两个数组的交集。
   首先对两个数组进行排序，然后使用两个指针遍历两个数组。
   初始时，两个指针分别指向两个数组的头部。每次比较两个指针指向的两个数组中的数字，如果两个数字不相等，则将指向较小数字的指针右移一位，如果两个数字相等，将该数字添加到答案，并将两个指针都右移一位。当至少有一个指针超出数组范围时，遍历结束


 个人评价：方法一我想到了，    方法二确实，向这种思路，就是问题转化成另一种熟悉简化/有规律有组织的状态的问题


 * */
public class 两个数组的交集II {

    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};

        int[] nums3 = {4,9,5};
        int[] nums4 = {9,4,9,8,4};

        System.out.println(Arrays.toString(intersect2(nums1, nums2)));
        System.out.println(Arrays.toString(intersect2(nums3, nums4)));

    }


    // 简单的hash
    public static int[] intersect1(int[] nums1, int[] nums2) {
        // nums1 和 nums2 的大小区别
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            // Map.getOrDefault 方法
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);


//        HashMap<Integer, Integer> num1HashMap = new HashMap<>();
//        HashMap<Integer, Integer> intersectHashMap = new HashMap<>();
//        for (int x : nums1) {
//            // Map.getOrDefault  Map有这个方法就不用下面的判断代码，我也是才知道，我也不会一次性看所有方法
//            if (num1HashMap.containsKey(x)) {
//                num1HashMap.put(x, num1HashMap.get(x) + 1);
//            } else {
//                num1HashMap.put(x, 1);
//            }
//        }
//        for (int x : nums2) {
//            if (num1HashMap.containsKey(x) && intersectHashMap.containsKey(x) && intersectHashMap.get(x)<num1HashMap.get(x)) {
//                intersectHashMap.put(x, intersectHashMap.get(x) + 1);
//            }
//            if (num1HashMap.containsKey(x) && !intersectHashMap.containsKey(x)) {
//                intersectHashMap.put(x, 1);
//            }
//        }
//        List<Integer> list = new LinkedList<>();
//        for (Map.Entry<Integer, Integer> entry : intersectHashMap.entrySet()) {
//            for (int i=0; i<entry.getValue(); i++) {
//                list.add(entry.getKey());
//            }
//        }
//
//        // list.toArray(new Integer[list.size()])  这一写法在低版本的 Java 中推荐使用初始化大小的数组，openJDK 6 之后的高版本中方法被优化了
//        // return (Integer[]) list.toArray();
//        //Integer[] array = list.toArray(new Integer[0]);
//
//        // List, Integer[], int[]的相互转换  使用Java8的新特性方便转化
//        return list.stream().mapToInt(Integer::valueOf).toArray();
    }



    // 方法二：排序后进行对比
    public static int[] intersect2(int[] nums1, int[] nums2) {
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        // 判断越界，停止计算
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }



}
