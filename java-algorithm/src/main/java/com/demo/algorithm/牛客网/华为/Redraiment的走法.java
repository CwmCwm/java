package com.demo.algorithm.牛客网.华为;

import java.io.*;
import java.util.*;


/**

 题目描述
 Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，不知道为什么？你能替Redraiment研究他最多走的步数吗？

 样输入
 6
 2 5 1 5 4 5

 样例输出
 3

 提示

 Example:
 6个点的高度各为 2 5 1 5 4 5
 如从第1格开始走,最多为3步, 2 4 5
 从第2格开始走,最多只有1步,5
 而从第3格开始走最多有3步,1 4 5
 从第5格开始走最多有2步,4 5
 所以这个结果是3。

 输入描述:
 输入多行，先输入数组的个数，再输入相应个数的整数

 输出描述:
 输出结果

 示例1
 输入
 6
 2
 5
 1
 5
 4
 5
 输出
 3



 * */
public class Redraiment的走法 {

    public static void main(String[] args) throws IOException{
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = read.readLine())!=null){
            int num = Integer.parseInt(input);
            String[] strs = read.readLine().split(" ");
            int[] nums = new int[num];
            int max = 0;
            for(int i=0;i<strs.length;i++){
                nums[i] = Integer.parseInt(strs[i]);
            }

            // TODO 理解困难
            int[] result = new int[num];
            for(int i=0; i<nums.length; i++){
                result[i]=1;
                for (int j=0; j<i; j++) {
                    if(nums[j]<nums[i]){
                        result[i]=Math.max(result[i],result[j]+1);
                    }
                }
            }

            max = 1;
            for(int i=0; i<result.length; i++){
                if (result[i]>max) {
                    max=result[i];
                }
            }
            System.out.println(max);
        }
    }


}
