package com.demo.algorithm.牛客网.华为;


import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”
 答案是5瓶，
 方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
   然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？

 输入描述:
 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。

 输出描述:
 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。

 输入例子1:
 3
 10
 81
 0

 输出例子1:
 1
 5
 40


 考察：输入流，本题算法

 * */
public class 汽水瓶 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int emptyBottle = in.nextInt();
            //本题存在多组输入。输入的 0 表示输入结束，并不用输出结果。
            if (emptyBottle == 0) {
                continue;
            }

            int drinkCount = 0;

            //3个空瓶换1瓶，就是每次换完喝完后-2个空瓶
            while (emptyBottle >= 3) {
                emptyBottle = emptyBottle - 2;
                drinkCount++;
            }

            //最后剩下2个空瓶就可以向老板借1个空瓶，喝完后还回去
            if (emptyBottle == 2) {
                drinkCount++;
            }

            System.out.println(drinkCount);
        }
    }



}
