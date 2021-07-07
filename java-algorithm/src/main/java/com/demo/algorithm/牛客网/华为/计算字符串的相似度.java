package com.demo.algorithm.牛客网.华为;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 题目描述
 对于不同的字符串，我们希望能有办法判断相似程度，我们定义了一套操作方法来把两个不相同的字符串变得相同，具体的操作方法如下：
 1 修改一个字符，如把“a”替换为“b”。
 2 增加一个字符，如把“abdd”变为“aebdd”。
 3 删除一个字符，如把“travelling”变为“traveling”。

 比如，对于“abcdefg”和“abcdef”两个字符串来说，我们认为可以通过增加和减少一个“g”的方式来达到目的。上面的两种方案，都只需要一次操作。
 把这个操作所需要的次数定义为两个字符串的距离，而相似度等于“距离＋1”的倒数。也就是说，“abcdefg”和“abcdef”的距离为1，相似度为1/2=0.5.
 给定任意两个字符串，你是否能写出一个算法来计算出它们的相似度呢？

 输入描述:
 输入两个字符串

 输出描述:
 输出相似度，string类型

 示例1
 输入
 abcdef
 abcdefg
 输出
 1/2


 TODO  编辑距离，思路是动态规划
 计算两个字符串的距离 = 由一个字符串转换成另一个字符串所需的最少编辑操作次数。
 许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。

 * */
public class 计算字符串的相似度 {


    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = read.readLine()) != null){
            String str2 = read.readLine();
            System.out.println("1/"+stringDistance(input, str2));
        }
    }
    public static int stringDistance(String str1, String str2) {
        char[] a = str1.toCharArray();
        char[] b = str2.toCharArray();

        int[][] len = new int[a.length + 1][b.length + 1];
        for (int i = 0; i < a.length + 1; i++) {
            len[i][0] = i;
        }
        for (int j = 0; j <b.length + 1; j++) {
            len[0][j] = j;
        }
        for (int i = 1; i < a.length + 1; i++) {
            for (int j = 1; j < b.length + 1; j++) {
                if (a[i-1] == b[j-1]) {
                    len[i][j] = len[i-1][j-1];
                } else {
                    len[i][j] = Math.min(Math.min(len[i - 1][j], len[i - 1][j - 1]), len[i][j - 1]) + 1;
                }
            }
        }
        return len[a.length][b.length]+1;
    }

}
