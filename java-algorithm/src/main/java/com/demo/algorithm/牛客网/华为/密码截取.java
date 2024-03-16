package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**

 题目描述
 Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？

 输入描述:
 输入一个字符串

 输出描述:
 返回有效密码串的最大长度

 示例1
 输入
 ABBA
 输出
 4



 思路：对称，要么有一个字符串为中心的对称（如 121 ，其中2就是中心）   要么没有中心对称（如 1221  ，就没有中心啊）

 * */
public class 密码截取 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            int max = 0;
            char[] arr = str.toCharArray();

            //i是数组的下标，遍历所有下标位置
            //以这个下标向左右两边对称比较，
            //一种是没有中心的对称
            //一种是以一个字符为中心的对称
            for (int i=1; i<arr.length; i++) {
                //没有中心对称（如 1221  ，就没有中心啊）
                int left = i-1;
                int right = i;
                while (left>=0 && right<arr.length && arr[left]==arr[right]) {
                    if (right-left+1 > max) {
                        max = right-left+1;
                    }
                    left--;
                    right++;
                }

                //有一个字符串为中心的对称（如 121 ，其中2就是中心）
                left = i-1;
                right = i+1;
                while (left>=0 && right<arr.length && arr[left]==arr[right]) {
                    if (right-left+1>max) {
                        max = right-left+1;
                    }
                    left--;
                    right++;
                }
            }
            System.out.println(max);
        }
    }



}
