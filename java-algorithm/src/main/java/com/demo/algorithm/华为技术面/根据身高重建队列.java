package com.demo.algorithm.华为技术面;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性(不一定按顺序)。每个people[i]= [hi，k]表示第i个人的身高为 hi，前面 正好有 k;个身高大于或等于 h;的人。
 * 请你重新构造并返回输入数组 people所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j]=[hi，ki]是队列中第」个人的属性(queue[0]是排在队列前面的人)
 *
 * 示例 1:
 * 输入:people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
 * 输出:         [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
 * 解释:
 * 编号为 0 的人身高为5，没有身高更高或者相同的人排在他前面。
 * 编号为 1 的人身高为7，没有身高更高或者相同的人排在他前面。
 * 编号为 2 的人身高为5，有2个身高更高或者相同的人排在他前面，即编号为 0 和 1 的人。
 * 编号为 3 的人身高为6，有1个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 编号为 4 的人身高为4，有4个身高更高或者相同的人排在他前面，即编号为 0、1、2、3 的人。
 * 编号为 5 的人身高为7，有1个身高更高或者相同的人排在他前面，即编号为 1 的人。
 * 因此[[5,0]，[7,0]，[5,2]，[6,1]，[4,4]，[7,1]] 是重新构造后的队列。
 *
 * 示例 2：
 * 输入：people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
 * 输出：         [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
 */
public class 根据身高重建队列 {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        //int[][] people = {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}};

        //格式化输出
        List<int[]> list = method1(people);
        for (int[] arr : list) {
            System.out.print(Arrays.toString(arr) + ",");
        }
    }



    //算法1：先从高到矮排序, 然后从左到右遍历, 前面有几个比他高的就插入到第几位
    public static List<int[]> method1(int[][] people) {
        //先从高到矮排序，冒泡
        for (int i=0; i<people.length-1; i++) {
            for (int j=i+1; j<people.length; j++) {
                if (people[i][0] < people[j][0]) {
                    int[] tmp = people[i];
                    people[i] = people[j];
                    people[j] = tmp;
                }
            }
        }

        //然后从左到右遍历, 前面有几个比他高的就插入到第几位
        //k值定义为排在h前面且身高大于或等于h的人数
        //因为从身高降序开始插入，此时所有人身高都大于等于h
        //因此k值即为需要插入的位置
        List<int[]> list = new ArrayList<>();
        for (int[] i : people) {
            list.add(i[1], i);
        }

        return list;
    }

}
