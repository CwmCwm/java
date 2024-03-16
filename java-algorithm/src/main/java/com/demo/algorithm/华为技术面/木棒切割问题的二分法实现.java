package com.demo.algorithm.华为技术面;

import java.util.Arrays;

/**
 * 问题描述：
 * 给出N根木棒，长度均已知，现在希望通过切割它们来得到至少K段长度相等的木棒（长度必须为整数），问这些长度相等的木棒最长能有多长。
 *
 * 思路：
 * 对于该问题，如果长度相等的木棒的长度L越长，那么可以得到的木棒段数k越少。
 * 从这个角度出发，我们便可以想到运用二分法的思想，根据对当前长度L来说能得到的木棒段数k与K的大小关系来进行二分。
 * 由于这个问题可以写成求解最后一个满足条件“k>=K”的长度L，因不妨转换为求解第一个满足“k<K”的长度L，然后减1即可。
 */
public class 木棒切割问题的二分法实现 {

    public static void main(String[] args) {
//        int[] lens = {10, 24, 16};		//每根木棒的长度
//        int K = 7;		                //需要切割得到的最少的木棒的段数
//        int[] lens = {7, 14, 21};
//        int K = 3;
        int[] lens = {7, 11, 36};
        int K = 3;


        Arrays.sort(lens);              //对木棒进行升序排序
        System.out.println(method1(lens, K));
    }


    //算法1：拿最长的木棒对半的长度作为初始长度L，看这个长度L能切出多少根（记为k）
    //      如果k<K，那么长度L得缩短（用二分法重新计算长度L）
    //      如果k>=K，那么长度L试着加长（用二分法重新计算长度L）
    //@param    lens    所有木棒（对木棒进行升序排序）
    //@param    K       K段长度相等的木棒
    //@return           这些长度相等的木棒最长长度
    public static int method1(int[] lens, int K) {
        int N = lens.length;
        int L = 0;
        int LLeft = 0;          //木棒最长长度用区间慢慢逼近，这是左边界
        int LRight = lens[N-1]; //木棒最长长度用区间慢慢逼近，这是右边界

        while (LLeft < LRight-1) {
            L = (LLeft + LRight) / 2;

            int k = calcNum(lens, L);
            //如果k<K，那么长度L得缩短（用二分法重新计算长度L）
            if (k < K) {
                LRight = L;
            }
            //如果k>=K，那么长度L试着加长（用二分法重新计算长度L）
            else {
                LLeft = L;
            }

            System.out.println("L=" + L + ", k=" + k + ", [" + LLeft + "," + LRight + "]");
        }

        return LLeft;
    }

    //计算每段切割的长度为L时对应的木棒段数k
    //@param    lens    所有木棒
    //@param    L       切割的长度
    //@return   返回能切出满足L长度的木棒段数
    public static int calcNum(int[] lens, int L) {
        int num = 0;
        int N = lens.length;
        for (int i=0; i<N; i++) {
            num = num + lens[i] / L;
        }
        return num;
    }

}
