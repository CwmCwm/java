package com.demo.algorithm.牛客网.华为;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**


 有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行（重新从头开始，删除第一个，后面同理），求最后一个被删掉的数的原始下标位置。
 以8个数(N=7)为例:
 ｛0，1，2-，3，4，5-，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),
  0-, 1, 3, 4-, 6, 7
  1-, 3, 6, 7-
  3-, 6
  6

 如此循环直到最后一个数被删除。

 等差数列  an=a1+(n-1)*d   d=3, 第一次a1=2，后面都是a1=0
 0, 1, 2-, 3, 4, 5-, 6, 7, 8-, 9, 10, 11-, 12, 13, 14-, 15, 16, 17-, 18
 0-, 1, 3, 4-, 6, 7, 9-, 10, 12, 13-, 15, 16, 18-
 1-, 3, 6, 7-, 10, 12, 15-, 16
 3-, 6, 10, 12-, 16
 6-, 10, 16
 10, 16
 16

 a[1]  => 0
 a[2]  => 1
 a[3]=a[1]    => 1
 a[4]         => 3
 a[5]=a[4]    => 3
 a[6]         => 3
 a[7]         => 6
 a[8]=a[7]    => 6
 a[9]=a[7]    => 6
 a[10]=a[7]   => 6
 a[11]  => 10
 a[12]  => 10
 a[13]  => 10
 a[14]  => 10
 a[15]  => 10
 a[16]  => 15
 a[17]  => 15


 输入描述:
 每组数据为一行一个整数n(小于等于1000)，为数组成员数,如果大于1000，则对a[999]进行计算。

 输出描述:
 一行输出最后一个被删掉的数的原始下标位置。

 输入例子1:
 8

 输出例子1:
 6


 TODO  不会？？？
 个人评价：示例给的有些微妙

 * */
public class 删数 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            num = num > 999 ? 999 : num;
            lastOne2(num);
        }
    }

    // 每隔2个数，删除1个数
    public static void lastOne(int num) {

    }

    // 这是归纳统计法，应该有数学证明吧
    // 这题转化为  Sn=[n*(a1+an)]/2  等差d=1,a1=1,an=n   Sn就是答案，如输入是8 <=>a[7]，那么最靠近7的Sn是6
    // 所以公式是  Sn=[n*(1+n)]/2
    public static void lastOne2(int num) {
        if (num == 1) {
            System.out.println(0);
            return;
        }

        int S = num -1;
        for (int n=1; n<100; n++) {
            int Sn = n*(1+n)/2;
            int Sn1 = (n+1)*(1+n+1)/2;
            if (Sn<=S && S<Sn1) {
                System.out.println(Sn);
            }
        }
    }


}
