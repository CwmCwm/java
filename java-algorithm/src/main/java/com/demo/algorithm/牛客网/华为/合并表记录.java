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
        while (sc.hasNext()) {
            int next = sc.nextInt();
            TreeMap<Integer,Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < next; i++) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                if (treeMap.containsKey(key)){
                    treeMap.put(key, treeMap.get(key)+value);
                } else {
                    treeMap.put(key,value);
                }
            }
            for (Map.Entry<Integer, Integer> integerIntegerEntry : treeMap.entrySet()) {
                System.out.println(integerIntegerEntry.getKey() + " " + integerIntegerEntry.getValue());
            }
        }
    }




}
