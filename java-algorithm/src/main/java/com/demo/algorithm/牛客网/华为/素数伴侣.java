package com.demo.algorithm.牛客网.华为;


import java.util.ArrayList;
import java.util.Scanner;

/**
 素数 = 质数

 题目描述
 题目描述
 若两个正整数的和为素数，则这两个正整数称之为“素数伴侣”，如2和5、6和13，它们能应用于通信加密。现在密码学会请你设计一个程序，从已有的N（N为偶数）个正整数中挑选出若干对组成“素数伴侣”，挑选方案多种多样，例如有4个正整数：2，5，6，13，如果将5和6分为一组中只能得到一组“素数伴侣”，而将2和5、6和13编组将得到两组“素数伴侣”，能组成“素数伴侣”最多的方案称为“最佳方案”，当然密码学会希望你寻找出“最佳方案”。

 输入:

 有一个正偶数N（N≤100），表示待挑选的自然数的个数。后面给出具体的数字，范围为[2,30000]。

 输出:

 输出一个整数K，表示你求得的“最佳方案”组成“素数伴侣”的对数。



 输入描述:
 输入说明
 1 输入一个正偶数n
 2 输入n个整数

 输出描述:
 求得的“最佳方案”组成“素数伴侣”的对数。

 示例1
 输入
 4
 2 5 6 13
 输出
 2


 TODO 二分图最大匹配，匈牙利算法   ？？？
 思路： 素数一定是奇数

 * */
public class 素数伴侣 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            //获取并存储输入数据
            int num = sc.nextInt();
            int[] nums = new int[num];
            for (int i=0; i<num; i++) {
                nums[i] = sc.nextInt();
            }

            //偶数一定不是质数，那么一个奇数 + 一个偶数 = 奇数（这个奇数才可能是质数）
            //所以将输入的num个整数进行奇数和偶数分类
            ArrayList<Integer> odds = new ArrayList<>(); //奇数部分
            ArrayList<Integer> evens = new ArrayList<>();//偶数部分
            for (int i=0; i<num; i++) {
                if (nums[i] % 2 == 0) {
                    evens.add(nums[i]);
                }
                else {
                    odds.add(nums[i]);
                }
            }


            //然后利用匈牙利算法找到“素数伴侣”对数最多时的配对数。匈牙利算法的核心思想是先到先得，能让就让。
            int[] evensMatch = new int[evens.size()];//下标对应已经匹配的偶数的下标，值对应这个偶数的伴侣
            int result = 0;                          //记录伴侣的对数
            for (int i=0; i<odds.size(); i++) {
                int[] used = new int[evens.size()];  //用于标记对应的偶数是否查找过
                //如果匹配上，则计数加1
                if (find(odds.get(i), evens, used, evensMatch)) {
                    result++;
                }
            }
            System.out.println(result);

        }
        sc.close();
    }




    //判断奇数x能否找到伴侣
    public static boolean find(int x, ArrayList<Integer> evens, int[] used, int[] evensMatch) {
        int j;
        for (j=0; j<evens.size(); j++) {
            //该位置偶数没被访问过，并且能与x组成素数伴侣

            if (isPrime(x + evens.get(j)) && used[j]==0) {
                used[j] = 1;
                //如果i位置偶数还没有伴侣，则与x组成伴侣，
                //如果i位置偶数已经有伴侣，并且这个伴侣能重新找到新伴侣，
                //则把原来伴侣让给别人，自己与x组成伴侣
                if (evensMatch[j]==0 || find(evensMatch[j], evens, used, evensMatch)) {
                    evensMatch[j] = x;
                    return true;
                }
            }
        }

        return false;
    }

    //判断入参是否为质数（素数）
    //短除法
    public static boolean isPrime(int num) {
        //1不是质数
        if (num == 1) {
            return false;
        }

        //2是质数
        if (num == 2) {
            return true;
        }

        //3以上的数（包括3），短除法，边界是该数的平凡根
        for (int i=2; i<Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        //短除法到该数的平凡根，仍没法整除，就证明是质数
        return true;
    }

}
