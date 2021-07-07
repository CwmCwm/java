package com.demo.algorithm.初级算法.字符串;

import java.util.Arrays;


/**

 示例 1:
 输入: 123
 输出: 321

 示例 2:
 输入: -123
 输出: -321

 示例 3:
 输入: 120
 输出: 21

 注意:
 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

 * */
public class 整数反转 {

    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));

    }

    /**
     https://leetcode-cn.com/problems/reverse-integer/solution/zheng-shu-fan-zhuan-by-leetcode/
     入栈出栈的另一种写法（不借助栈工具）
     * */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // 末尾出栈，注意这里是有符号的
            int pop = x % 10;
            x /= 10;
            // 溢出判断
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            // 末尾进栈，完成反转
            rev = rev * 10 + pop;
        }
        return rev;
    }


}
