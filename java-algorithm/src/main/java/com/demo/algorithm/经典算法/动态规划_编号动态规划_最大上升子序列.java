package com.demo.algorithm.经典算法;



/**

 编号动态规划：最大不下降子序列（最大上升子序列）
 本类的状态是基础的基础，大部分的动态规划都要用到它，成为一个维。
 最长不下降子序列定义：从序列中选出若干个数组成一个新的序列，不改变他们的队伍的顺序，要求新的序列里xi≤xi+1≤xi+1.....

 举个例子{4,6,5,7,3}，最长不下降子序列就是{4,6,7} 和 {4,5,7}。
 举个例子{1,7,2,8,3}，最长不下降子序列就是{1,2,3} 和 {1,7,8} 都可以。

 子问题的表示：令dp[i]表示以第i个元素结尾的前i个元素构成的最长不下降子序列的长度
 优化子结构：若最长不下降子序列包括ak，则必有一个解包含a1,a2…ak-1的最长不下降子序列，dp[i]表示为前i个元素的序列的最长不下降子序列
 方程： dp[i] = max{dp[j] | 0<j<i , aj≥ai} + 1


 * */
public class 动态规划_编号动态规划_最大上升子序列 {


    // 需要debug才能初步理解，因为你要debug才知道   b数组 和 c数组的语义是什么
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        // a数组是输入，b数组是a数组对应子问题的方法存根，所以b数组长度和a数组长度一样
        // b数组用来记录点i到n的最长不下降子序列的长度,length=10
        int[] a = {3, 18, 7, 14, 10, 12, 23, 41, 16, 24};
        int[] b = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

        // 就是把i从下标0开始到9的各个子序列的长度都存到b数组中，为后面输出最长的那个子序列做准备。
        // c数组用来存储i在最长的不下降子序列的后继数据编号,length=10
        // c数组的下标就是a数组下标（都是编号的意思，这里是从0到9的编号），c数组某个下标对应的值的解释（该下标是上升子序列开始下标startIndex,值是上升子序列结束下标endIndex）
        int[] c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // 就像链表里面的next一样，为输出完整的子序列的顺序做准备
        // n为数组的长度，i,j为遍历数组时候用的下标，max用来存储以当前i下标为起点的子序列中最长的那个的长度。p用来指示出现最大长度的那个下标位置，为后面的c数组服务的。
        int n=10, i, j, max, p;
        for (i=n-2; i>=0; i--) {
            // 开始遍历了，顺序是从后往前开始遍历，实际上是从倒数第二个数字开始查找。
            max = 0;
            p = 0;
            for (j=i+1; j<n; j++) {
                // 下面的这一句为本算法的关键步骤。判断是否a[i]<a[j]，且同时还需要满足当前记录点i的情况下，是否是大于max，因为有空能，a[i]<a[j]，但后面的a[j]之间并不是递增的。
                if ((a[i]<a[j]) && (b[j]>max)) {
                    max = b[j]; //满足条件时，将最大的记录点保存起来
                    p = j;      //存储j位置到p
                }
            }

            // 上面 关于j的for语句执行完毕后才开始执行下面的if语句。
            if (p != 0) {
                //表示有出现满足的条件，则把比较好的记录存到b,c数组中
                b[i] = b[p]+1;  //初始情况下b全部赋值为1，故最少都是+1的情况
                c[i] = p;       //c数组存储出现最长子序列的后一个的位置
            }
        }
        //至此，以上的for语句执行完毕

        //自己添加的语句，看看到底b,c数组中存储的数据
        for (int sum : b) {
            System.out.print(sum+" ");
        }

        System.out.println();
        for (int sum : c) {
            System.out.print(sum+" ");
        }


        max = 0;
        p = 0;
        for (i=0; i<n; i++) {
            //找到b数组中最长的那个子序列的大小，存到max，位置i，存到中。
            if (b[i] > max) {
                max = b[i];
                p = i;
            }
        }
        System.out.println();
        System.out.println("maxlong="+max);
        System.out.print("result is:");

        //我用的算法书使用伪代码写的，以下为我自己改编的
        while (true) {
            if (c[p] != 0) {
                //表示那个最长子序列还有下一个
                System.out.print(a[p]+" ");//从数组a中找到并输出
                p=c[p];
            } else {
                //从c数组中找到下一个位置
                // 这种情况为已经输到倒数第二个了
                System.out.print(a[p]+" ");//输出最后一个
                break;//跳出，程序结束
            }
        }
    }


}
