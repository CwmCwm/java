package com.demo.algorithm.牛客网.华为;


import java.util.Scanner;
import java.util.LinkedHashMap;

/**

 输入描述:
 输入候选人的人数，第二行输入候选人的名字，第三行输入投票人的人数，第四行输入投票。

 输出描述:
 每行输出候选人的名字和得票数量。

 示例1
 输入
 4
 A B C D
 8
 A B C D E F G H
 输出
 A : 1
 B : 1
 C : 1
 D : 1
 Invalid : 4

 * */
public class 计票统计 {


    //HashMap是无序的（只是说不是你插入时的顺序）；
    //LinkedHashMap是有序的（按你插入的顺序）；
    //TreeMap 是按key排序的；
    //之前用hashmap不行，换成Linkedhaspmap
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //候选人
            int n = sc.nextInt();
            sc.nextLine();
            LinkedHashMap<String,Integer> hm = new LinkedHashMap<String,Integer>();
            for(int i = 0; i < n; i++){
                String name = sc.next();
                hm.put(name,0);
            }

            //投票
            n = sc.nextInt();
            sc.nextLine();
            int invalid = 0;
            for(int i = 0;i < n; i++){
                String vote = sc.next();
                if(hm.containsKey(vote)){
                    hm.put(vote,hm.get(vote) + 1);
                }else{
                    invalid++;
                }
            }

            for(String key : hm.keySet()){
                System.out.println(key + " : " + hm.get(key));
            }
            System.out.println("Invalid : " + invalid);
        }
    }


}
