package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**
 题目描述
 题目标题：
 将两个整型数组按照升序合并，并且过滤掉重复数组元素[注: 题目更新了。输出之后有换行]

 输入描述:
 输入说明，按下列顺序输入：
 1 输入第一个数组的个数
 2 输入第一个数组的数值
 3 输入第二个数组的个数
 4 输入第二个数组的数值

 输出描述:
 输出合并之后的数组

 示例1
 输入
 3
 1 2 5
 4
 -1 0 3 2
 输出
 -101235


 * */
public class 整形数组合并 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            // 先去重
            Set<Integer> set = new HashSet<>();
            int n1 = in.nextInt();
            for (int i = 0; i < n1; i++){
                set.add(in.nextInt());
            }
            int n2 = in.nextInt();
            for (int i = 0; i < n2; i++){
                set.add(in.nextInt());
            }

            // 再排序
            int n3 = set.size();
            int[] arr = new int[n3];
            int k = 0;
            for (int i : set){
                arr[k] = i;
                k++;
            }
            Arrays.sort(arr);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < n3; i++){
                stringBuilder.append(arr[i]);
            }
            System.out.println(stringBuilder.toString());
        }
    }

}
