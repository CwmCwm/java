package com.demo.algorithm.牛客网.华为;



import java.util.*;

/**

 题目描述
 Catcher 是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
 比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），
 Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 （注意：记得加上while处理多个测试用例）

 输入描述:
 输入一个字符串

 输出描述:
 返回有效密码串的最大长度

 示例1
 输入
 ABBA
 输出
 4

 TODO  db不会？
 我是用之前的   对称去找的

 * */
public class 字符串运用_密码截取 {


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        String a=in.next();
        System.out.println(getString(a));
    }

    public static int getString(String a){
        char[] chararr = a.toCharArray();
        int len=chararr.length;
        if(len<2) {
            return len;
        }
        int start=0;
        int end=0;
        int maxLen=0;
        boolean[][] dp=new boolean[len][len];
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(chararr[i]==chararr[j]){
                    if(j-i<3) {
                        dp[i][j]=true;
                    } else {
                        dp[i][j]=dp[i+1][j-1];
                    }
                    if(dp[i][j]){
                        if(j-i+1>maxLen){
                            maxLen=j-i+1;
                            start=i;
                            end=j;
                        }
                    }
                }
            }
        }

        return maxLen;
    }


}
