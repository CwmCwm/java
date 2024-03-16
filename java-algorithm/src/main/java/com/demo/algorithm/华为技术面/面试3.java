package com.demo.algorithm.华为技术面;



/**
 * 哥德巴赫猜想中任意一个大于3的数都可以由多个素数组成。
 * 打印出4-100的可以有两个素数组成的数，如 4=2+2, 5=2+3, 6=3+3， 7=2+5
 */
public class 面试3 {

    public static void main(String[] args) {
        int count = 0;
        for (int i=4; i<=100; i++) {
            if (isContainBy2(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    // 判断 num 是否可以由两个素数组成
    public static boolean isContainBy2(int num) {
        int endNum = num/2+1;
        for (int i=2; i<endNum; i++) {
            int num_i = num-i;
            if (isSuShu(i) && isSuShu(num_i)) {
                System.out.println(num + "=" + i + "+" + num_i);
                return true;
            }
        }
        return false;
    }

    //算法1：短除法，判断是否为素数（边界的判断，第一种边界是除到底；第二种边界是对半；第三种边界是平方根）
    public static boolean isSuShu(int num1) {
        if (num1 == 2) {
            return true;
        }

        int start = 2;
        int bianJie1 = num1;                //这个边界要 <
        int bianJie2 = num1/2;              //这个边界要 <=
        double bianJie3 = Math.sqrt(num1);  //这个边界要 <=

        while (start <= bianJie2) {
            if ((num1%start) == 0) {
                return false;
            }
            start++;
        }
        return true;
    }

}
