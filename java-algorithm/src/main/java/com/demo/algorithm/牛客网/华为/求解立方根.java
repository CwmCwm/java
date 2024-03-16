package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;
/**
 •计算一个数字的立方根，不使用库函数
 详细描述：

 输入描述:
 待求解参数 double类型

 输出描述:
 输入参数的立方根 也是double类型

 示例1
 输入
 216
 输出
 6.0

 * */
public class 求解立方根 {

    // 二分法解方程，因为单调，精度到了0.1的三次方终止
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double d = scanner.nextDouble();

        //根据入参确定左右边界
        //0.1*0.1*0.1=0.0001
        double left = 0.0;
        double right = 0.0;
        if (d>1) {
            right = d;
        }
        else if (d>0 && d<1) {
            right = 1;
        }
        else if (d>-1 && d<0) {
            left = -1;
        }
        else {
            left = d;
        }

        //二分法遍历
        while (right - left > 0.0001) {
            double mid = (right + left) / 2;
            if(Math.pow(mid, 3) < d){
                left = mid;
            }
            else {
                right = mid;
            }
        }

        //解决刚好有确定的立方根，因为用二分法逼近，所以会存在求的逼近值，而不是精确值
        if (Math.pow(Math.round(right), 3) == d) {
            //216的开方 6.0，精益求精，5.9
            System.out.printf("%.1f", (double) Math.round(right));
        }
        else {
            System.out.printf("%.1f", right);
        }
    }

}
