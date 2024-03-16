package com.demo.algorithm.华为技术面;


/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 *
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 *
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        //String[] strings = {"flower","flow","flight"};
        String[] strings = {"dog","racecar","car"};
        //String[] strings = {"ab","a"};


        System.out.println(method1(strings));
    }

    public static String method1(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        if (strings.length == 1) {
            return strings[0];
        }

        String commonPrefix = strings[0];
        for (int i=1; i<strings.length; i++) {
            //只需匹配最短长度
            int min = Math.min(commonPrefix.length(), strings[i].length());
            commonPrefix = commonPrefix.substring(0, min);

            //遍历匹配
            for (int index=0; index<min; index++) {
                if (commonPrefix.charAt(index) != strings[i].charAt(index)) {
                    commonPrefix = commonPrefix.substring(0, index);
                    break;
                }
            }
        }

        return commonPrefix;
    }

}
