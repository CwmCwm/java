package com.demo.algorithm.牛客网.华为;


import java.io.*;
import java.util.*;

/**
 题目描述
 开发一个简单错误记录功能小模块，能够记录出错的代码所在的文件名称和行号。

 处理：
 1、 记录最多8条错误记录，循环记录（或者说最后只输出最后出现的八条错误记录），对相同的错误记录（净文件名（保留最后16位）称和行号完全匹配）只记录一条，错误计数增加；
 2、 超过16个字符的文件名称，只记录文件的最后有效16个字符；
 3、 输入的文件可能带路径，记录文件名称不能带路径。


 输入描述:
 一行或多行字符串。每行包括带路径文件名称，行号，以空格隔开。

 输出描述:
 将所有的记录统计并将结果输出，格式：文件名 代码行数 数目，一个空格隔开，如：

 示例1
 输入
 E:\V1R2\product\fpgadrive.c   1325
 输出
 fpgadrive.c 1325 1



 TODO  这下面是对语义的理解
 有2个坑：
 1.循环遍历：
 只以第一次出现的顺序为准，后面重复的不会更新它的位置，仍以第一次为准

 2.净文件名=最后一个斜杠后面的带后缀名的部分，不是全全路径名


 * */
public class 简单错误记录 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> countMap = new HashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] ns = line.split(" ");
            String[] ls = ns[0].split("\\\\");
            String lastName = ls[ls.length-1];
            lastName = lastName.length() > 16 ? lastName.substring(lastName.length()-16) : lastName;
            String key = lastName + " " + Integer.valueOf(ns[1]);

            //如果map还没有记录该key，就添加key，计数=1
            if (countMap.get(key) == null) {
                countMap.put(key, 1);
                if (queue.size() == 8) {
                    queue.poll();
                }
                queue.add(key);
            }
            else {
                countMap.put(key, countMap.get(key) + 1);
            }
        }

        for(String s : queue) {
            System.out.println(s + " " + countMap.get(s));
        }

    }






// 主要对 LinkedHashMap 的理解
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str;
//        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
//        while((str = br.readLine()) !=null) {
//            String[] arr = str.split(" ");
//            String str1 = arr[0];
//            String str2 = arr[1];
//            str1 = str1.substring(str1.lastIndexOf("\\")+1);
//            if(str1.length()>16) str1 = str1.substring(str1.length()-16);
//            String str12 = str1 + " " + str2;
//            map.put(str12,map.getOrDefault(str12,0)+1);
//            int count = 0;
//
//        }
//        int count = 0;
//        for(String key:map.keySet()) {
//            count++;
//            if(count>(map.size()-8)) {
//                System.out.println(key+" "+map.get(key));
//            }
//        }
//    }


}
