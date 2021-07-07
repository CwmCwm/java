package com.demo.algorithm.牛客网.华为;

import java.io.*;
import java.util.*;

/**

 题目描述
 查找和排序

 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 都按先录入排列在前的规则处理。

 例示：
 jack      70
 peter     96
 Tom       70
 smith     67

 从高到低  成绩
 peter     96
 jack      70
 Tom       70
 smith     67

 从低到高
 smith     67
 jack      70
 Tom       70
 peter     96

 注：0代表从高到低，1代表从低到高
 输入描述:
 输入多行，先输入要排序的人的个数，然后分别输入他们的名字和成绩，以一个空格隔开

 输出描述:
 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开

 示例1
 输入
 3
 0
 fang 90
 yang 50
 ning 70
 输出
 fang 90
 ning 70
 yang 50



 思路： 构建Student类，然后冒泡法   （其实写成比较器 Comparator 更好看）


 * */
public class 成绩排序 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =null ;
        while ((str=br.readLine())!=null) {
            int count = Integer.parseInt(str.trim());
            int flag = Integer.parseInt(br.readLine().trim());
            Student[] students = new Student[count];
            for(int i=0; i<count; i++) {
                String[] ss= br.readLine().trim().split(" ");
                String name=ss[0];
                int score =Integer.parseInt(ss[1]);
                Student student = new Student(name,score);
                students[i] = student;
            }

            //sort
            if(flag == 1) {
                for(int i=0;i<count;i++) {
                    for(int j=0;j<count-i-1;j++) {
                        if(students[j].score>students[j+1].score) {
                            Student tmp = students[j];
                            students[j] = students[j+1];
                            students[j+1] = tmp;
                        }
                    }
                }
            }else if(flag==0) {
                for(int i=0;i<count;i++) {
                    for(int j=0;j<count-i-1;j++) {
                        if(students[j].score<students[j+1].score) {
                            Student tmp = students[j];
                            students[j] = students[j+1];
                            students[j+1] = tmp;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<count;i++) {
                sb.append(students[i].name + " ");
                sb.append(students[i].score);
                if(i!=(count-1)) {
                    sb.append("\n");
                }
            }
            System.out.println(sb.toString());
        }

    }


    // 学生类
    private static class Student {
        String name;
        int score;
        public Student(String name,int score) {
            this.name=name;
            this.score=score;
        }
    }


}
