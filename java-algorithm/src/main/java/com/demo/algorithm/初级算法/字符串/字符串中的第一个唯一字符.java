package com.demo.algorithm.初级算法.字符串;

import java.util.HashMap;
import java.util.Map;



/**
 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

 示例：
 s = "leetcode"
 返回 0

 s = "loveleetcode"
 返回 2
  
 提示：你可以假定该字符串只包含小写字母。

 * */
public class 字符串中的第一个唯一字符 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
        System.out.println(firstUniqChar("loveleetcode"));

    }

    // 第一次遍历统计，第二次遍历为了顺序
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i=0; i<chars.length; i++) {
            map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
        }

        for (int i=0; i<chars.length; i++) {
            if (map.get(chars[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

}
