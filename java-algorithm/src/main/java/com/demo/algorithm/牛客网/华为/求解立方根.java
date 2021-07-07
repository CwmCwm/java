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
        //0.1*0.1*0.1=0.0001
        double l = 0.0, r = d;
        while (r - l > 0.0001) {
            double mid = (r + l) / 2;
            if(Math.pow(mid, 3) < d){
                l = mid;
            }else{
                r = mid;
            }
        }
        if(Math.pow(Math.round(r),3) == d){ //216的开方 6.0，精益求精，5.9
            System.out.printf("%.1f", (double) Math.round(r));
        }else{
            System.out.printf("%.1f", r);
        }
    }

}
