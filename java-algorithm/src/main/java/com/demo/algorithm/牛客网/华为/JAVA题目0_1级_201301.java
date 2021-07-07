package com.demo.algorithm.牛客网.华为;

import java.util.*;

/**

 题目描述
 编写一个函数，传入一个int型数组，返回该数组能否分成两组，使得两组中各元素加起来的和相等，并且，所有5的倍数必须在其中一个组中，所有3的倍数在另一个组中（不包括5的倍数），能满足以上条件，返回true；不满足时返回false。

 输入描述:
 第一行是数据个数，第二行是输入的数据

 输出描述:
 返回true或者false

 示例1
 输入
 4
 1 5 -5 1
 输出
 true



 * */
public class JAVA题目0_1级_201301 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            // list存放 既不是3的倍数，又不是5的倍数的 数
            LinkedList<Integer> list = new LinkedList<>();
            int n = in.nextInt();
            // sum5是5的倍数的数的总和   sum3是3的倍数的数的总和    sum是所有数的总和
            int sum5 = 0;
            int sum3 = 0;
            int sum = 0;
            for (int i = 0; i < n; i++){
                int cur = in.nextInt();
                if (cur % 5 == 0){
                    sum5 += cur;
                }else if (cur % 3 == 0){
                    sum3 += cur;
                }else{
                    list.add(cur);
                }
                sum += cur;
            }

            // TODO  ？？？这target
            int target = sum/2 - sum3;
            if (sum % 2 != 0) {
                // 所有数总和是奇数，不可能平分，偶数才可能平分
                System.out.println("false");
            } else {
                System.out.println(helper(list, target));
            }
        }
    }

    private static boolean helper(LinkedList<Integer> list, int target){
        return helper(0, list, target);
    }

    private static boolean helper(int l, LinkedList<Integer> list, int target){
        if (l == list.size()) {
            return target == 0;
        }
        return helper(l + 1, list, target - list.get(l)) || helper(l + 1, list, target);
    }


}
