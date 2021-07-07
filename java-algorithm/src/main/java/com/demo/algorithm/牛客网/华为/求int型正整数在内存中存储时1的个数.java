package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;

/**
 题目描述
 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。

 输入描述:
 输入一个整数（int类型）

 输出描述:
 这个数转换成2进制后，输出1的个数

 示例1
 输入
 5
 输出
 2

 * */
public class 求int型正整数在内存中存储时1的个数 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            String binaryString = Integer.toBinaryString(num);
            int count = 0;
            for (int i=0; i<binaryString.length(); i++) {
                if (binaryString.charAt(i) == '1') {
                    count++;
                }
            }
            System.out.println(count);
            System.out.println(numberOf1(num));
        }
    }



    /**
     这个记住规律，一般写业务代码不会经常写想位运算

     举个例子：一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，因此得到的结果是1011.
     我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，从原来整数最右边一个1那一位开始所有位都会变成0。如1100&1011=1000.

     也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     * */
    public static int numberOf1(int num) {
        int count=0;
        while(num != 0){
            count++;
            num = num&(num-1);
        }
        return count;
    }


}
