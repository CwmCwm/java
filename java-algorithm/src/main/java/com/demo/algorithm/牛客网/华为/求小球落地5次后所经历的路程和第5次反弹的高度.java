package com.demo.algorithm.牛客网.华为;

import java.util.Scanner;

/**
 题目描述
 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？

 最后的误差判断是小数点6位

 输入描述:
 输入起始高度，int型

 输出描述:
 分别输出第5次落地时，共经过多少米第5次反弹多高

 示例1
 输入
 1
 输出
 2.875
 0.03125

 * */
public class 求小球落地5次后所经历的路程和第5次反弹的高度 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int initHeight = scanner.nextInt();
            // sum是经历的路程   temp是上一次的高度
            double sum = 0;
            double temp = initHeight;
            for(int i=0; i<5; i++){
                sum += temp * 2;
                temp = temp / 2;
            }
            //第一次按它先弹上来再掉下去算的，要减掉第一次弹上来的路程
            sum -= initHeight;
            System.out.printf("%.6f\n",sum);
            System.out.printf("%.6f\n",temp);
        }
    }


}
