package com.demo.algorithm.牛客网.华为;


import java.util.*;

/**
 题目描述
 数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

 输入描述:
 先输入键值对的个数
 然后输入成对的index和value值，以空格隔开

 输出描述:
 输出合并后的键值对（多行）

 示例1
 输入
 复制
 4
 0 1
 0 2
 1 2
 3 4
 输出
 复制
 0 3
 1 2
 3 4



 * */
public class 合并表记录 {


    // TreeMap 红黑树实现，遍历是按照key升序
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int count = 1;

        Map<Integer, Integer> map = new TreeMap<>();
        while (count<=num) {
            Integer index = sc.nextInt();
            Integer value = sc.nextInt();
            map.put(index, map.getOrDefault(index,0) + value);
            count++;
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }




}
