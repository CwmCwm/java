package com.demo.algorithm.牛客网.华为;

import java.io.*;

/**

 题目描述
 有一个数据表格为二维数组（数组元素为int类型），行长度为ROW_LENGTH,列长度为COLUMN_LENGTH。对该表格中数据的操作可以在单个单元内，也可以对一个整行或整列进行操作，操作包括交换两个单元中的数据；插入某些行或列。

 请编写程序，判断对表格的各种操作是否合法。

 详细要求:
 1.数据表规格的表示方式为“行*列”, 数据表元素的位置表示方式为[行,列]，行列均从0开始编号
 2.数据表的最大规格为9行*9列，对表格进行操作时遇到超出规格应该返回错误
 3.插入操作时，对m*n表格，插入行号只允许0~m，插入列号只允许0~n。超出范围应该返回错误
 4.只需记录初始表格中数据的变化轨迹，查询超出初始表格的数据应返回错误


 输入描述:
 输入数据按下列顺序输入：
 1 表格的行列值
 2 要交换的两个单元格的行列值
 3 输入要插入的行的数值
 4 输入要插入的列的数值
 5 输入要获取运动轨迹的单元格的值

 输出描述:
 输出按下列顺序输出：
 1 初始化表格是否成功，若成功则返回0， 否则返回-1
 2 输出交换单元格是否成功
 3 输出插入行是否成功
 4 输出插入列是否成功
 5 输出要查询的运动轨迹的单元查询是否成功

 示例1
 输入
 3 4
 1 1
 0 1
 2
 1
 2 2
 输出
 0
 0
 0
 0
 0

 TODO  读题累

 * */
public class 二维数组操作 {

    public static void main(String[] args)throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String input=null;
        while((input=reader.readLine())!=null){
            int r=0;
            int c=0;
            String[] s=input.split(" ");
            r=Integer.parseInt(s[0]);
            c=Integer.parseInt(s[1]);
            if(c>=0&&c<=9&&r>=0&&r<=9)System.out.println(0);
            else System.out.println(-1);
            r=Math.min(r,9);
            c=Math.min(c,9);
            int r1=0,c1=0,r2=0,c2=0;
            s=reader.readLine().split(" ");
            r1=Integer.parseInt(s[0]);
            c1=Integer.parseInt(s[1]);
            r2=Integer.parseInt(s[2]);
            c2=Integer.parseInt(s[3]);
            if(c1>=0&&c1<c&&r1>=0&&r1<r&&c2>=0&&c2<c&&r2>=0&&r2<r)System.out.println(0);
            else System.out.println(-1);
            int ic=0;
            int ir=0;
            ir=Integer.parseInt(reader.readLine());
            ic=Integer.parseInt(reader.readLine());
            if(ir>=0&&ir<r&&(r+1)<=9)System.out.println(0);
            else System.out.println(-1);
            if(ic>=0&&ic<c&&(c+1)<=9)System.out.println(0);
            else System.out.println(-1);
            int qr=0,qc=0;
            s=reader.readLine().split(" ");
            qr=Integer.parseInt(s[0]);
            qc=Integer.parseInt(s[1]);
            if(qr>=0&&qr<r&&qc>=0&&qc<c)System.out.println(0);
            else System.out.println(-1);
        }
    }


}
