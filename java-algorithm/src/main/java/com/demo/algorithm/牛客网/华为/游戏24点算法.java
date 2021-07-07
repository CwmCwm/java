package com.demo.algorithm.牛客网.华为;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 题目描述
 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 输入：
 4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字]
 输出：
 true or false

 输入描述:
 输入4个int整数

 输出描述:
 返回能否得到24点，能输出true，不能输出false

 示例1
 输入
 7 2 1 10
 输出
 true

 TODO  深度遍历？？

 * */
public class 游戏24点算法 {

    public static int []a;
    public static int []b;
    public static void init(){
        a = new int[4];
        b = new int[4];
    }

    public static boolean dfs(int x){
        boolean ed = true;
        for(int i=0;i<4;++i){
            if(b[i] == 0){
                ed = false;
                break;
            }
        }
        if(ed){
            if(x == 24)return true;
            else return false;
        }

        for(int i=0;i<4;++i){
            if(b[i] == 0){
                b[i] = 1;
                if(dfs(x+a[i]))return true;
                if(dfs(x-a[i]))return true;
                if(dfs(x*a[i]))return true;
                if((x % a[i] == 0) && (dfs(x / a[i])))return true;
                b[i] = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        init();
        while((str = bf.readLine()) != null && !"".equals(str)) {
            String[] nums = str.split(" ");

            for(int i=0;i<4;++i){
                a[i] = Integer.parseInt(nums[i]);
                b[i] = 0;
            }
            boolean flag = false;
            for(int i=0;i<4;++i){
                b[i] = 1;
                flag = dfs(a[i]);
                b[i] = 0;
                if(flag)break;
            }

            if(flag)System.out.println("true");
            else System.out.println("false");
        }
    }

}
