package com.demo.algorithm.牛客网.华为;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 题目描述
 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
 注意每个输入文件有多组输入，即多个字符串用回车隔开
 输入描述:
 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。

 输出描述:
 删除字符串中出现次数最少的字符后的字符串。

 示例1
 输入
 abcdd
 输出
 dd

 * */
public class 删除字符串中出现次数最少的字符 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input=bufferedReader.readLine()) != null ) {
            char[] chars = input.toCharArray();
            // 统计
            Map<Character, Integer> hashMap = new HashMap<>();
            for (char x : chars) {
                hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
            }

            // 找出最少的次数
            int min = chars.length;
            for (Map.Entry<Character, Integer> map : hashMap.entrySet()) {
                if (map.getValue() < min) {
                    min = map.getValue();
                }
            }

            // 循环替换
            for (Map.Entry<Character, Integer> map : hashMap.entrySet()) {
                if (min == map.getValue()) {
                    String tmp = String.valueOf(map.getKey());
                    input = input.replace(tmp, "");
                }
            }

            System.out.println(input);
        }
    }


}
